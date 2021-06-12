//package org.functions.bungee.Runnable;
//
//import org.functions.bungee.Main.PlayerNMS;
//
//import java.util.List;
//
//public class ServerTitle {
//    PlayerNMS nms = new PlayerNMS();
//    public class version implements Runnable {
//        public void run() {
//            int i = nms.nms.getTitle().getInt("TitleLine",0);
//        }
//    }
//    public class title implements Runnable {
//        public void run() {
//            int i = nms.nms.getTitle().getInt("TitleLine", 0);
//            List<String> ls;
//            if (nms.nms.getConfig().getBoolean("Maintenance")) {
//                ls = nms.nms.getTitle().getStringList("Smode.List." + nms.nms.getTitle().getString("Enabled"));
//            } else {
//                ls = nms.nms.getTitle().getStringList("Title.List." + nms.nms.getTitle().getString("Enabled"));
//            }
//            if (ls.size() != 1) {
//                if (ls.size() != i) {
//                    ++i;
//                }
//
//                if (ls.size() == i) {
//                    i = 0;
//                }
//
//                nms.nms.getTitle().set("TitleLine", i);
//            }
//        }
//    }
//}
//