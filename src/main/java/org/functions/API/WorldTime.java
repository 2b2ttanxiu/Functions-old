package org.functions.API;

import org.functions.Main.Functions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WorldTime {
    public String get(long Time) {
        Date date = new Date(Time);
        SimpleDateFormat Date = new SimpleDateFormat(Functions.getMain().getSettings().getString("Date-Time.DayTime"));
        String[] d = Date.format(date).split(":");
        int h = Integer.parseInt(d[0]);
        int m = Integer.parseInt(d[1]);
        String s = Date.format(date);
        if (h > 23) {
            h = h - 24;
            s = h + ":" + m;
        }
        return s;
    }
}
