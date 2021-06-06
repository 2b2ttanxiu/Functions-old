package org.functions.Tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import org.bukkit.Bukkit;
import org.functions.Main.Functions;

public class CheckVersion implements Runnable {
    public CheckVersion() {
    }

    public static String Info() {
        String Info = null;

        try {
            URL url = new URL("http://lt.limc.cc:38308/Functions/Info.md");
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            Info = br.readLine();
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return Info;
    }

    public static String getNewVersion() {
        String version = null;

        try {
            URL url = new URL("http://lt.limc.cc:38308/Functions/README.md");
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            version = br.readLine();
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return version;
    }

    public static boolean isVersion() {
        boolean version = false;
        String New = getNewVersion();
        String Now = Functions.getMain().NowVersion();
        if (Now.equalsIgnoreCase(New)) {
            version = true;
        }

        return version;
    }

    public void run() {
        boolean Enable = Functions.getMain().getConfig().getBoolean("Updated.CheckEnable");
        if (Enable && !isVersion()) {
            Functions.getMain().getServer().getConsoleSender().sendMessage(Functions.getMain().Prefix() + Info().replace("&", "§").replace("%{nowversion}", Functions.getMain().NowVersion()).replace("%{newversion}", getNewVersion()));
        }

        if (Functions.getMain().getConfig().getBoolean("Updated.DownloadEnable")) {
            if (getNewVersion().equals(Functions.getMain().NowVersion())) {
                return;
            }

            String name = "Functions-v" + getNewVersion();
            File temp = new File(Functions.getMain().getDataFolder(), "Releases");
            if (!temp.exists()) {
                temp.mkdir();
            }

            File jar = new File(temp, name + ".jar");
            if (jar.exists()) {
                return;
            }

            Bukkit.getServer().getScheduler().runTaskAsynchronously(Functions.getMain(), () -> {
                try {
                    Functions.getMain().sendConsole(1, "Downloading...");
                    URL download = new URL("http://lt.limc.cc:38308/Functions/Releases/Download/" + name + ".jar");
                    InputStream in = null;
                    in = download.openStream();
                    Files.copy(in, jar.toPath(), new CopyOption[]{StandardCopyOption.REPLACE_EXISTING});
                    in.close();
                    Functions.getMain().sendConsole(1, "Download success!");
                } catch (IOException var4) {
                    var4.printStackTrace();
                    Functions.getMain().sendConsole(1, "Download not success!");
                }

            });
        }

    }
}