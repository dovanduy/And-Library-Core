package com.rz.usagesexampl.done;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class CoreRedirectWindow {
    private Activity activity;
    private Context context;
    private Intent intent;
    private Bundle bundle;
    private Class<?> redirectClass;
    private List<Integer> methodCallerList = new ArrayList<>();
    private Handler handlerRedirect;
    private RedirectWindow.OnEventListener onEventListener;
    private boolean isDependencyWait = true;
    private String methodName = "methodName";

    /*public CoreRedirectWindow(Context argContext) {
        context = argContext;
    }*/
    protected CoreRedirectWindow(Activity argActivity, Context argContext) {
        methodName = "CoreRedirectWindow(Activity argActivity, Context argContext)";
        activity = argActivity;
        context = argContext;
        methodCallerList = new ArrayList<>();
        methodCallerList.clear();
    }

    /*protected Intent withRedirect(Class<?> argRedirectClass) {
        intent = new Intent(context, argRedirectClass);
        return intent;
    }*/
    /*@Deprecated
    protected CoreRedirectWindow withRedirect(Class<?> argRedirectClass) {
        redirectClass = argRedirectClass;
        methodCallerList.add(1);
        return this;
    }*/

    protected CoreRedirectWindow withIntent(Intent argIntent) {
        methodName = "withIntent(Intent argIntent)";
        //methodCallerList.add(1);
        setPriority();
        return this;
    }

    /**
     * The Description of the method to explain what the method does
     *
     * @param argBundle type parameters used by the method
     * @return self class object
     */
    protected CoreRedirectWindow withBundle(Bundle argBundle) {
        methodName = "withBundle(Bundle argBundle)";
        setPriority();
        this.bundle = argBundle;
        /*if (intent != null) {
            intent.putExtras(bundle);
        }*/
        //methodCallerList.add(2);
        return this;
    }

    protected CoreRedirectWindow withFlag() {
        methodName = "withFlag()";
        setPriority();
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        //methodCallerList.add(3);
        return this;
    }

    protected CoreRedirectWindow disposeWindow() {
        methodName = "disposeWindow()";
        setPriority();
        //activity.finish();
        //methodCallerList.add(5);
        return this;
    }

    /*@Deprecated
    protected void runRedirect() {
        //activity.startActivity(intent);
        methodCallerList.add(5);
        onRun();
        return;
    }*/

    protected void execute(Class<?> argRedirectClass) {
        methodName = "execute(Class<?> argRedirectClass)";
        setPriority();
        //activity.startActivity(intent);
        redirectClass = argRedirectClass;
        //intent = new Intent(context, redirectClass);
        //methodCallerList.add(4);
        onRun();
        return;
    }

    protected void execute(Class<?> argRedirectClass, int argTimeMilliseconds) {
        methodName = "execute(Class<?> argRedirectClass, int argTimeMilliseconds)";
        setPriority();
        redirectClass = argRedirectClass;
        //intent = new Intent(context, redirectClass);
        handlerRedirect = new Handler();
        //methodCallerList.add(4);
        isDependencyWait = true;
        handlerRedirect.postDelayed(threadRedirect, argTimeMilliseconds);
        return;
    }

    protected void execute(Class<?> argRedirectClass, int argTimeMilliseconds, RedirectWindow.OnEventListener argOnEventListener) {
        methodName = "execute(Class<?> argRedirectClass, int argTimeMilliseconds, RedirectWindow.OnEventListener argOnEventListener)";
        setPriority();
        redirectClass = argRedirectClass;
        onEventListener = argOnEventListener;
        //intent = new Intent(context, redirectClass);
        handlerRedirect = new Handler();
        ///methodCallerList.add(4);
        isDependencyWait = false;
        handlerRedirect.postDelayed(threadRedirect, argTimeMilliseconds);
        return;
    }

    protected void onRun() {
        methodName = "onRun()";
        Collections.sort(methodCallerList, new Comparator<Integer>() {
            @Override
            public int compare(Integer objLeftSide, Integer objRightSide) {
                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                return objLeftSide > objRightSide ? 1 : (objLeftSide < objRightSide) ? -1 : 0;
            }
        });
        intent = new Intent(context, redirectClass);
        Iterator iterator = methodCallerList.iterator();
        while (iterator.hasNext()) {
            int value = (int) iterator.next();
            /*if (value == 1) {
                intent = new Intent(context, redirectClass);
                System.out.println("Intent: " + value);
            } else*/
            if (value == 1) {
            } else if (value == 2) {
                intent.putExtras(bundle);
            } else if (value == 3) {
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            } else if (value == 4) {
                activity.startActivity(intent);
            } else if (value == 5) {
                activity.finish();
            }
            //System.out.println("Values: " + value);
        }
    }

    protected Thread threadRedirect = new Thread(new Runnable() {
        @Override
        public void run() {
            if (isDependencyWait) {
                onRun();
                //System.out.println("RUN_CALLED");
                handlerRedirect.removeCallbacks(threadRedirect);
            } else {
                isDependencyWait = onEventListener.onDependencyWait();
                //System.out.println("RUN_CALLED_REDIRECT_WAIT: " + isDependencyWait);
                handlerRedirect.postDelayed(threadRedirect, 50);
            }
        }
    });

    private enum PRIORITY {
        WITH_INTENT(1),
        WITH_BUNDLE(2),
        WITH_FLAG(3),
        EXECUTE(4),
        DISPOSE_WINDOW(5);
        private int item;

        PRIORITY(int argValue) {
            this.item = argValue;
        }

        public int getItem() {
            return this.item;
        }
    }

    private void setPriority() {
        methodName = "setPriority()";
        //String strMethodName = argMethodName.replaceAll("(.)([A-Z])", "$1_$2").toUpperCase();
        String strMethodName = Thread.currentThread().getStackTrace()[3].getMethodName()
                .replaceAll("(.)([A-Z])", "$1_$2").toUpperCase();
        //System.out.println("METHOD_NAME: " + strMethodName);
        if (containsEnum(PRIORITY.class, strMethodName)) {
            //System.out.println("ENUM_VALUE: " + PRIORITY.valueOf(strMethodName).getItem());
            int priority = PRIORITY.valueOf(strMethodName).item;
            methodCallerList.add(priority);
        }
    }

    private <E extends Enum<E>> boolean containsEnum(Class<E> argEnum, String argValue) {
        methodName = "containsEnum(Class<E> argEnum, String argValue)";
        for (Enum<E> item : argEnum.getEnumConstants()) {
            if (item.toString().equals(argValue)) {
                return true;
            }
        }
        return false;
    }
}

