package dev.lemonjuice.scalar_core.tier;

import net.minecraft.world.item.Tier;
import net.neoforged.neoforge.common.SimpleTier;

/**
 * Simple class that converts SimpleTiers to Vanilla Tiers.
 */
public class TierConverter {

    /**
     * Converts a SimpleTier to a Vanilla Tier.
     *
     * @param simpleTier the SimpleTier to convert
     * @return a Vanilla Tier equivalent to the given SimpleTier
     */
    public static Tier tierOf(SimpleTier simpleTier) {
        return (Tier) simpleTier; // Cast to Tier, as SimpleTier implements Tier
    }

    /**
     * Converts a Vanilla Tier to a SimpleTier.
     * WARNING: This should really not be used unless you are sure the Tier is a SimpleTier!
     *
     * @param tier the Vanilla Tier to convert
     * @return a SimpleTier equivalent to the given Vanilla Tier
     */
    public static SimpleTier simpleTierOf(Tier tier) {
        if (tier instanceof SimpleTier simpleTier) {
            return simpleTier; // Return the SimpleTier directly if it is already a SimpleTier
        }
        throw new IllegalArgumentException("Provided Tier is not a SimpleTier: " + tier.getClass().getName());
    }
}
