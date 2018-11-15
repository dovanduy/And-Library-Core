package com.rz.usagesexampl.done;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

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
    Class<?> redirectClass;
    private List<Integer> methodCallerList = new ArrayList<>();
    private Handler handlerRedirect;
    private RedirectWindow.OnEventListener onEventListener;
    private boolean isDependencyWait = true;

    /*public CoreRedirectWindow(Context argContext) {
        context = argContext;
    }*/
    protected CoreRedirectWindow(Activity argActivity, Context argContext) {
        activity = argActivity;
        context = argContext;
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
        methodCallerList.add(1);
        return this;
    }

    /**
     * The Description of the method to explain what the method does
     *
     * @param argBundle type parameters used by the method
     * @return self class object
     */
    protected CoreRedirectWindow withBundle(Bundle argBundle) {
        this.bundle = argBundle;
        /*if (intent != null) {
            intent.putExtras(bundle);
        }*/
        methodCallerList.add(2);
        return this;
    }

    protected CoreRedirectWindow withFlag() {
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        methodCallerList.add(3);
        return this;
    }

    protected CoreRedirectWindow disposeWindow() {
        //activity.finish();
        methodCallerList.add(5);
        return this;
    }

    /*@Deprecated
    protected void runRedirect() {
        //activity.startActivity(intent);
        methodCallerList.add(5);
        onRun();
        return;
    }*/

    protected void runRedirect(Class<?> argRedirectClass) {
        //activity.startActivity(intent);
        redirectClass = argRedirectClass;
        //intent = new Intent(context, redirectClass);
        methodCallerList.add(4);
        onRun();
        return;
    }

    protected void runRedirect(Class<?> argRedirectClass, int argTimeMilliseconds) {
        redirectClass = argRedirectClass;
        //intent = new Intent(context, redirectClass);
        handlerRedirect = new Handler();
        methodCallerList.add(4);
        isDependencyWait = true;
        handlerRedirect.postDelayed(threadRedirect, argTimeMilliseconds);
        return;
    }

    protected void runRedirect(Class<?> argRedirectClass, int argTimeMilliseconds, RedirectWindow.OnEventListener argOnEventListener) {
        redirectClass = argRedirectClass;
        onEventListener = argOnEventListener;
        //intent = new Intent(context, redirectClass);
        handlerRedirect = new Handler();
        methodCallerList.add(4);
        isDependencyWait = false;
        handlerRedirect.postDelayed(threadRedirect, argTimeMilliseconds);
        return;
    }

    private Thread threadRedirect = new Thread(new Runnable() {
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

    private void onRun() {
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

    /*protected interface OnEventListener {
        boolean onDependencyWait();
    }*/
}

class CollectionSort {
    private List<Integer> methodCallerList = new ArrayList<>();

    private void sortAscending() {
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

    private void sortDescending() {
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

    private void sortCustom() {
        ArrayList<ModelData> modelDataArrayList = new ArrayList<>();
        Collections.sort(modelDataArrayList, new Comparator<ModelData>() {
            public int compare(ModelData objOne, ModelData objTwo) {
                return objOne.getName().compareTo(objTwo.getName());
            }
        });
        Collections.reverse(modelDataArrayList);
    }

    class ModelData {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}