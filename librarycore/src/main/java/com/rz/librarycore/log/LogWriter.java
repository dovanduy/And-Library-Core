package com.rz.librarycore.log;

public class LogWriter {
    public static boolean isDebug = true;
    protected static final String f1109b = LogWriter.class.getName();

    public static void Log(String argMessage) {
        if (isDebug) {
            C0367a.f1106a = isDebug;
            C0367a.m1387a(argMessage);
        }
    }

    public static void Log(String argTag, String argMessage) {
        if (isDebug) {
            C0367a.f1106a = isDebug;
            C0367a.m1388a(argTag, argMessage);
        }
    }

    public static void dLog(String argMessage) {
        if (isDebug) {
            C0367a.f1106a = isDebug;
            C0367a.m1389b(argMessage);
        }
    }

    public static void dLog(String argTag, String argMessage) {
        if (isDebug) {
            C0367a.f1106a = isDebug;
            C0367a.m1390b(argTag, argMessage);
        }
    }

    public static void eLog(String argMessage) {
        if (isDebug) {
            C0367a.f1106a = isDebug;
            C0367a.m1391c(argMessage);
        }
    }

    public static void eLog(String argTag, String argMessage) {
        if (isDebug) {
            C0367a.f1106a = isDebug;
            C0367a.m1392c(argTag, argMessage);
        }
    }

    public static void iLog(String argMessage) {
        if (isDebug) {
            C0367a.f1106a = isDebug;
            C0367a.m1393d(argMessage);
        }
    }

    public static void iLog(String argTag, String argMessage) {
        if (isDebug) {
            C0367a.f1106a = isDebug;
            C0367a.m1394d(argTag, argMessage);
        }
    }

    public static void vLog(String argMessage) {
        if (isDebug) {
            C0367a.f1106a = isDebug;
            C0367a.m1395e(argMessage);
        }
    }

    public static void vLog(String argTag, String argMessage) {
        if (isDebug) {
            C0367a.f1106a = isDebug;
            C0367a.m1396e(argTag, argMessage);
        }
    }

    public static void wtfLog(String argMessage) {
        if (isDebug) {
            C0367a.f1106a = isDebug;
            C0367a.m1397f(argMessage);
        }
    }

    public static void wtfLog(String argTag, String argMessage) {
        if (isDebug) {
            C0367a.f1106a = isDebug;
            C0367a.m1398f(argTag, argMessage);
        }
    }
}
