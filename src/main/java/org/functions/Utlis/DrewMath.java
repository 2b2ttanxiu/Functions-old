package org.functions.Utlis;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.bukkit.Bukkit;

public class DrewMath {
    public DrewMath() {
    }

    public static double round(double value, int places) {
        if (places < 0) {
            return 0.0D;
        } else {
            BigDecimal bd = new BigDecimal(value);
            bd = bd.setScale(places, RoundingMode.HALF_UP);
            return bd.doubleValue();
        }
    }

    public static long getSize(File folder) {
        long i = 0L;
        File[] var3 = folder.listFiles();
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            File f = var3[var5];
            if (f.isFile()) {
                i += f.length();
            } else {
                i += getSize(f);
            }
        }

        return i;
    }

    public static File getSpigotRoot() {
        File f = new File(Bukkit.class.getProtectionDomain().getCodeSource().getLocation().getPath().replaceAll("%20", " "));
        return new File(f.getAbsolutePath().substring(0, f.getAbsolutePath().length() - f.getName().length()) + File.separator);
    }

    public static int intFrom(String s) {
        StringBuilder sb = new StringBuilder();
        char[] var2 = s.toCharArray();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            char c = var2[var4];
            if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
                sb.append(c);
            }
        }

        return Integer.parseInt(sb.toString());
    }

    public static <T> T cast(Class<T> cls, Object o) {
        return cls.cast(o);
    }

    public static boolean between(long var, long low, long high) {
        return var >= low && var <= high;
    }

    public static String getTagForTime(long time) {
        if (between(time, 13000L, 24000L)) {
            return "night";
        } else if (between(time, 12000L, 12999L)) {
            return "dusk";
        } else {
            return between(time, 0L, 999L) ? "dawn" : "day";
        }
    }
}
