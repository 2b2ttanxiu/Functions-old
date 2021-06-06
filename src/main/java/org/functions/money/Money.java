package org.functions.money;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.functions.API.PlayerNMS;

public class Money {
    PlayerNMS nms = new PlayerNMS();
    FileConfiguration main = nms.nms.getDataMoney();
    UUID uuid;
    public void saveDataMoney() {
        try {
            main.save(new File(nms.nms.getDataFolder(), "DataMoneys.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void resetMoney() {
        setMoney(0);
    }
    public Money(UUID uuid) {
        this.uuid = uuid;
    }
    public void setMoney(long Money) {
        main.set(uuid+".Money",Money);
        saveDataMoney();
    }
    public long getMoney() {
        return main.getLong(uuid+".Money");
    }
    public void addMoney(long Money) {
        long has = main.getLong(uuid+".Money");
        has = has + Money;
        main.set(uuid+".Money",has);
        saveDataMoney();
    }
    public boolean IfRemoveMoney(long Money)  {
        long has = main.getLong(uuid+".Money");
        has = has - Money;
        if (has < 0) {
            return false;
        }
        return true;
    }
    public void removeMoney(long Money) {
        long has = main.getLong(uuid+".Money");
        has = has - Money;
        main.set(uuid+".Money", has);
        saveDataMoney();
    }
    public boolean IfPlayMoney(long pay) {
        long mainhas = main.getLong(uuid+".Money");
        mainhas = mainhas - pay;
        if (mainhas <= 0) {
            return false;
        }
        return true;
    }
    public void PayMoney(UUID uuid1,long pay) {
        long mainhas = main.getLong(uuid+".Money");
        long targethas = main.getLong(uuid1+".Money");
        mainhas = mainhas - pay;
        if (mainhas >= 0) {
            targethas = targethas + pay;
            main.set(uuid+".Money",mainhas);
            main.set(uuid1+".Money",targethas);
        }
        saveDataMoney();
    }
}
