package org.functions.Utlis;

import org.bukkit.World;

public class Chunk extends ServerInfo {
    private World world;
    private int i = 0;

    public Chunk(World World) {
        this.world = World;
    }

    public org.bukkit.Chunk[] getLoadingChunk() {
        return this.world.getLoadedChunks();
    }

    public int getChunkCount() {
        org.bukkit.Chunk[] var1 = this.getLoadingChunk();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            org.bukkit.Chunk var10000 = var1[var3];
            ++this.i;
        }

        return this.i;
    }

    public String getUseChunk() {
        int use = 0;
        int dontuse = 0;
        org.bukkit.Chunk[] var3 = this.getLoadingChunk();
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            org.bukkit.Chunk chunk = var3[var5];
            if (this.world.isChunkInUse(chunk.getX(), chunk.getZ())) {
                ++use;
            } else {
                ++dontuse;
            }
        }

        return use + "," + dontuse;
    }

    public int useChunk() {
        return Integer.parseInt(this.getUseChunk().split(",")[0]);
    }

    public int NotUseChunk() {
        return Integer.parseInt(this.getUseChunk().split(",")[1]);
    }

    public void unloadChunk() {
        org.bukkit.Chunk[] var1 = this.getLoadingChunk();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            org.bukkit.Chunk chunk = var1[var3];
            if (!this.world.isChunkInUse(chunk.getX(), chunk.getZ())) {
                chunk.unload(true);
            }
        }

    }
}
