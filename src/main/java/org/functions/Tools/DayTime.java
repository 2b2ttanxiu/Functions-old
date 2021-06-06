package org.functions.Tools;

import org.bukkit.World;

public class DayTime {
    World world;
    Type type;
    enum Type {
        Day,
        dawn,
        noon,
        dusk,
        midnight,
        Time;
    }
    public DayTime(World World, org.functions.Tools.DayTime.Type Type) {
        this.type = Type;
        this.world = World;
    }

    public long getTime() {
        if (this.type == org.functions.Tools.DayTime.Type.Day) {
            return this.world.getFullTime() / 24000L;
        } else {
            return this.type == org.functions.Tools.DayTime.Type.Time ? this.world.getTime() / 20L * 1200L : 0L;
        }
    }

    public void setTime() {
        if (this.type == org.functions.Tools.DayTime.Type.dawn) {
            if (this.getTime() < 1L) {
                this.world.setTime(this.getTime());
            } else {
                this.world.setTime(this.world.getFullTime() + 1L);
            }
        }

        if (this.type == org.functions.Tools.DayTime.Type.noon) {
            if (8L <= this.getTime()) {
                this.world.setTime(this.world.getFullTime() + 1L + 1200L);
            }

            if (5L < this.getTime()) {
                this.world.setTime(this.getTime() + 1L);
            } else if (7L < this.getTime()) {
                this.world.setTime(this.getTime() - 1L);
            }
        }

        if (this.type == org.functions.Tools.DayTime.Type.dusk) {
            if (8L <= this.getTime()) {
                this.world.setTime(this.world.getFullTime() + 1L);
            }

            if (this.getTime() < 5L) {
                this.world.setTime(this.getTime() + 1L);
            } else if (this.getTime() == 7L) {
                this.world.setTime(this.getTime() - 1L);
            }
        }

    }
}