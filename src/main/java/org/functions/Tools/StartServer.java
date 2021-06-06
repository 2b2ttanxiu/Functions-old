package org.functions.Tools;

import java.util.ArrayList;
import org.functions.Main.Functions;

public class StartServer implements Runnable {
    long t = Functions.getMain().getConfig().getLong("StartServerTime", -1000L);
    long b = System.currentTimeMillis();
    int h;
    int m;
    int s;
    int day;
    int mo;
    int year;
    ArrayList<Long> l = new ArrayList();

    public StartServer() {
    }

    public String get() {
        return Temp.get("Time");
    }

    public void run() {
        if (this.l.size() == 0) {
            this.l.add(this.b);
        }

        if (this.b >= (Long)this.l.get(this.l.size() - 1)) {
            this.l.add(this.b);
        }

        Temp.set("time", this.l.size());
        this.s = Integer.parseInt(Temp.get("time"));
        if (this.s > 60) {
            this.s -= 60;
            this.l.clear();
            ++this.m;
        }

        if (this.m == 60) {
            this.m = 0;
            ++this.h;
        }

        if (this.h == 24) {
            ++this.day;
            this.h = 0;
        }

        if (this.day == 30) {
            ++this.mo;
            this.day = 0;
        }

        if (this.mo == 12) {
            ++this.year;
            this.mo = 0;
        }

        String f = this.year + ":" + this.mo + ":" + this.day + ":" + this.h + ":" + this.m + ":" + this.s;
        Temp.set("Time", f);
    }
}