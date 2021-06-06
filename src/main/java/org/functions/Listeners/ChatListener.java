package org.functions.Listeners;

import java.util.Iterator;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.functions.Main.Functions;
import org.functions.Tools.TPS;

public class ChatListener implements Listener {
    private Functions a = Functions.getMain();

    public ChatListener() {
    }

    @EventHandler
    public void run(AsyncPlayerChatEvent b) {
        b.setCancelled(true);
        long Long = System.currentTimeMillis();
        long l = this.a.getData().getLong(b.getPlayer().getName() + ".ChatTime");
        long L = Long - l;
        Iterator var8 = this.a.ListGroup().iterator();

        while(true) {
            while(true) {
                String x;
                do {
                    if (!var8.hasNext()) {
                        return;
                    }

                    x = (String)var8.next();
                } while(!this.a.getData().getString(b.getPlayer().getName() + ".Group").equals(x));

                if (!this.a.getGroup().getString(x + ".Delay.ChatTime").equals("none") && L <= this.a.getGroup().getLong(x + ".Delay.ChatTime")) {
                    b.getPlayer().sendMessage(this.a.String(1, "DelayChat", "Please wait %delay%s!").replace("%delay%", "" + (1000.0D - ((double)Long - (double)l)) / 1000.0D));
                    return;
                }

                this.a.getData().set(b.getPlayer().getName() + ".ChatTime", Long);
                this.a.SaveConfig();
                String msg;
                Iterator var11;
                String s;
                long used;
                Player p;
                Runtime r;
                long Lused;
                if (this.a.getGroup().getBoolean(x + ".Color")) {
                    msg = b.getMessage();
                    var11 = this.a.getGroup().getStringList(x + ".Anti-Key-Words.List").iterator();

                    while(var11.hasNext()) {
                        s = (String)var11.next();
                        if (msg.contains(s) && this.a.getGroup().getString(x + ".Anti-Key-Words.Replace." + s) != null) {
                            msg = msg.replace(s, this.a.getGroup().getString(x + ".Anti-Key-Words.Replace." + s));
                        }
                    }

                    if (this.a.getGroup().getBoolean(x + ".Blank_space")) {
                        msg = msg.replace("  ", " ");
                    }

                    msg = msg.replace("&", "§");
                    if (!this.a.getGroup().getString(x + ".@Player").equals("none")) {
                        var11 = this.a.getServer().getOnlinePlayers().iterator();

                        label210:
                        while(true) {
                            while(true) {
                                if (!var11.hasNext()) {
                                    break label210;
                                }

                                p = (Player)var11.next();
                                if (!msg.contains("@" + p.getName()) && !msg.contains("@ " + p.getName())) {
                                    if (msg.contains(p.getName())) {
                                        msg = msg.replace(p.getName(), this.a.getGroup().getString(x + ".@Player").replace("%target%", p.getName()));
                                    }
                                } else {
                                    msg = msg.replace("@" + p.getName(), this.a.getGroup().getString(x + ".@Player").replace("%target%", p.getName())).replace("@ " + p.getName(), this.a.getGroup().getString(x + ".@Player").replace("%target%", p.getName()));
                                }
                            }
                        }
                    }

                    if (this.a.getData().getString(b.getPlayer().getName() + ".Type.Chat").equals("Private")) {
                        b.getPlayer().sendMessage(this.a.ChatGroup(b.getPlayer(), this.a.getGroup(b.getPlayer().getName()), msg));
                    }

                    if (this.a.getData().getString(b.getPlayer().getName() + ".Type.Chat").equals("Group")) {
                        var11 = this.a.getServer().getOnlinePlayers().iterator();

                        while(var11.hasNext()) {
                            p = (Player)var11.next();
                            if (!p.equals(b.getPlayer())) {
                                if (this.a.getData().getString(p.getName() + ".Group").equals(this.a.getData().getString(b.getPlayer().getName() + ".Group"))) {
                                    p.sendMessage(this.a.ChatGroup(b.getPlayer(), this.a.getGroup(b.getPlayer().getName()), msg));
                                }
                            } else {
                                b.getPlayer().sendMessage(this.a.ChatGroup(b.getPlayer(), this.a.getGroup(b.getPlayer().getName()), msg));
                            }
                        }
                    }

                    if (this.a.getData().getString(b.getPlayer().getName() + ".Type.Chat").equals("World")) {
                        var11 = this.a.getServer().getOnlinePlayers().iterator();

                        while(var11.hasNext()) {
                            p = (Player)var11.next();
                            if (!p.getWorld().getName().equals(b.getPlayer().getWorld().getName())) {
                                if (p.getWorld().getName().equals(b.getPlayer().getWorld().getName())) {
                                    p.sendMessage(this.a.ChatGroup(b.getPlayer(), this.a.getGroup(b.getPlayer().getName()), msg));
                                }
                            } else {
                                b.getPlayer().sendMessage(this.a.ChatGroup(b.getPlayer(), this.a.getGroup(b.getPlayer().getName()), msg));
                            }
                        }
                    }

                    if (this.a.getData().getString(b.getPlayer().getName() + ".Type.Chat").equals("Public")) {
                        var11 = this.a.getServer().getOnlinePlayers().iterator();

                        while(var11.hasNext()) {
                            p = (Player)var11.next();
                            p.sendMessage(this.a.ChatGroup(b.getPlayer(), this.a.getGroup(b.getPlayer().getName()), msg));
                        }
                    }

                    this.a.sendConsole(0, this.a.ChatGroup(b.getPlayer(), this.a.getGroup(b.getPlayer().getName()), msg));
                    if (b.getMessage().equals("Clear RAM")) {
                        if (!this.a.hasPermission(b.getPlayer().getName(), "functions.chat.text.ClearRAM")) {
                            return;
                        }

                        r = Runtime.getRuntime();
                        Lused = (r.totalMemory() - r.freeMemory()) / 1024L / 1024L;
                        System.gc();
                        used = Lused - (r.totalMemory() - r.freeMemory()) / 1024L / 1024L;
                        b.getPlayer().sendMessage(this.a.String(1, "ClearTPS", "Clear ram: %ram%MB,TPS: %tps%").replace("%ram%", used + "").replace("%tps%", TPS.TPS()));
                    }
                } else {
                    if (!this.a.getGroup().getString(x + ".Delay.ChatTime").equals("none") && L <= this.a.getGroup().getLong(x + ".Delay.ChatTime")) {
                        b.getPlayer().sendMessage(this.a.String(1, "DelayChat", "Please wait %delay%s!").replace("%delay%", "" + ((double)this.a.getGroup().getLong(x + ".Delay.ChatTime") - ((double)Long - (double)l)) / 1000.0D));
                        return;
                    }

                    this.a.getData().set(b.getPlayer().getName() + ".ChatTime", Long);
                    this.a.SaveConfig();
                    msg = b.getMessage();
                    var11 = this.a.getGroup().getStringList(x + ".Anti-Key-Words.List").iterator();

                    while(var11.hasNext()) {
                        s = (String)var11.next();
                        if (msg.contains(s) && this.a.getGroup().getString(x + ".Anti-Key-Words.Replace." + s) != null) {
                            msg = msg.replace(s, this.a.getGroup().getString(x + ".Anti-Key-Words.Replace." + s));
                        }
                    }

                    if (this.a.getGroup().getBoolean(x + ".Blank_space")) {
                        msg = msg.replace("  ", " ");
                    }

                    if (!this.a.getGroup().getString(x + ".@Player").equals("none")) {
                        var11 = this.a.getServer().getOnlinePlayers().iterator();

                        label179:
                        while(true) {
                            while(true) {
                                if (!var11.hasNext()) {
                                    break label179;
                                }

                                p = (Player)var11.next();
                                if (!msg.contains("@" + p.getName()) && !msg.contains("@ " + p.getName())) {
                                    if (msg.contains(p.getName())) {
                                        msg = msg.replace(p.getName(), this.a.getGroup().getString(x + ".@Player").replace("%target%", p.getName()));
                                    }
                                } else {
                                    msg = msg.replace("@" + p.getName(), this.a.getGroup().getString(x + ".@Player").replace("%target%", p.getName())).replace("@ " + p.getName(), this.a.getGroup().getString(x + ".@Player").replace("%target%", p.getName()));
                                }
                            }
                        }
                    }

                    if (this.a.getData().getString(b.getPlayer().getName() + ".Type.Chat").equals("Private")) {
                        b.getPlayer().sendMessage(this.a.ChatGroup(b.getPlayer(), this.a.getGroup(b.getPlayer().getName()), msg));
                    }

                    if (this.a.getData().getString(b.getPlayer().getName() + ".Type.Chat").equals("Group")) {
                        var11 = this.a.getServer().getOnlinePlayers().iterator();

                        while(var11.hasNext()) {
                            p = (Player)var11.next();
                            if (!p.equals(b.getPlayer())) {
                                if (this.a.getData().getString(p.getName() + ".Group").equals(this.a.getData().getString(b.getPlayer().getName() + ".Group"))) {
                                    p.sendMessage(this.a.ChatGroup(b.getPlayer(), this.a.getGroup(b.getPlayer().getName()), msg));
                                }
                            } else {
                                b.getPlayer().sendMessage(this.a.ChatGroup(b.getPlayer(), this.a.getGroup(b.getPlayer().getName()), msg));
                            }
                        }
                    }

                    if (this.a.getData().getString(b.getPlayer().getName() + ".Type.Chat").equals("World")) {
                        var11 = this.a.getServer().getOnlinePlayers().iterator();

                        while(var11.hasNext()) {
                            p = (Player)var11.next();
                            if (!p.getWorld().getName().equals(b.getPlayer().getWorld().getName())) {
                                if (p.getWorld().getName().equals(b.getPlayer().getWorld().getName())) {
                                    p.sendMessage(this.a.ChatGroup(b.getPlayer(), this.a.getGroup(b.getPlayer().getName()), msg));
                                }
                            } else {
                                b.getPlayer().sendMessage(this.a.ChatGroup(b.getPlayer(), this.a.getGroup(b.getPlayer().getName()), msg));
                            }
                        }
                    }

                    if (this.a.getData().getString(b.getPlayer().getName() + ".Type.Chat").equals("Public")) {
                        var11 = this.a.getServer().getOnlinePlayers().iterator();

                        while(var11.hasNext()) {
                            p = (Player)var11.next();
                            p.sendMessage(this.a.ChatGroup(b.getPlayer(), this.a.getGroup(b.getPlayer().getName()), msg));
                        }
                    }

                    this.a.sendConsole(0, this.a.ChatGroup(b.getPlayer(), this.a.getGroup(b.getPlayer().getName()), msg));
                    if (b.getMessage().equals("Clear RAM")) {
                        if (!this.a.hasPermission(b.getPlayer().getName(), "functions.chat.text.ClearRAM")) {
                            return;
                        }

                        r = Runtime.getRuntime();
                        Lused = (r.totalMemory() - r.freeMemory()) / 1024L / 1024L;
                        System.gc();
                        used = Lused - (r.totalMemory() - r.freeMemory()) / 1024L / 1024L;
                        b.getPlayer().sendMessage(this.a.String(1, "ClearTPS", "Clear ram: %ram%MB,TPS: %tps%").replace("%ram%", used + "").replace("%tps%", TPS.TPS()));
                    }
                }
            }
        }
    }
}