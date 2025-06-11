package dev.lemonjuice.scalar_core.tier;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.SimpleTier;

import java.util.List;
import java.util.function.Supplier;

/**
 * Factory class for creating mid-tier tools based on two existing tiers.
 * This class provides methods to generate a new SimpleTier that is mid-tier
 * between two other tiers, and to determine the better tag for blocks based on
 * their properties.
 */
public class MidTierFactory {

    private static final List<TagKey<Block>> TAG_PRIORITY = List.of(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            BlockTags.INCORRECT_FOR_STONE_TOOL,
            BlockTags.INCORRECT_FOR_WOODEN_TOOL
    );


    /**
     * Creates a SimpleTier with properties that are mid-tier between 2 other tiers.
     *
     * @param tier1 the first tier
     * @param tier2 the second tier
     * @param repairItem a supplier for the item used to repair this tier
     * @return a SimpleTier with properties that are mid-tier between the two given tiers
     */
    public static SimpleTier generateMidTier(Tier tier1, Tier tier2, Supplier<Ingredient> repairItem) {
        return new SimpleTier(
                getBetterTag(tier1.getIncorrectBlocksForDrops(), tier2.getIncorrectBlocksForDrops()),
                (tier1.getUses() + tier2.getUses()) / 2,
                (tier1.getSpeed() + tier2.getSpeed()) / 2,
                (tier1.getAttackDamageBonus() + tier2.getAttackDamageBonus()) / 2,
                (tier1.getEnchantmentValue() + tier2.getEnchantmentValue()) / 2,
                repairItem
        );
    }

    /**
     * Gets the better of two tags for blocks, based on the properties on what the tag actually is.
     *
     * @param tag1 The first tag to compare
     * @param tag2 The second tag to compare
     * @return the tag that contains blocks with better properties, or null if both tags are null
     */
    public static TagKey<Block> getBetterTag(TagKey<Block> tag1, TagKey<Block> tag2) {
        for (TagKey<Block> tag : TAG_PRIORITY) {
            if (tag.equals(tag1) || tag.equals(tag2)) {
                return tag;
            }
        }
        return BlockTags.INCORRECT_FOR_WOODEN_TOOL;
    }
}
