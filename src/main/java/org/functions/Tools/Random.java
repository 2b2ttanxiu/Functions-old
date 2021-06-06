package org.functions.Tools;

import java.util.List;
import org.functions.Main.Functions;

public class Random implements Runnable {
    private Functions p = Functions.getMain();

    public Random() {
    }

    public void run() {
        int i = this.p.getSettings().getInt("ActionBar.Line");
        List<String> ls = this.p.getSettings().getStringList("ActionBar.Texts");
        if (ls.size() != 1) {
            if (ls.size() != i) {
                ++i;
            }

            if (ls.size() == i) {
                i = 0;
            }

            this.p.getSettings().set("ActionBar.Line", i);
        }
    }
}