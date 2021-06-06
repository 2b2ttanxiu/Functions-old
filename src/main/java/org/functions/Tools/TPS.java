package org.functions.Tools;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TPS implements Runnable {
    public static int TICK_COUNT = 0;
    public static long[] TICKS = new long[600];
    public static long LAST_TICK = 0L;

    public TPS() {
    }

    public static String TPS() {
        if (getTPS() > 20.0D) {
            return "20.0*";
        } else {
            BigDecimal bg = (new BigDecimal(getTPS())).setScale(2, RoundingMode.UP);
            String tps = bg + "";
            return tps.equals("20.00") ? "20.0" : bg + "";
        }
    }

    public static double getTPS() {
        return getTPS(100);
    }

    public static double getTPS(int ticks) {
        if (TICK_COUNT < ticks) {
            return 20.0D;
        } else {
            int target = (TICK_COUNT - 1 - ticks) % TICKS.length;
            long elapsed = System.currentTimeMillis() - TICKS[target];
            return (double) ticks / ((double) elapsed / 1000.0D);
        }
    }

    public static long getElapsed(int tickID) {
        if (TICK_COUNT - tickID >= TICKS.length) {
        }

        long time = TICKS[tickID % TICKS.length];
        return System.currentTimeMillis() - time;
    }

    public void run() {
        TICKS[TICK_COUNT % TICKS.length] = System.currentTimeMillis();
        ++TICK_COUNT;
    }
}
