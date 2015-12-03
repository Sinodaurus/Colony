package org.singular.util;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.singular.HiveMind;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.util.stream.IntStream;

public class Logger {
    private java.util.logging.Logger loggie = java.util.logging.Logger.getLogger("Colony");
    private FileHandler fh;
    private File infoFile = new File("info.log");
    private File debugFile = new File("debug.log");

    public void info(String string) {
        try {
            Files.write(string, infoFile, Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void info(String string, Object args) {
        try {
            Files.write(String.format(string, args), infoFile, Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void debug(String string) {
        System.out.println(String.format(string));
    }
    public static void debug(String string, Object args) {
        System.out.println(String.format(string, args));
    }

    public static void newLine() {
        System.out.println();
    }

    public void scanMind() throws IOException {
        fh = new FileHandler("C:/Users/Sven/Development/home/Colony/info.log");
        loggie.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
        Thread dataThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {

                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(String.format("Queens: %d\n", HiveMind.get().queens().size()));
                        stringBuilder.append(String.format("Nurturers: %d\n", HiveMind.get().nurtureAnts().size()));
                        stringBuilder.append(String.format("Workers: %d\n", HiveMind.get().workerAnts().size()));
                        stringBuilder.append(String.format("Infants: %d\n", HiveMind.get().infantAnts()));
                        stringBuilder.append(String.format("-----------------------\n"));
                        stringBuilder.append(String.format("Eggs: %d\n", HiveMind.get().eggs()));
                        stringBuilder.append(String.format("Food: %d\n", HiveMind.get().food()));

                        loggie.info(stringBuilder.toString());
                        Thread.sleep(1000L);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });
        dataThread.setDaemon(true);
        dataThread.start();
    }

    private static boolean isStillTypeLogging(int i) {
        return HiveMind.get().typeLogging() == i;
    }

    private static void logOverall() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Queens: %d", HiveMind.get().queens().size()));
        stringBuilder.append(String.format("Nurturers: %d", HiveMind.get().nurtureAnts().size()));
        stringBuilder.append(String.format("Workers: %d", HiveMind.get().workerAnts().size()));
        stringBuilder.append(String.format("Infants: %d", HiveMind.get().infantAnts()));
        stringBuilder.append(String.format("-----------------------"));
        stringBuilder.append(String.format("Eggs: %d", HiveMind.get().eggs()));
        stringBuilder.append(String.format("Food: %d", HiveMind.get().food()));

//        info(stringBuilder.toString());

        IntStream.rangeClosed(1, 10).forEach(s -> newLine());
    }
}

//KS6W9U