package dev.lemonjuice.scalar_core.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;

public class InfiniteFluidBucketItem extends BucketItem {

    public InfiniteFluidBucketItem(Fluid content, Properties properties) {
        super(content, properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        // Call super to handle placement logic
        InteractionResultHolder<ItemStack> result = super.use(level, player, hand);

        // If placement succeeded, return the original stack (do not consume)
        if (result.getResult().consumesAction()) {
            return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), level.isClientSide());
        }
        // Otherwise, return the original result
        return result;
    }

}
