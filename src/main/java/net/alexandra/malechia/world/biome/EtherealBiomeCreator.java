package net.alexandra.malechia.world.biome;

import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.*;

public class EtherealBiomeCreator {
        private static Biome createEtherealBiome(GenerationSettings.Builder builder) {
            SpawnSettings.Builder builder2 = new SpawnSettings.Builder();
            return new Biome.Builder().precipitation(Biome.Precipitation.SNOW).temperature(0.5f).downfall(0.5f).effects(new BiomeEffects.Builder().waterColor(4159204).waterFogColor(329011).fogColor(0xA080A0).skyColor(0).moodSound(BiomeMoodSound.CAVE).build()).spawnSettings(builder2.build()).generationSettings(builder.build()).build();
        }

        public static Biome createEtherealCore() {
            GenerationSettings.Builder builder = new GenerationSettings.Builder();
            return EtherealBiomeCreator.createEtherealBiome(builder);
        }

        public static Biome createAwakenedEtherealCore() {
            GenerationSettings.Builder builder = new GenerationSettings.Builder();
            return EtherealBiomeCreator.createEtherealBiome(builder);
        }
}
