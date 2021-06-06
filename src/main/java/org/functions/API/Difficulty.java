package org.functions.API;

import org.bukkit.World;

public class Difficulty {
    World w;

    public Difficulty(World world) {
        this.w = world;
    }

    public void setDifficulty(Difficulty.Type type) {
        PlayerManger nms;
        if (type == Difficulty.Type.PEACEFUL) {
            nms = new PlayerManger();
            nms.getServer().getWorld(this.w.getName()).setDifficulty(org.bukkit.Difficulty.PEACEFUL);
        }

        if (type == Difficulty.Type.EASY) {
            nms = new PlayerManger();
            nms.getServer().getWorld(this.w.getName()).setDifficulty(org.bukkit.Difficulty.EASY);
        }

        if (type == Difficulty.Type.NORMAL) {
            nms = new PlayerManger();
            nms.getServer().getWorld(this.w.getName()).setDifficulty(org.bukkit.Difficulty.NORMAL);
        }

        if (type == Difficulty.Type.HARD) {
            nms = new PlayerManger();
            nms.getServer().getWorld(this.w.getName()).setDifficulty(org.bukkit.Difficulty.HARD);
        }

    }

    public Difficulty.Type getDifficulty() {
        PlayerNMS nms = new PlayerManger();
        if (nms.getServer().getWorld(this.w.getName()).getDifficulty() == org.bukkit.Difficulty.PEACEFUL) {
            return Difficulty.Type.PEACEFUL;
        } else if (nms.getServer().getWorld(this.w.getName()).getDifficulty() == org.bukkit.Difficulty.EASY) {
            return Difficulty.Type.EASY;
        } else if (nms.getServer().getWorld(this.w.getName()).getDifficulty() == org.bukkit.Difficulty.NORMAL) {
            return Difficulty.Type.NORMAL;
        } else {
            return nms.getServer().getWorld(this.w.getName()).getDifficulty() == org.bukkit.Difficulty.HARD ? Difficulty.Type.HARD : null;
        }
    }

    public static enum Type {
        PEACEFUL,
        EASY,
        NORMAL,
        HARD;

        private Type() {
        }
    }
}
