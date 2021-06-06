package org.functions.Utlis;

import java.util.UUID;
import org.bukkit.Server;
import org.bukkit.World;
import org.functions.API.PlayerNMS;

public class ServerInfo {
    private int Chucki = 0;
    private Runtime r;
    public PlayerNMS nms = new PlayerNMS();

    public ServerInfo() {
    }

    public RAM getRAM() {
        return new RAM();
    }

    public Runtime getRuntime() {
        return this.r;
    }

    public Chunk getChuck(World world) {
        return new Chunk(world);
    }

    public Server getServer() {
        return this.nms.getServer();
    }

    public World getWorld(UUID WorldUUID) {
        return this.getServer().getWorld(WorldUUID);
    }
}
