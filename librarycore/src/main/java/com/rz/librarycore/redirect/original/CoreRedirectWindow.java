package com.rz.librarycore.redirect.original;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

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
    private List<Integer> methodCallerList = new ArrayList<>();

    /*public CoreRedirectWindow(Context argContext) {
        context = argContext;
    }*/
    protected CoreRedirectWindow(Activity argActivity, Context argContext) {
        activity = argActivity;
        context = argContext;
    }

    protected Intent withRedirect(Class<?> argRedirectClass) {
        intent = new Intent(context, argRedirectClass);
        return intent;
    }

    /**
     * The Description of the method to explain what the method does
     *
     * @param argBundle type parameters used by the method
     * @return self class object
     */
    protected CoreRedirectWindow withBundle(Bundle argBundle) {
        this.bundle = argBundle;
        if (intent != null) {
            intent.putExtras(bundle);
        }
        return this;
    }

    protected CoreRedirectWindow withFlag() {
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        return this;
    }

    protected CoreRedirectWindow runRedirect() {
        activity.startActivity(intent);
        return this;
    }

    protected CoreRedirectWindow disposeWindow() {
        activity.finish();
        return this;
    }
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
//https://www.baeldung.com/java-parameter-reflection