package org.functions.Tools;

import org.functions.Main.Functions;

public class NMSv {
    public NMSv() {
    }

    public static String v() {
        return Functions.getMain().getServer().getClass().getPackage().getName().substring(Functions.getMain().getServer().getClass().getPackage().getName().lastIndexOf(46) + 1);
    }
}
