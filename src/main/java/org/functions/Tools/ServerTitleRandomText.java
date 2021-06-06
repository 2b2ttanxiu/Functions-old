package org.functions.Tools;

import java.util.List;
import org.functions.Main.Functions;

public class ServerTitleRandomText implements Runnable {
    private Functions a = Functions.getMain();

    public ServerTitleRandomText() {
    }

    public void run() {
        int i = this.a.getTitle().getInt("TitleLine", 0);
        List<String> ls;
        if (this.a.getSettings().getBoolean("Maintenance")) {
            ls = this.a.getTitle().getStringList("Smode.List." + this.a.getTitle().getString("Enabled"));
        } else {
            ls = this.a.getTitle().getStringList("Title.List." + this.a.getTitle().getString("Enabled"));
        }
        if (ls.size() != 1) {
            if (ls.size() != i) {
                ++i;
            }

            if (ls.size() == i) {
                i = 0;
            }

            this.a.getTitle().set("TitleLine", i);
        }
    }
}