package org.functions.API;

import java.util.List;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.World;
import org.functions.Main.Functions;

public class Home {
    private Functions a = Functions.getMain();
    private UUID id;
    private boolean is;

    public Home(UUID UUID) {
        this.id = UUID;
    }

    public boolean of() {
        if (this.a.getHome().getString(this.id + "") == null) {
            this.is = false;
        } else {
            this.is = true;
        }

        return this.is;
    }

    public boolean ifPath(String Path) {
        if (this.a.getHome().getString(this.id + ".Homes." + Path) == null) {
            this.is = false;
        } else {
            this.is = true;
        }

        return this.is;
    }

    public void setList(List<String> Houses) {
        this.a.getHome().set(this.id + ".ListHome", Houses);
        this.a.SaveConfig();
    }

    public void set(String House, String Location) {
        this.a.getHome().set(this.id + ".Homes." + House, Location);
        this.a.SaveConfig();
    }

    public void reset(String House, String Location) {
        this.set(House, Location);
    }

    public List<String> getList() {
        return this.of() ? this.a.getHome().getStringList(this.id + ".ListHome") : this.a.getHome().getStringList(this.id + ".ListHome");
    }

    public String[] getLocation(String Home) {
        return this.a.getHome().getString(this.id + ".Homes." + Home).split(",");
    }

    public void remove(String House) {
        this.a.getHome().set(this.id + ".Homes." + House, (Object)null);
        this.a.SaveConfig();
    }

    public Location get(String Home) {
        String[] get = this.a.getHome().getString(this.id + ".Homes." + Home).split(",");
        World world = (new PlayerNMS()).getWorld(get[0]);
        double x = Double.parseDouble(get[1]);
        double y = Double.parseDouble(get[2]);
        double z = Double.parseDouble(get[3]);
        float yaw = Float.parseFloat(get[4]);
        float pitch = Float.parseFloat(get[5]);
        return new Location(world, x, y, z, yaw, pitch);
    }
}