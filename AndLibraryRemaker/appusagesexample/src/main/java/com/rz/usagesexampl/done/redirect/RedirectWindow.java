package com.rz.usagesexampl.done.redirect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Returns an Image object that can then be painted on the screen.
 * The url argument must specify an absolute { @ link URL }. The name
 * argument is a specifier that is relative to the url argument.
 * <p>
 * This method always returns immediately, whether or not the
 * image exists. When this applet attempts to draw the image on
 * the screen, the data will be loaded. The graphics primitives
 * that draw the image will incrementally paint on the screen.
 * </p>
 * <p>
 * //@param  url  an absolute URL giving the base location of the image
 * //@param  name the location of the image, relative to the url argument
 * //@return      the image at the specified URL
 * //@see         Image
 */
public class RedirectWindow {
    private Activity activity;
    private Context context;
    private static RedirectWindow instance = null;
    private Intent intent;
    private CoreRedirectWindow coreRedirectWindow;
    private OnEventListener onEventListener;
    private String methodName = "methodName";
    //private RedirectWindow redirectWindow = new RedirectWindow(activity, context);

    public static RedirectWindow getInstance(Activity argActivity, Context argContext) {
        String staticMethodName = "RedirectWindow getInstance(Activity argActivity, Context argContext)";
        if (instance == null) {
            instance = new RedirectWindow(argActivity, argContext);
        }
        return instance;
    }

    public RedirectWindow(Activity argActivity, Context argContext) {
        methodName = "RedirectWindow(Activity argActivity, Context argContext)";
        activity = argActivity;
        context = argContext;
        coreRedirectWindow = new CoreRedirectWindow(activity, context);
        //coreRedirectWindow.setCoreRedirectWindow(activity, context);
    }

    /*@Deprecated
    public RedirectWindow withRedirect(Class<?> argRedirectClass) {
        coreRedirectWindow.withRedirect(argRedirectClass);
        return this;
    }*/

    /**
     * The Description of the method to explain what the method does
     *
     * @param argBundle type parameters used by the method
     * @return self class object
     */
    public RedirectWindow withBundle(Bundle argBundle) {
        methodName = "withBundle(Bundle argBundle)";
        coreRedirectWindow.withBundle(argBundle);
        return this;
    }

    public RedirectWindow withFlag() {
        methodName = "withFlag()";
        coreRedirectWindow.withFlag();
        return this;
    }

    public RedirectWindow disposeWindow() {
        methodName = "disposeWindow()";
        coreRedirectWindow.disposeWindow();
        return this;
    }

    /*@Deprecated
    public void runRedirect() {
        coreRedirectWindow.runRedirect();
        return;
    }*/

    public void run(Class<?> argRedirectClass) {
        methodName = "run(Class<?> argRedirectClass)";
        coreRedirectWindow.execute(argRedirectClass);
        return;
    }

    public void run(Class<?> argRedirectClass, int argTimeMilliseconds) {
        methodName = "run(Class<?> argRedirectClass, int argTimeMilliseconds)";
        coreRedirectWindow.execute(argRedirectClass, argTimeMilliseconds);
        return;
    }

    public void run(Class<?> argRedirectClass, int argTimeMilliseconds, OnEventListener argOnEventListener) {
        methodName = "run(Class<?> argRedirectClass, int argTimeMilliseconds, OnEventListener argOnEventListener)";
        coreRedirectWindow.execute(argRedirectClass, argTimeMilliseconds, argOnEventListener);
        return;
    }

    public interface OnEventListener {
        public boolean onDependencyWait();
    }

    public void getRandomString(int argStringLength) {
        //String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder stringBuilder = new StringBuilder();
        while (argStringLength-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            stringBuilder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        System.out.println("RANDOM_STRING: " + stringBuilder.toString());
        System.out.println("RANDOM_STRING: " + ALPHA_NUMERIC_STRING.toLowerCase());
        //return stringBuilder.toString();
    }
}

/**
 * The Desciption of the method to explain what the method does
 *
 * @param the parameters used by the method
 * @return self class object
 * @throws what kind of exception does this method throw
 */