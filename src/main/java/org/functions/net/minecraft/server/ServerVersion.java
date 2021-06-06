package org.functions.net.minecraft.server;

import org.bukkit.Bukkit;

public class ServerVersion {

    public enum Version {
        v1_8_R1,
        v1_8_R2,
        v1_8_R3,
        v1_9_R1,
        v1_9_R2,
        v1_10_R1,
        v1_11_R1,
        v1_12_R1,
        v1_13_R1,
        v1_13_R2,
        v1_14_R1,
        v1_14_R2,
        v1_15_R1,
        v1_15_R2,
        v1_16_R1,
        v1_16_R2,
        v1_16_R3,
        v1_17_R1,
        v1_17_R2,
        v1_18_R1,
        v1_18_R2;

        private Integer value = Integer.valueOf(this.name().replaceAll("[^\\d.]", ""));
        private String shortVersion = this.name().substring(0, this.name().length() - 3);
        private static Version current;

        private Version() {
        }

        public Integer getValue() {
            return this.value;
        }

        public String getShortVersion() {
            return this.shortVersion;
        }

        public static Version getCurrent() {
            if (current != null) {
                return current;
            } else {
                String[] v = Bukkit.getServer().getClass().getPackage().getName().split("\\.");
                String vv = v[v.length - 1];
                Version[] var2 = values();
                int var3 = var2.length;

                for (int var4 = 0; var4 < var3; ++var4) {
                    Version one = var2[var4];
                    if (one.name().equalsIgnoreCase(vv)) {
                        current = one;
                        break;
                    }
                }

                return current;
            }
        }

        public boolean isLower(Version version) {
            return this.getValue() < version.getValue();
        }

        public boolean isHigher(Version version) {
            return this.getValue() > version.getValue();
        }

        public boolean isEqual(Version version) {
            return this.getValue().equals(version.getValue());
        }

        public boolean isEqualOrLower(Version version) {
            return this.getValue() <= version.getValue();
        }

        public boolean isEqualOrHigher(Version version) {
            return this.getValue() >= version.getValue();
        }

        public static boolean isCurrentEqualOrHigher(Version v) {
            return getCurrent().getValue() >= v.getValue();
        }

        public static boolean isCurrentHigher(Version v) {
            return getCurrent().getValue() > v.getValue();
        }

        public static boolean isCurrentLower(Version v) {
            return getCurrent().getValue() < v.getValue();
        }

        public static boolean isCurrentEqualOrLower(Version v) {
            return getCurrent().getValue() <= v.getValue();
        }

        public static boolean isCurrentEqual(Version v) {
            return getCurrent().getValue().equals(v.getValue());
        }
    }
}