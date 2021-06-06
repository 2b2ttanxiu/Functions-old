package org.functions.API;

import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.World;
import org.functions.Main.Functions;

public class Death {
    private String UUID;
    private Functions a = Functions.getMain();
    private PlayerNMS nms = new PlayerNMS();
    private boolean is;

    public Death(UUID UUID) {
        this.UUID = UUID + "";
    }

    public boolean isDeath() {
        String uuid = this.UUID;
        if (this.a.getBack().getString(uuid) != null) {
            this.is = true;
        } else {
            this.is = false;
        }

        return this.is;
    }

    public void setDeath(String Location) {
        this.a.getBack().set(this.UUID + "", Location.toString());
        this.a.SaveConfig();
    }

    public void resetDeath() {
        this.a.getBack().set(this.UUID, (Object)null);
        this.a.SaveConfig();
    }

    public String[] getStringDeath() {
        return this.a.getBack().getString(this.UUID).split(",");
    }

    public Location getDeath() {
        String[] args = this.a.getBack().getString(this.UUID + "").split(",");
        World world = this.nms.getWorld(args[0]);
        double x = Double.parseDouble(args[1]);
        double y = Double.parseDouble(args[2]);
        double z = Double.parseDouble(args[3]);
        float yaw = Float.parseFloat(args[4]);
        float pitch = Float.parseFloat(args[5]);
        return new Location(world, x, y, z, yaw, pitch);
    }

    public String toString() {
        String[] args = this.a.getBack().getString(this.UUID).split(",");
        World world = this.nms.getWorld(args[0]);
        double x = Double.parseDouble(args[1]);
        double y = Double.parseDouble(args[2]);
        double z = Double.parseDouble(args[3]);
        float yaw = Float.parseFloat(args[4]);
        float pitch = Float.parseFloat(args[5]);
        String xs = Functions.getMain().getSettings().getString("List.Location");
        xs = xs.replace("%world%", world.getName());
        xs = xs.replace("%x%", x + "");
        xs = xs.replace("%y%", y + "");
        xs = xs.replace("%z%", z + "");
        xs = xs.replace("%yaw%", yaw + "");
        xs = xs.replace("%pitch%", pitch + "");
        return xs;
    }

    public void setDeath(location Location) {
    }
}