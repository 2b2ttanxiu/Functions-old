package org.functions.net.minecraft.server;

public class MCVersion {
    public MCVersion() {
    }

    public String getVersion() {
        Handler handler = new Handler();
        return handler.getServer().getVersion();
    }

    public String toString() {
        String toString = "null";
        if (this.getVersion().contains("1.0")) {
            toString = "1.0";
        }

        if (this.getVersion().contains("1.1")) {
            toString = "1.1";
        }

        if (this.getVersion().contains("1.2.1")) {
            toString = "1.2.1";
        }

        if (this.getVersion().contains("1.2.2")) {
            toString = "1.2.2";
        }

        if (this.getVersion().contains("1.2.3")) {
            toString = "1.2.3";
        }

        if (this.getVersion().contains("1.2.4")) {
            toString = "1.2.4";
        }

        if (this.getVersion().contains("1.2.5")) {
            toString = "1.2.5";
        }

        if (this.getVersion().contains("1.3.1")) {
            toString = "1.3.1";
        }

        if (this.getVersion().contains("1.3.2")) {
            toString = "1.3.2";
        }

        if (this.getVersion().contains("1.4.2")) {
            toString = "1.4.2";
        }

        if (this.getVersion().contains("1.4.4")) {
            toString = "1.4.4";
        }

        if (this.getVersion().contains("1.4.5")) {
            toString = "1.4.5";
        }

        if (this.getVersion().contains("1.4.7")) {
            toString = "1.4.7";
        }

        if (this.getVersion().contains("1.5.1")) {
            toString = "1.5.1";
        }

        if (this.getVersion().contains("1.5.2")) {
            toString = "1.5.2";
        }

        if (this.getVersion().contains("1.6.1")) {
            toString = "1.6.1";
        }

        if (this.getVersion().contains("1.6.2")) {
            toString = "1.6.2";
        }

        if (this.getVersion().contains("1.6.4")) {
            toString = "1.6.4";
        }

        if (this.getVersion().contains("1.7.2")) {
            toString = "1.7.2";
        }

        if (this.getVersion().contains("1.7.3")) {
            toString = "1.7.3";
        }

        if (this.getVersion().contains("1.7.4")) {
            toString = "1.7.4";
        }

        if (this.getVersion().contains("1.7.5")) {
            toString = "1.7.5";
        }

        if (this.getVersion().contains("1.7.6")) {
            toString = "1.7.6";
        }

        if (this.getVersion().contains("1.7.7")) {
            toString = "1.7.7";
        }

        if (this.getVersion().contains("1.7.8")) {
            toString = "1.7.8";
        }

        if (this.getVersion().contains("1.7.9")) {
            toString = "1.7.9";
        }

        if (this.getVersion().contains("1.7.10")) {
            toString = "1.7.10";
        }

        if (this.getVersion().contains("1.8")) {
            toString = "1.8";
        }

        if (this.getVersion().contains("1.8.1")) {
            toString = "1.8.1";
        }

        if (this.getVersion().contains("1.8.2")) {
            toString = "1.8.2";
        }

        if (this.getVersion().contains("1.8.3")) {
            toString = "1.8.3";
        }

        if (this.getVersion().contains("1.8.4")) {
            toString = "1.8.4";
        }

        if (this.getVersion().contains("1.8.5")) {
            toString = "1.8.5";
        }

        if (this.getVersion().contains("1.8.6")) {
            toString = "1.8.6";
        }

        if (this.getVersion().contains("1.8.7")) {
            toString = "1.8.7";
        }

        if (this.getVersion().contains("1.8.8")) {
            toString = "1.8.8";
        }

        if (this.getVersion().contains("1.8.9")) {
            toString = "1.8.9";
        }

        if (this.getVersion().contains("1.9")) {
            toString = "1.9";
        }

        if (this.getVersion().contains("1.9.1")) {
            toString = "1.9.1";
        }

        if (this.getVersion().contains("1.9.2")) {
            toString = "1.9.2";
        }

        if (this.getVersion().contains("1.9.3")) {
            toString = "1.9.3";
        }

        if (this.getVersion().contains("1.9.4")) {
            toString = "1.9.4";
        }

        if (this.getVersion().contains("1.10")) {
            toString = "1.10";
        }

        if (this.getVersion().contains("1.10.1")) {
            toString = "1.10.1";
        }

        if (this.getVersion().contains("1.10.2")) {
            toString = "1.10.2";
        }

        if (this.getVersion().contains("1.11")) {
            toString = "1.11";
        }

        if (this.getVersion().contains("1.11.1")) {
            toString = "1.11.1";
        }

        if (this.getVersion().contains("1.11.2")) {
            toString = "1.11.2";
        }

        if (this.getVersion().contains("1.12")) {
            toString = "1.12";
        }

        if (this.getVersion().contains("1.12.1")) {
            toString = "1.12.1";
        }

        if (this.getVersion().contains("1.12.2")) {
            toString = "1.12.2";
        }

        if (this.getVersion().contains("1.13")) {
            toString = "1.13";
        }

        if (this.getVersion().contains("1.13.1")) {
            toString = "1.13.1";
        }

        if (this.getVersion().contains("1.13.2")) {
            toString = "1.13.2";
        }

        if (this.getVersion().contains("1.14")) {
            toString = "1.14";
        }

        if (this.getVersion().contains("1.14.1")) {
            toString = "1.14.1";
        }

        if (this.getVersion().contains("1.14.2")) {
            toString = "1.14.2";
        }

        if (this.getVersion().contains("1.14.3")) {
            toString = "1.14.3";
        }

        if (this.getVersion().contains("1.14.4")) {
            toString = "1.14.4";
        }

        if (this.getVersion().contains("1.15")) {
            toString = "1.15";
        }

        if (this.getVersion().contains("1.15.1")) {
            toString = "1.15.1";
        }

        if (this.getVersion().contains("1.15.2")) {
            toString = "1.15.2";
        }

        if (this.getVersion().contains("1.16")) {
            toString = "1.16";
        }

        if (this.getVersion().contains("1.16.1")) {
            toString = "1.16.1";
        }

        if (this.getVersion().contains("1.16.2")) {
            toString = "1.16.2";
        }

        if (this.getVersion().contains("1.16.3")) {
            toString = "1.16.3";
        }

        if (this.getVersion().contains("1.16.4")) {
            toString = "1.16.4";
        }

        if (this.getVersion().contains("1.16.5")) {
            toString = "1.16.5";
        }

        if (this.getVersion().contains("1.17.0")) {
            toString = "1.17.0";
        }

        if (this.getVersion().contains("1.17.1")) {
            toString = "1.17.1";
        }

        Handler handler = new Handler();
        if (handler.getServer().getPluginManager().isPluginEnabled("ViaVersion")) {
            ViaVersion via = new ViaVersion();
            toString = toString + " - " + via.toString();
        }

        return toString;
    }
}