class CollectionSort {
    private List<Integer> methodCallerList = new ArrayList<>();

    protected void sortAscending() {
        methodCallerList.clear();
        methodCallerList.add(1);
        methodCallerList.add(3);
        methodCallerList.add(2);
        methodCallerList.add(5);
        methodCallerList.add(4);
        Collections.sort(methodCallerList, new Comparator<Integer>() {
            @Override
            public int compare(Integer objLeftSide, Integer objRightSide) {
                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                return objLeftSide > objRightSide ? 1 : (objLeftSide < objRightSide) ? -1 : 0;
            }
        });
        Iterator iterator = methodCallerList.iterator();
        while (iterator.hasNext()) {
            System.out.println("LOG_PRINT: " + iterator.next());
        }
    }

    protected void sortDescending() {
        methodCallerList.clear();
        methodCallerList.add(1);
        methodCallerList.add(3);
        methodCallerList.add(2);
        methodCallerList.add(5);
        methodCallerList.add(4);
        Collections.sort(methodCallerList, new Comparator<Integer>() {
            @Override
            public int compare(Integer objLeftSide, Integer objRightSide) {
                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                return objLeftSide > objRightSide ? -1 : (objLeftSide < objRightSide) ? 1 : 0;
            }
        });
        Iterator iterator = methodCallerList.iterator();
        while (iterator.hasNext()) {
            System.out.println("LOG_PRINT: " + iterator.next());
        }
    }

    protected void sortCustom() {
        ArrayList<ModelData> modelDataArrayList = new ArrayList<>();
        Collections.sort(modelDataArrayList, new Comparator<ModelData>() {
            public int compare(ModelData objOne, ModelData objTwo) {
                return objOne.getName().compareTo(objTwo.getName());
            }
        });
        Collections.reverse(modelDataArrayList);
    }

    public class ModelData {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private void someMethod(int argValue) {
        System.out.println(argValue);
    }

    public void reflectionTest() {
        String strMethodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        //setPriority();
        try {
            String className = this.getClass().getName();
            Class<?> typeClass = Class.forName(className);
            Object object = typeClass.newInstance();
            String methodName = "someMethod";
            //Method method = object.getClass().getMethod(methodName);
            Method method = object.getClass().getDeclaredMethod(methodName, int.class);
            method.invoke(object, 10);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}