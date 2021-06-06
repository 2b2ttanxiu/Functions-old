package org.functions.money;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.functions.API.PlayerNMS;

public class Money {
    PlayerNMS nms = new PlayerNMS();
    FileConfiguration main = nms.nms.getDataMoney();
    UUID uuid;
    String regex;
    public void saveDataMoney() {
        try {
            main.save(new File(nms.nms.getDataFolder(), "DataMoneys.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String format() {
        return regex;
    }
    public void MoneyFormat() {
        regex = nms.nms.getSettings().getString("MoneyFormat-matches");
    }
    public void checkMoney() {
        double d = main.getDouble(uuid+".Money");
        @SuppressWarnings("all")
        DecimalFormat df = new DecimalFormat(nms.nms.getSettings().getString("MoneyFormat","#.####"));
        d = Double.parseDouble(df.format(d));
        setMoney(d);
    }
    public void resetMoney() {
        setMoney(0);
    }
    public Money(UUID uuid) {
        this.uuid = uuid;
        MoneyFormat();
    }
    public void setMoney(double Money) {
        main.set(uuid+".Money",Money);
        saveDataMoney();
    }
    public double getMoney() {
        return main.getDouble(uuid+".Money");
    }
    public void addMoney(double Money) {
        double has = main.getDouble(uuid+".Money");
        has = has + Money;
        main.set(uuid+".Money",has);
        saveDataMoney();
    }
    public boolean IfRemoveMoney(double Money)  {
        double has = main.getDouble(uuid+".Money");
        has = has - Money;
        if (has < 0) {
            return false;
        }
        return true;
    }
    public void removeMoney(double Money) {
        double has = main.getDouble(uuid+".Money");
        has = has - Money;
        main.set(uuid+".Money", has);
        saveDataMoney();
    }
    public boolean IfPayMoney(double pay) {
        double mainhas = main.getDouble(uuid+".Money");
        mainhas = mainhas - pay;
        if (mainhas <= 0) {
            return false;
        }
        return true;
    }
    public void PayMoney(UUID uuid1,double pay) {
        double mainhas = main.getDouble(uuid+".Money");
        double targethas = main.getDouble(uuid1+".Money");
        mainhas = mainhas - pay;
        if (mainhas >= 0) {
            targethas = targethas + pay;
            main.set(uuid+".Money",mainhas);
            main.set(uuid1+".Money",targethas);
        }
        saveDataMoney();
    }
}
