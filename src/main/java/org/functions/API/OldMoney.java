package org.functions.API;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public final class OldMoney {
    private UUID id;
    private double money;
    private PlayerNMS nms = new PlayerNMS();

    public OldMoney(UUID id, double Default) {
        this.id = id;
        this.money = Default;
    }

    public void save() {
        try {
            this.nms.nms.getDataMoney().save(new File(this.nms.nms.getDataFolder(), "DataMoneys.yml"));
        } catch (IOException var2) {
            var2.printStackTrace();
        }

    }

    public double get() {
        return this.nms.nms.getDataMoney().getDouble(this.id + ".Money", this.money);
    }

    public void add(double addMoney) {
        double i = this.get() + addMoney;
        this.nms.nms.getDataMoney().set(this.id + ".Money", i);
    }

    public void set(double setMoney) {
        this.nms.nms.getDataMoney().set(this.id + ".Money", setMoney);
    }

    public void remove(double removeMoney) {
        double i = this.get() + removeMoney;
        this.nms.nms.getDataMoney().set(this.id + ".Money", i);
    }

    public void reset() {
        this.nms.nms.getDataMoney().set(this.id + ".Money", this.money);
    }

    public boolean isMax() {
        return false;
    }

    public boolean isMin() {
        return false;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean is() {
        return false;
    }

    public boolean isMax(double Money) {
        return false;
    }

    public boolean isMin(double Money) {
        return false;
    }

    public boolean isEmpty(double Money) {
        return false;
    }

    public boolean is(double Money) {
        return false;
    }

    static enum Type {
        DOUBLE,
        LONG,
        INT;

        private Type() {
        }
    }
}