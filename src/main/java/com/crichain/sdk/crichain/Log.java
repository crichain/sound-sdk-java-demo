package com.crichain.sdk.crichain;

import org.slf4j.Logger;

public class Log {

    private static boolean enableLog = false;

    public static void setLogEnable(boolean b) {
        enableLog = b;
    }

    public static void info(Logger log, String str) {
        if (enableLog) {
            log.info(str);
        }
    }

    public static void info(Logger log, String str, Object var2) {
        if (enableLog) {
            log.info(str, var2);
        }
    }

}
