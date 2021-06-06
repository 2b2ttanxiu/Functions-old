package org.functions.Main;

import java.util.Iterator;
import java.util.List;

public class MyString extends Functions {
    public MyString() {
    }

    public String init(int Prefix, String Path, String text) {
        String str = "";
        if (this.getLanguage().getString(Path) == null) {
            if (Prefix == 0) {
                str = text;
            }

            if (Prefix == 1) {
                str = this.Prefix() + text;
            }

            this.getLanguage().addDefault(Path, text);
            this.getLanguage().options().copyDefaults(true);
            this.getLanguage().options().copyHeader();
            this.SaveConfig();
        } else {
            if (Prefix == 0) {
                str = this.getLanguage().getString(Path);
            }

            if (Prefix == 1) {
                str = this.Prefix() + this.getLanguage().getString(Path);
            }
        }

        Iterator var5 = this.getSettings().getStringList("AnimationsEnable").iterator();

        while(var5.hasNext()) {
            String x = (String)var5.next();
            List<String> ls = this.getSettings().getStringList("Animations." + x + ".Texts");
            int i = this.getSettings().getInt("Animations." + x + ".Line");
            str.replace("%animation:" + x + "%", (CharSequence)ls.get(i));
        }

        return str.replace("&", "§").replace("%date%", this.getDate()).replace("%tps%", this.API().getHandler().nms().getTPS()).replace("%time%", this.getTime()).replace("/n", "\n").replace("%servername%", this.getServerName()).replace("%plugin_prefix%", this.Prefix());
    }
}
