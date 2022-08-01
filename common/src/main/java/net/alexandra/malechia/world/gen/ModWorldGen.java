package net.alexandra.malechia.world.gen;

import net.alexandra.malechia.world.feature.ModOres;

public class ModWorldGen {
    public static void generateModWorldGen() {
        ModOres.initialize();
        ModTreeGeneration.generateTrees();
    }
}