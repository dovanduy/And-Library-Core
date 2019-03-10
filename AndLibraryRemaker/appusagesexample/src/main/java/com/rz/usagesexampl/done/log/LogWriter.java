package com.rz.usagesexampl.done.log;

public class LogWriter {
    public static boolean isDebug = true;
    protected static final String CLASS_NAME = LogWriter.class.getName();
    private static String methodName = "methodName";

    public static void Log(String argMessage) {
        methodName = "Log(String argMessage)";
        //|------------------------------------------------------------|
        if (!isDebug) {
            return;
        }
        CoreLogWriter.isDebug = isDebug;
        CoreLogWriter.Log(argMessage);
        //|------------------------------------------------------------|
    }

    public static void Log(String argTag, String argMessage) {
        methodName = "Log(String argTag, String argMessage)";
        //|------------------------------------------------------------|
        if (!isDebug) {
            return;
        }
        CoreLogWriter.isDebug = isDebug;
        CoreLogWriter.Log(argTag, argMessage);
    }


    public static void dLog(String argMessage) {
        methodName = "dLog(String argMessage)";
        //|------------------------------------------------------------|
        if (!isDebug) {
            return;
        }
        CoreLogWriter.isDebug = isDebug;
        CoreLogWriter.dLog(argMessage);
        //|------------------------------------------------------------|
    }

    public static void dLog(String argTag, String argMessage) {
        methodName = "dLog(String argTag, String argMessage)";
        //|------------------------------------------------------------|
        if (!isDebug) {
            return;
        }
        CoreLogWriter.isDebug = isDebug;
        CoreLogWriter.dLog(argTag, argMessage);
        //|------------------------------------------------------------|
    }

    public static void eLog(String argMessage) {
        methodName = "eLog(String argMessage)";
        //|------------------------------------------------------------|
        if (!isDebug) {
            return;
        }
        CoreLogWriter.isDebug = isDebug;
        CoreLogWriter.eLog(argMessage);
        //|------------------------------------------------------------|
    }

    public static void eLog(String argTag, String argMessage) {
        methodName = "eLog(String argTag, String argMessage)";
        //|------------------------------------------------------------|
        if (!isDebug) {
            return;
        }
        CoreLogWriter.isDebug = isDebug;
        CoreLogWriter.eLog(argTag, argMessage);
        //|------------------------------------------------------------|
    }

    public static void iLog(String argMessage) {
        methodName = "iLog(String argMessage)";
        //|------------------------------------------------------------|
        if (!isDebug) {
            return;
        }
        CoreLogWriter.isDebug = isDebug;
        CoreLogWriter.iLog(argMessage);
        //|------------------------------------------------------------|
    }

    public static void iLog(String argTag, String argMessage) {
        methodName = "iLog(String argTag, String argMessage)";
        //|------------------------------------------------------------|
        if (!isDebug) {
            return;
        }
        CoreLogWriter.isDebug = isDebug;
        CoreLogWriter.iLog(argTag, argMessage);
        //|------------------------------------------------------------|
    }

    public static void vLog(String argMessage) {
        methodName = "vLog(String argMessage)";
        //|------------------------------------------------------------|
        if (!isDebug) {
            return;
        }
        CoreLogWriter.isDebug = isDebug;
        CoreLogWriter.vLog(argMessage);
        //|------------------------------------------------------------|
    }

    public static void vLog(String argTag, String argMessage) {
        methodName = "vLog(String argTag, String argMessage)";
        //|------------------------------------------------------------|
        if (!isDebug) {
            return;
        }
        CoreLogWriter.isDebug = isDebug;
        CoreLogWriter.vLog(argTag, argMessage);
        //|------------------------------------------------------------|
    }

    public static void wtfLog(String argMessage) {
        methodName = "wtfLog(String argMessage)";
        //|------------------------------------------------------------|
        if (!isDebug) {
            return;
        }
        CoreLogWriter.isDebug = isDebug;
        CoreLogWriter.wtfLog(argMessage);
        //|------------------------------------------------------------|
    }

    public static void wtfLog(String argTag, String argMessage) {
        methodName = "wtfLog(String argTag, String argMessage)";
        //|------------------------------------------------------------|
        if (!isDebug) {
            return;
        }
        CoreLogWriter.isDebug = isDebug;
        CoreLogWriter.wtfLog(argTag, argMessage);
        //|------------------------------------------------------------|
    }

    private static void LogLoopPrint() {
        //|------------------------------------------------------------|
        if (!isDebug) {
            return;
        }
        CoreLogWriter.isDebug = isDebug;
        CoreLogWriter.LogLoopPrint();
        //|------------------------------------------------------------|
    }

    private static void LogLoopPrint(String argDesiredClassName) {
        //|------------------------------------------------------------|
        if (!isDebug) {
            return;
        }
        CoreLogWriter.isDebug = isDebug;
        CoreLogWriter.LogLoopPrint(argDesiredClassName);
        //|------------------------------------------------------------|
    }

