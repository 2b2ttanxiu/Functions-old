package org.functions.Utlis;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class CheckDevBukkit_Spigot {
    boolean Check;

    public CheckDevBukkit_Spigot() {
    }

    public boolean run() {
        try {
            URL url = new URL("http://lt.limc.cc:38308/Functions/README.md");
            InputStream is = url.openStream();
            is.close();
            return this.Check = true;
        } catch (MalformedURLException var3) {
            var3.printStackTrace();
            return this.Check;
        } catch (IOException var4) {
            var4.printStackTrace();
            return this.Check = false;
        }
    }
}