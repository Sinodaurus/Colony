package org.singular;

import org.singular.modules.Module;
import org.singular.util.Logger;

import java.io.IOException;
import java.util.stream.Collector;
import java.util.stream.IntStream;

public class Colony {
    public static void main(String[] args) throws InterruptedException, IOException {
        HiveMind hiveMind = new HiveMind();
        Logger logger = new Logger();

        HiveMind.get().init();

        logger.scanMind();

        for(Module module : HiveMind.get().area().getModules()) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true) {
                        module.checkStatus();
                        module.yield();
                    }
                }
            });
            t.setDaemon(true);
            t.start();
        }

        System.in.read();

//        Thread ta = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (HiveMind.get().typeLogging() > 0) {
//                    try {
//                        char bla = (char) System.in.read();
//                        String s = Character.toString(bla);
//                        if(s.equals("1") || s.equals("2")) {
//                            HiveMind.get().changeTypeLogging(Integer.parseInt(s));
//                        }
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//        ta.setDaemon(true);
//        ta.start();

//        while(HiveMind.get().typeLogging() > 0) {
//
//        }
    }
}