    public static class Write {
        public static void Log(String argDesiredClassName, String argMessage) {
            methodName = "Log(String argDesiredClassName, String argMessage)";
            //|------------------------------------------------------------|
            if (!isDebug) {
                return;
            }
            CoreLogWriter.isDebug = isDebug;
            CoreLogWriter.Write.Log(argDesiredClassName, argMessage);
            //|------------------------------------------------------------|
        }

        public static void Log(String argDesiredClassName, String argTag, String argMessage) {
            methodName = "Log(String argDesiredClassName, String argTag, String argMessage)";
            //|------------------------------------------------------------|
            if (!isDebug) {
                return;
            }
            CoreLogWriter.isDebug = isDebug;
            CoreLogWriter.Write.Log(argDesiredClassName, argTag, argMessage);
        }


        public static void dLog(String argDesiredClassName, String argMessage) {
            methodName = "dLog(String argDesiredClassName, String argMessage)";
            //|------------------------------------------------------------|
            if (!isDebug) {
                return;
            }
            CoreLogWriter.isDebug = isDebug;
            CoreLogWriter.Write.dLog(argDesiredClassName, argMessage);
            //|------------------------------------------------------------|
        }

        public static void dLog(String argDesiredClassName, String argTag, String argMessage) {
            methodName = "dLog(String argDesiredClassName, String argTag, String argMessage)";
            //|------------------------------------------------------------|
            if (!isDebug) {
                return;
            }
            CoreLogWriter.isDebug = isDebug;
            CoreLogWriter.Write.dLog(argDesiredClassName, argTag, argMessage);
            //|------------------------------------------------------------|
        }

        public static void eLog(String argDesiredClassName, String argMessage) {
            methodName = "eLog(String argDesiredClassName, String argMessage)";
            //|------------------------------------------------------------|
            if (!isDebug) {
                return;
            }
            CoreLogWriter.isDebug = isDebug;
            CoreLogWriter.Write.eLog(argDesiredClassName, argMessage);
            //|------------------------------------------------------------|
        }

        public static void eLog(String argDesiredClassName, String argTag, String argMessage) {
            methodName = "eLog(String argDesiredClassName, String argTag, String argMessage)";
            //|------------------------------------------------------------|
            if (!isDebug) {
                return;
            }
            CoreLogWriter.isDebug = isDebug;
            CoreLogWriter.Write.eLog(argDesiredClassName, argTag, argMessage);
            //|------------------------------------------------------------|
        }

        public static void iLog(String argDesiredClassName, String argMessage) {
            methodName = "iLog(String argDesiredClassName, String argMessage)";
            //|------------------------------------------------------------|
            if (!isDebug) {
                return;
            }
            CoreLogWriter.isDebug = isDebug;
            CoreLogWriter.Write.iLog(argDesiredClassName, argMessage);
            //|------------------------------------------------------------|
        }

        public static void iLog(String argDesiredClassName, String argTag, String argMessage) {
            methodName = "iLog(String argDesiredClassName, String argTag, String argMessage)";
            //|------------------------------------------------------------|
            if (!isDebug) {
                return;
            }
            CoreLogWriter.isDebug = isDebug;
            CoreLogWriter.Write.iLog(argDesiredClassName, argTag, argMessage);
            //|------------------------------------------------------------|
        }

        public static void vLog(String argDesiredClassName, String argMessage) {
            methodName = "vLog(String argDesiredClassName, String argMessage)";
            //|------------------------------------------------------------|
            if (!isDebug) {
                return;
            }
            CoreLogWriter.isDebug = isDebug;
            CoreLogWriter.Write.vLog(argDesiredClassName, argMessage);
            //|------------------------------------------------------------|
        }

        public static void vLog(String argDesiredClassName, String argTag, String argMessage) {
            methodName = "vLog(String argDesiredClassName, String argTag, String argMessage)";
            //|------------------------------------------------------------|
            if (!isDebug) {
                return;
            }
            CoreLogWriter.isDebug = isDebug;
            CoreLogWriter.Write.vLog(argDesiredClassName, argTag, argMessage);
            //|------------------------------------------------------------|
        }

        public static void wtfLog(String argDesiredClassName, String argMessage) {
            methodName = "wtfLog(String argDesiredClassName, String argMessage)";
            //|------------------------------------------------------------|
            if (!isDebug) {
                return;
            }
            CoreLogWriter.isDebug = isDebug;
            CoreLogWriter.Write.wtfLog(argDesiredClassName, argMessage);
            //|------------------------------------------------------------|
        }

        public static void wtfLog(String argDesiredClassName, String argTag, String argMessage) {
            methodName = "wtfLog(String argDesiredClassName, String argTag, String argMessage)";
            //|------------------------------------------------------------|
            if (!isDebug) {
                return;
            }
            CoreLogWriter.isDebug = isDebug;
            CoreLogWriter.Write.wtfLog(argDesiredClassName, argTag, argMessage);
            //|------------------------------------------------------------|
        }
    }
}
