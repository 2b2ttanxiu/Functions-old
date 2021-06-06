package org.functions.Utlis;

public class RAM extends ServerInfo {
    private Runtime r;

    public RAM() {
    }

    public long getMax() {
        this.r = Runtime.getRuntime();
        return this.r.maxMemory() / 1024L / 1024L;
    }

    public long getTotal() {
        return this.r.totalMemory() / 1024L / 1024L;
    }

    public long getSize() {
        this.r = Runtime.getRuntime();
        return (this.r.totalMemory() - this.r.freeMemory()) / 1024L / 1024L;
    }

    public String size() {
        return Double.toString(DrewMath.round((double)this.getSize() / (double)this.getMax() * 100.0D, 1));
    }
}