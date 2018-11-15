package com.rz.librarycore.log;

import android.util.Log;

import java.io.PrintStream;

class C0367a {
    protected static boolean f1106a = true;
    private static final String f1107b = C0367a.class.getName();

    C0367a() {
    }

    protected static void m1387a(String str) {
        if (f1106a) {
            PrintStream printStream = System.out;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(C0367a.m1400h(""));
            stringBuilder.append(C0367a.m1399g(str));
            printStream.println(stringBuilder.toString());
        }
    }

    protected static void m1388a(String str, String str2) {
        if (f1106a) {
            PrintStream printStream = System.out;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(C0367a.m1400h(str));
            stringBuilder.append(C0367a.m1399g(str2));
            printStream.println(stringBuilder.toString());
        }
    }

    protected static void m1389b(String str) {
        if (f1106a) {
            Log.d(C0367a.m1400h(""), C0367a.m1399g(str));
        }
    }

    protected static void m1390b(String str, String str2) {
        if (f1106a) {
            Log.d(C0367a.m1400h(str), C0367a.m1399g(str2));
        }
    }

    protected static void m1391c(String str) {
        if (f1106a) {
            Log.e(C0367a.m1400h(""), C0367a.m1399g(str));
        }
    }

    protected static void m1392c(String str, String str2) {
        if (f1106a) {
            Log.e(C0367a.m1400h(str), C0367a.m1399g(str2));
        }
    }

    protected static void m1393d(String str) {
        if (f1106a) {
            Log.i(C0367a.m1400h(""), C0367a.m1399g(str));
        }
    }

    protected static void m1394d(String str, String str2) {
        if (f1106a) {
            Log.i(C0367a.m1400h(str), C0367a.m1399g(str2));
        }
    }

    protected static void m1395e(String str) {
        if (f1106a) {
            Log.v(C0367a.m1400h(""), C0367a.m1399g(str));
        }
    }

    protected static void m1396e(String str, String str2) {
        if (f1106a) {
            Log.v(C0367a.m1400h(str), C0367a.m1399g(str2));
        }
    }

    protected static void m1397f(String str) {
        if (f1106a) {
            Log.wtf(C0367a.m1400h(""), C0367a.m1399g(str));
        }
    }

    protected static void m1398f(String str, String str2) {
        if (f1106a) {
            Log.wtf(C0367a.m1400h(str), C0367a.m1399g(str2));
        }
    }

    private static String m1399g(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" # ");
        stringBuilder.append(C0367a.m1386a());
        return stringBuilder.toString();
    }

    private static String m1400h(String str) {
        String str2 = "DEBUG_LOG_PRINT_WRITER";
        if (!C0367a.m1401i(str)) {
            str = str.toUpperCase();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str2);
            stringBuilder.append("_");
            stringBuilder.append(str.replaceAll("\\s+", "_"));
            str2 = stringBuilder.toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str2);
        stringBuilder2.append(": ");
        return stringBuilder2.toString();
    }

    private static String m1386a() {
        StringBuilder stringBuilder = new StringBuilder();
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("<unknown>");
        stringBuilder2.append(" ");
        stringBuilder.append(stringBuilder2.toString());
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("Method: ");
        stringBuilder3.append("<unknown>");
        stringBuilder3.append(" ");
        stringBuilder.append(stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append("Line: ");
        stringBuilder3.append("<unknown>");
        stringBuilder3.append(" ");
        stringBuilder.append(stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(" File: ");
        stringBuilder3.append("<unknown>");
        stringBuilder.append(stringBuilder3.toString());
        for (int i = 2; i < stackTrace.length; i++) {
            String className = stackTrace[i].getClassName();
            if (!C0367a.m1401i(className) && !className.equals(f1107b) && !className.equals(LogWriter.f1109b)) {
                className = stackTrace[i].getClassName();
                String methodName = stackTrace[i].getMethodName();
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append(stackTrace[i].getLineNumber());
                stringBuilder4.append("");
                String stringBuilder5 = stringBuilder4.toString();
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(stackTrace[i].getFileName());
                stringBuilder2.append("");
                String stringBuilder6 = stringBuilder2.toString();
                stringBuilder.setLength(0);
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(className);
                stringBuilder3.append(" ");
                stringBuilder.append(stringBuilder3.toString());
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Method: ");
                stringBuilder3.append(methodName);
                stringBuilder3.append(" ");
                stringBuilder.append(stringBuilder3.toString());
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Line: ");
                stringBuilder3.append(stringBuilder5);
                stringBuilder3.append(" ");
                stringBuilder.append(stringBuilder3.toString());
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(" File: ");
                stringBuilder3.append(stringBuilder6);
                stringBuilder.append(stringBuilder3.toString());
                break;
            }
        }
        return stringBuilder.toString();
    }

    private static boolean m1401i(String str) {
        return str == null || str.trim().isEmpty() || str.equalsIgnoreCase("null");
    }
}
