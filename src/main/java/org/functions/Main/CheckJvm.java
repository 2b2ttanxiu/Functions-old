package org.functions.Main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bukkit.Bukkit;

public class CheckJvm {
    public CheckJvm() {
    }

    private static int getJvmVersion() {
        String javaVersion = System.getProperty("java.version");
        Matcher matcher = Pattern.compile("(?:1\\.)?(\\d+)").matcher(javaVersion);
        if (!matcher.find()) {
            return -1;
        } else {
            String version = matcher.group(1);

            try {
                return Integer.parseInt(version);
            } catch (NumberFormatException var4) {
                return -1;
            }
        }
    }

    public static void checkJvm() {
        ServerHigh s = new ServerHigh(Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3]);
        if (getJvmVersion() < 11 || s.isHigh()) {
            Functions p = Functions.getMain();
            p.sendConsole(1, "************************************************************");
            p.sendConsole(1, "* WARNING - YOU ARE RUNNING AN OUTDATED VERSION OF JAVA.");
            p.sendConsole(1, "* PAPER WILL STOP BEING COMPATIBLE WITH THIS VERSION OF");
            p.sendConsole(1, "* JAVA WHEN MINECRAFT 1.17 IS RELEASED.");
            p.sendConsole(1, "*");
            p.sendConsole(1, "* Please update the version of Java you use to run Paper");
            p.sendConsole(1, "* to at least Java 11. When Paper for Minecraft 1.17 is");
            p.sendConsole(1, "* released support for versions of Java before 11 will");
            p.sendConsole(1, "* be dropped.");
            p.sendConsole(1, "*");
            p.sendConsole(1, "* Current Java version: " + System.getProperty("java.version"));
            p.sendConsole(1, "*");
            p.sendConsole(1, "* Check this forum post for more information: ");
            p.sendConsole(1, "*   https://papermc.io/java11");
            p.sendConsole(1, "************************************************************");
        }

    }
}
