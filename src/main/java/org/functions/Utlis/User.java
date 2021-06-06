package org.functions.Utlis;

import java.util.Collection;
import java.util.UUID;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.functions.API.PlayerNMS;
import org.functions.Main.Functions;
import org.functions.net.minecraft.server.MCVersion;

public class User {
    private Functions f = Functions.getMain();
    public PlayerNMS nms = new PlayerNMS();

    public User() {
    }

    public void init(Player User) {
        Player Player = User.getPlayer();
        UUID uuid = Player.getUniqueId();
        String toString = uuid.toString();
        String UserName = Player.getName();
        String UserGameMode = Player.getGameMode().toString();
        String UserGroup = this.f.getGroup(UserName);
        String UserPrefix = this.f.getPrefix(UserGroup, UserName);
        String UserSuffix = this.f.getSuffix(UserGroup, UserName);
        String UserMCVersion = (new MCVersion()).toString();
        boolean UserOnline = Player.isOnline();
        this.f.getUser().set(toString + ".UserName", UserName);
        this.f.getUser().set(toString + ".UserGameMode", UserGameMode);
        this.f.getUser().set(toString + ".UserGroup", UserGroup);
        this.f.getUser().set(toString + ".UserPrefix", UserPrefix);
        this.f.getUser().set(toString + ".UserSuffix", UserSuffix);
        this.f.getUser().set(toString + ".UserMCVersion", UserMCVersion);
        this.f.getUser().set(toString + ".UserOnline", UserOnline);
        this.f.SaveConfig();
    }

    public Collection<? extends Player> UserOnlineList() {
        return this.nms.getOnlinePlayers();
    }

    public OfflinePlayer[] UserOfflineList() {
        return this.nms.getOffline();
    }
}