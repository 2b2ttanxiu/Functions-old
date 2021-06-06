package org.functions.Tools;

import java.io.File;
import java.io.IOException;
import org.functions.Main.Functions;

public class Temp {
    private static Functions p = Functions.getMain();

    public Temp() {
    }

    public static void init(String Object) {
        p.getTemp().set(Object, "");
        save();
    }

    public static void set(String Object, Object Obj) {
        p.getTemp().set(Object, Obj);
        save();
    }

    public static void remove(String Object) {
        p.getTemp().set(Object, (Object)null);
        save();
    }

    public static void save() {
        try {
            p.getTemp().save(new File(p.getDataFolder(), "Temp.yml"));
        } catch (IOException var1) {
            var1.printStackTrace();
        }

    }

    public static String get(String Object) {
        return p.getTemp().getString(Object);
    }
}
