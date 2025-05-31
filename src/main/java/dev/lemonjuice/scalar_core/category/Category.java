package dev.lemonjuice.scalar_core.category;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.horse.SkeletonHorse;
import net.minecraft.world.entity.animal.horse.ZombieHorse;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.*;

public class Category {

    /**
     * Checks if the entity is an undead entity.
     *
     * @param entity the entity to check
     * @return true if the entity is undead, false otherwise
     */
    public static boolean isUndeadEntity(LivingEntity entity) {
        return (entity instanceof Phantom ||
                entity instanceof AbstractSkeleton || // Bogged, Stray, Wither Skeleton
                entity instanceof SkeletonHorse ||
                entity instanceof WitherBoss ||
                entity instanceof Zoglin ||
                entity instanceof Zombie || // Drowned, Husk, Zombie Villager, Zombified Piglin
                entity instanceof ZombieHorse);
    }

    /**
     * Checks if the entity is an arthropod entity.
     *
     * @param entity the entity to check
     * @return true if the entity is an arthropod, false otherwise
     */
    public static boolean isArthropodEntity(LivingEntity entity) {
        return (entity instanceof Spider ||
                entity instanceof CaveSpider ||
                entity instanceof Silverfish ||
                entity instanceof Endermite);
    }

    /**
     * Checks if the entity is a dragon entity.
     * (Holding out hope for the Red Dragon in the future... even though it's been a decade.)
     *
     * @param entity the entity to check
     * @return true if the entity is a dragon, false otherwise
     */
    public static boolean isDragonEntity(LivingEntity entity) {
        return (entity instanceof EnderDragon);
    }

    /**
     * Checks if the entity is an ender entity.
     * This includes Endermen, Endermites, Shulkers, and the Ender Dragon.
     *
     * @param entity the entity to check
     * @return true if the entity is an ender entity, false otherwise
     */
    public static boolean isEnderEntity(LivingEntity entity) {
        return (entity instanceof EnderMan ||
                entity instanceof Endermite ||
                entity instanceof Shulker ||
                entity instanceof EnderDragon);
    }

    /**
     * Checks if the entity is a passive entity.
     * This includes animals and villagers, excluding neutral entities like wolves and iron golems.
     *
     * @param entity the entity to check
     * @return true if the entity is passive, false otherwise
     */
    public static boolean isPassiveEntity(LivingEntity entity) {
        return (entity instanceof net.minecraft.world.entity.animal.Animal ||
                entity instanceof net.minecraft.world.entity.npc.Villager ||
                entity instanceof net.minecraft.world.entity.npc.WanderingTrader);
    }
}
