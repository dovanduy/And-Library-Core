package com.rz.usagesexampl;

import android.util.Log;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class CoreLogWriter {
    protected static boolean isDebug = true;
    private static final String CLASS_NAME = CoreLogWriter.class.getName();
    //private static String strLogTagPre = "DEBUG_LOG_PRINT_WRITER";

    protected static void Log(String argMessage) {
        //|------------------------------------------------------------|
        if (!isDebug) {
            return;
        }
        /*String buildMessage = "";
        buildMessage = argMessage + " # " + getCallerDetails();*/
        System.out.println(getLogTag("") + getLogMessage(argMessage));
        //|------------------------------------------------------------|
    }

    protected static void Log(String argTag, String argMessage) {
        //|------------------------------------------------------------|
        if (!isDebug) {
            return;
        }
        System.out.println(getLogTag(argTag) + getLogMessage(argMessage));
        /*argTag = argTag.toUpperCase();
        argTag = strLogTagPre + "_" + argTag.replaceAll("\\s+", "_");
        String buildMessage = "";
        buildMessage = argMessage + " # " + getCallerDetails();
        System.out.println(argTag + ": " + buildMessage);*/
        //|------------------------------------------------------------|
        /*int pid = android.os.Process.myPid();
        File outputFile = new File(Environment.getExternalStorageDirectory() + "/logs/logcat.txt");
        try {
            String command = "logcat | grep " + pid + " > " + outputFile.getAbsolutePath();
            Process p = Runtime.getRuntime().exec("su");
            OutputStream os = p.getOutputStream();
            os.write((command + "\n").getBytes("ASCII"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        //|------------------------------------------------------------|
    }

    protected static void dLog(String argMessage) {
        //|------------------------------------------------------------|
        if (!isDebug) {
            return;
        }
        /*String buildMessage = "";
        buildMessage = argMessage + " # " + getCallerDetails();*/
        Log.d(getLogTag(""), getLogMessage(argMessage));
        //|------------------------------------------------------------|
    }

    protected static void dLog(String argTag, String argMessage) {
        //|------------------------------------------------------------|
        if (!isDebug) {
            return;
        }
        Log.d(getLogTag(argTag), getLogMessage(argMessage));
        /*argTag = argTag.toUpperCase();
        argTag = "DEBUG_LOG_PRINT_WRITER_" + argTag.replaceAll("\\s+", "_");
        String buildMessage = "";
        buildMessage = argMessage + " # "
                + getCallerDetails();
        Log.d(argTag, buildMessage);*/
        //|------------------------------------------------------------|
    }

    protected static void eLog(String argMessage) {
        //|------------------------------------------------------------|
        if (!isDebug) {
            return;
        }
        Log.e(getLogTag(""), getLogMessage(argMessage));
        /*String buildMessage = "";
        buildMessage = "Message:- " + argMessage + "; "
                + "Class Name:- " + getCallerClassName() + "; "
                + "Method Name:- " + getCallerMethodName() + "; "
                + "Line Number:- " + getCallerLineNumber() + "; "
                + "File Name:- " + getCallerFileName();
        Log.e("DEBUG_LOG_PRINT_WRITER", buildMessage);*/
        //|------------------------------------------------------------|
    }

    protected static void eLog(String argTag, String argMessage) {
        //|------------------------------------------------------------|
        if (!isDebug) {
            return;
        }
        Log.e(getLogTag(argTag), getLogMessage(argMessage));
        /*argTag = argTag.toUpperCase();
        argTag = "DEBUG_LOG_PRINT_WRITER_" + argTag.replaceAll("\\s+", "_");
        String buildMessage = "";
        buildMessage = "Message:- " + argMessage + " - "
                + "Class Name:- " + getCallerClassName() + "; "
                + "Method Name:- " + getCallerMethodName() + "; "
                + "Line Number:- " + getCallerLineNumber() + "; "
                + "File Name:- " + getCallerFileName();
        Log.e(argTag, buildMessage);*/
        //|------------------------------------------------------------|
    }

    protected static void iLog(String argMessage) {
        //|------------------------------------------------------------|
        if (!isDebug) {
            return;
        }
        Log.i(getLogTag(""), getLogMessage(argMessage));
        /*String buildMessage = "";
        buildMessage = "Message:- " + argMessage + "; "
                + "Class Name:- " + getCallerClassName() + "; "
                + "Method Name:- " + getCallerMethodName() + "; "
                + "Line Number:- " + getCallerLineNumber() + "; "
                + "File Name:- " + getCallerFileName();
        Log.i("DEBUG_LOG_PRINT_WRITER", buildMessage);*/
        //|------------------------------------------------------------|
    }

    protected static void iLog(String argTag, String argMessage) {
        //|------------------------------------------------------------|
        if (!isDebug) {
            return;
        }
        Log.i(getLogTag(argTag), getLogMessage(argMessage));
        /*argTag = argTag.toUpperCase();
        argTag = "DEBUG_LOG_PRINT_WRITER_" + argTag.replaceAll("\\s+", "_");
        String buildMessage = "";
        buildMessage = "Message:- " + argMessage + " - "
                + "Class Name:- " + getCallerClassName() + "; "
                + "Method Name:- " + getCallerMethodName() + "; "
                + "Line Number:- " + getCallerLineNumber() + "; "
                + "File Name:- " + getCallerFileName();
        Log.i(argTag, buildMessage);*/
        //|------------------------------------------------------------|
    }

    protected static void vLog(String argMessage) {
        //|------------------------------------------------------------|
        if (!isDebug) {
            return;
        }
        Log.v(getLogTag(""), getLogMessage(argMessage));
        /*String buildMessage = "";
        buildMessage = "Message:- " + argMessage + "; "
                + "Class Name:- " + getCallerClassName() + "; "
                + "Method Name:- " + getCallerMethodName() + "; "
                + "Line Number:- " + getCallerLineNumber() + "; "
                + "File Name:- " + getCallerFileName();
        Log.v("DEBUG_LOG_PRINT_WRITER", buildMessage);*/
        //|------------------------------------------------------------|
    }

    protected static void vLog(String argTag, String argMessage) {
        //|------------------------------------------------------------|
        if (!isDebug) {
            return;
        }
        Log.v(getLogTag(argTag), getLogMessage(argMessage));
        /*argTag = argTag.toUpperCase();
        argTag = "DEBUG_LOG_PRINT_WRITER_" + argTag.replaceAll("\\s+", "_");
        String buildMessage = "";
        buildMessage = "Message:- " + argMessage + " - "
                + "Class Name:- " + getCallerClassName() + "; "
                + "Method Name:- " + getCallerMethodName() + "; "
                + "Line Number:- " + getCallerLineNumber() + "; "
                + "File Name:- " + getCallerFileName();
        Log.v(argTag, buildMessage);*/
        //|------------------------------------------------------------|
    }

    protected static void wtfLog(String argMessage) {
        //|------------------------------------------------------------|
        if (!isDebug) {
            return;
        }
        Log.wtf(getLogTag(""), getLogMessage(argMessage));
        /*String buildMessage = "";
        buildMessage = "Message:- " + argMessage + "; "
                + "Class Name:- " + getCallerClassName() + "; "
                + "Method Name:- " + getCallerMethodName() + "; "
                + "Line Number:- " + getCallerLineNumber() + "; "
                + "File Name:- " + getCallerFileName();
        Log.wtf("DEBUG_LOG_PRINT_WRITER", buildMessage);*/
        //|------------------------------------------------------------|
    }

    protected static void wtfLog(String argTag, String argMessage) {
        //|------------------------------------------------------------|
        if (!isDebug) {
            return;
        }
        Log.wtf(getLogTag(argTag), getLogMessage(argMessage));
        /*argTag = argTag.toUpperCase();
        argTag = "DEBUG_LOG_PRINT_WRITER_" + argTag.replaceAll("\\s+", "_");
        String buildMessage = "";
        buildMessage = "Message:- " + argMessage + " - "
                + getCallerDetails();
        Log.wtf(argTag, buildMessage);*/
        //|------------------------------------------------------------|
    }

    private static String getLogMessage(String argMessage) {
        String buildMessage = "";
        buildMessage = argMessage + " # " + getCallerDetails();
        return buildMessage;
    }

    private static String getLogTag(String argTag) {
        String buildTag = "DEBUG_LOG_PRINT_WRITER";
        //String strLogTag = "DEBUG_LOG_PRINT_WRITER";
        if (!isNullOrEmpty(argTag)) {
            argTag = argTag.toUpperCase();
            buildTag = buildTag + "_" + argTag.replaceAll("\\s+", "_");
        }
        return buildTag + ": ";
    }

    private static String getCallerDetails() {
        StringBuilder stringBuilder = new StringBuilder();
        StackTraceElement[] stackTraceElements = new Throwable().fillInStackTrace().getStackTrace();
        String callingClass = "<unknown>";
        String callerMethod = "<unknown>";
        String lineNumber = "<unknown>";
        String fileName = "<unknown>";
        stringBuilder.append(callingClass + " ");
        stringBuilder.append("Method: " + callerMethod + " ");
        stringBuilder.append("Line: " + lineNumber + " ");
        stringBuilder.append(" File: " + fileName);
        for (int i = 2; i < stackTraceElements.length; i++) {
            String className = stackTraceElements[i].getClassName();
            if (!isNullOrEmpty(className)) {
                if (!className.equals(CoreLogWriter.CLASS_NAME) && !className.equals(LogWriter.CLASS_NAME)) {
                    /*callingClass = stackTraceElements[i].getClassName();
                    callingClass = callingClass.substring(callingClass.lastIndexOf('.') + 1);
                    callingClass = callingClass.substring(callingClass.lastIndexOf('$') + 1);*/
                    callingClass = stackTraceElements[i].getClassName();
                    callerMethod = stackTraceElements[i].getMethodName();
                    lineNumber = stackTraceElements[i].getLineNumber() + "";
                    fileName = stackTraceElements[i].getFileName() + "";
                    stringBuilder.setLength(0);
                    stringBuilder.append(callingClass + " ");
                    stringBuilder.append("Method: " + callerMethod + " ");
                    stringBuilder.append("Line: " + lineNumber + " ");
                    stringBuilder.append(" File: " + fileName);
                    break;
                }
            }
        }
        return stringBuilder.toString();
    }

    protected static String getCallerClassName() {
        /*String callerClassName = new Exception().getStackTrace()[1].getClassName();
        String calleeClassName = new Exception().getStackTrace()[0].getClassName();*/
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        /*for (int i = 0; i < stackTraceElements.length; i++) {
            System.out.println("DEBUG_TRACE: " + stackTraceElements[i].getClassName());
        }*/
        //for (StackTraceElement element : stackTrace)
        if (stackTraceElements.length >= 4) {
            return Thread.currentThread().getStackTrace()[4].getClassName();
        } else if (stackTraceElements.length == 3) {
            return Thread.currentThread().getStackTrace()[3].getClassName();
        } else if (stackTraceElements.length == 2) {
            return Thread.currentThread().getStackTrace()[2].getClassName();
        }
        return "";
    }

    protected static String getCallerClassNameOnly() {
        String fullClassName = "";
        String className = "";
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if (stackTraceElements.length >= 4) {
            fullClassName = Thread.currentThread().getStackTrace()[4].getClassName();
            className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
            return className;
        } else if (stackTraceElements.length == 3) {
            fullClassName = Thread.currentThread().getStackTrace()[3].getClassName();
            className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
            return className;
        } else if (stackTraceElements.length == 2) {
            fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
            className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
            return className;
        }
        return className;
    }

    protected static String getCallerMethodName() {
        /*String callerClassName = new Exception().getStackTrace()[1].getClassName();
        String calleeClassName = new Exception().getStackTrace()[0].getClassName();*/
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if (stackTraceElements.length >= 4) {
            return Thread.currentThread().getStackTrace()[4].getMethodName();
        } else if (stackTraceElements.length == 3) {
            return Thread.currentThread().getStackTrace()[3].getMethodName();
        } else if (stackTraceElements.length == 2) {
            return Thread.currentThread().getStackTrace()[2].getMethodName();
        }
        return "";
    }

    protected static String getCallerLineNumber() {
        /*String callerClassName = new Exception().getStackTrace()[1].getClassName();
        String calleeClassName = new Exception().getStackTrace()[0].getClassName();*/
        Throwable throwable = new Throwable();
        StackTraceElement[] stackTraceElements = throwable.getStackTrace();
        /*for (StackTraceElement element : stackTraceElements) {
            System.out.println("LINE_NUMBER: " + element.getLineNumber());
        }*/
        //StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if (stackTraceElements.length >= 4) {
            return Thread.currentThread().getStackTrace()[4].getLineNumber() + "";
        } else if (stackTraceElements.length == 3) {
            return Thread.currentThread().getStackTrace()[3].getLineNumber() + "";
        } else if (stackTraceElements.length == 2) {
            return Thread.currentThread().getStackTrace()[2].getLineNumber() + "";
        }
        return "";
    }

    protected static String getCallerFileName() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if (stackTraceElements.length >= 4) {
            return stackTraceElements[4].getFileName() + "";
        } else if (stackTraceElements.length == 3) {
            return stackTraceElements[3].getFileName() + "";
        } else if (stackTraceElements.length == 2) {
            return stackTraceElements[2].getFileName() + "";
        }
        /*String retVal = "";
        for (StackTraceElement element : stackTraceElements) {
            retVal += element.getFileName() + " ";
        }
        return retVal;*/
        return "";
    }

    protected static String getCallerClassNameTemp() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (int i = 1; i < stackTraceElements.length; i++) {
            StackTraceElement ste = stackTraceElements[i];
            /*if (!ste.getClassName().equals(KDebug.class.getName()) && ste.getClassName().indexOf("java.lang.Thread") != 0) {
                return ste.getClassName();
            }*/
        }
        return null;
    }

    /*"Class Name:- " + getCallerClassName() + "; "
                + "Method Name:- " + getCallerMethodName() + "; "
                + "Line Number:- " + getCallerLineNumber() + "; "
                + "File Name:- " + getCallerFileName();*/

    //return stackTraceElements[3].getFileName() + "";
    protected static void LogLoopPrint() {
        StringBuilder stringBuilder = new StringBuilder();
        StackTraceElement[] stackTraceElements = new Throwable().fillInStackTrace().getStackTrace();
        String callingClass = "<unknown>";
        String callerMethod = "<unknown>";
        String lineNumber = "<unknown>";
        String fileName = "<unknown>";
        stringBuilder.append("Class Name:- " + callingClass);
        stringBuilder.append("Method Name:- " + callerMethod);
        stringBuilder.append("Line Number:- " + lineNumber);
        stringBuilder.append("File Name:- " + fileName);
        for (int i = 2; i < stackTraceElements.length; i++) {
            String className = stackTraceElements[i].getClassName();
            if (!isNullOrEmpty(className)) {
                if (!className.equals(CoreLogWriter.CLASS_NAME) && !className.equals(LogWriter.CLASS_NAME)) {
                    /*callingClass = stackTraceElements[i].getClassName();
                    callingClass = callingClass.substring(callingClass.lastIndexOf('.') + 1);
                    callingClass = callingClass.substring(callingClass.lastIndexOf('$') + 1);*/
                    callingClass = stackTraceElements[i].getClassName();
                    callerMethod = stackTraceElements[i].getMethodName();
                    lineNumber = stackTraceElements[i].getLineNumber() + "";
                    fileName = stackTraceElements[i].getFileName() + "";
                    stringBuilder.setLength(0);
                    stringBuilder.append(callingClass + " ");
                    stringBuilder.append("Method: " + callerMethod + " ");
                    stringBuilder.append("Line: " + lineNumber + " ");
                    stringBuilder.append(" File: " + fileName);
                    break;
                }
            }
        }
        System.out.println("LOG_PRINT: " + stringBuilder.toString());
    }

    protected static class ArrayHandle {
        public static Object[] reverse(Object[] arr) {
            List<Object> list = Arrays.asList(arr);
            Collections.reverse(list);
            return list.toArray();
        }
    }

    private static boolean isNullOrEmpty(String argValue) {
        if (argValue == null) {
            return true;
        }
        if (argValue.trim().isEmpty()) {
            return true;
        }
        if (argValue.equalsIgnoreCase("null")) {
            return true;
        }
        return false;
    }
}
