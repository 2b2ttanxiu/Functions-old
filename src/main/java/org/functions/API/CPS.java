package org.functions.API;

import java.util.ArrayList;
import java.util.UUID;
import org.functions.Main.Functions;

public final class CPS {
    int max;
    int CPS;
    long cpsTime;
    long cpsMin;
    ArrayList<Long> cps = new ArrayList();

    public CPS() {
    }

    public int getMax() {
        return this.max;
    }

    public void countCPS() {
        this.cps.add(System.currentTimeMillis());
        this.removeCPSTimeout();
        if (this.cps.size() > this.max) {
            this.max = this.cps.size();
        }

    }

    public int getCPS() {
        return this.cps.size();
    }

    public void removeCPSTimeout() {
        while(!this.cps.isEmpty() && System.currentTimeMillis() - (Long)this.cps.get(0) > 1000L) {
            this.cps.remove(0);
        }

    }

    public void reset() {
        this.cps.clear();
        this.max = 0;
    }

    public void resetMax() {
        this.max = 0;
    }

    public void set(UUID id) {
        Functions.getMain().getStatus().set(id + ".CPS.Max", this.max);
        Functions.getMain().getStatus().set(id + ".CPS.count", this.cps.size());
        Functions.getMain().saveStatus();
    }

    public int getMaxCPS(UUID id) {
        return Functions.getMain().getStatus().getInt(id + ".CPS.Max");
    }

    public int getCountCPS(UUID id) {
        return Functions.getMain().getStatus().getInt(id + ".CPS.count");
    }
}
