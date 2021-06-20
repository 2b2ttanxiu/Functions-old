package org.functions.API.world;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.generator.ChunkGenerator;

import java.util.Random;

public class ChunkData extends ChunkGenerator {
    String type;
    public ChunkData(String Type) {
        type = Type;
    }
    Biome grid;
    public Location getFixedSpawnLocation(World world, Random random) {
        return new Location(world, 0.0D, 64.0D, 0.0D);
    }

    public boolean isParallelCapable() {
        return true;
    }

    public boolean shouldGenerateMobs() {
        return true;
    }
    public void createLand(ChunkData paramChunkData, int paramChunkX, int paramChunkZ) {
        if (type.equalsIgnoreCase("void")) {
            if (0 >= paramChunkX << 4 && 0 < paramChunkX + 1 << 4 && 0 >= paramChunkZ << 4 && 0 < paramChunkZ + 1 << 4) {
                paramChunkData.setBlock(0, 63, 0, Material.BEDROCK);
            }
        }
    }

}
