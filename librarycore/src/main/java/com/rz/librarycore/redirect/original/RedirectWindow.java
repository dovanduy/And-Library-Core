package com.rz.librarycore.redirect.original;

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
    //private RedirectWindow redirectWindow = new RedirectWindow(activity, context);

    public static RedirectWindow getInstance(Activity argActivity, Context argContext) {
        if (instance == null) {
            instance = new RedirectWindow(argActivity, argContext);
        }
        return instance;
    }

    public RedirectWindow(Activity argActivity, Context argContext) {
        activity = argActivity;
        context = argContext;
        coreRedirectWindow = new CoreRedirectWindow(activity, context);
        //coreRedirectWindow.setCoreRedirectWindow(activity, context);
    }

    public Intent withRedirect(Class<?> argRedirectClass) {
        return coreRedirectWindow.withRedirect(argRedirectClass);
    }

    /**
     * The Description of the method to explain what the method does
     *
     * @param argBundle type parameters used by the method
     * @return self class object
     */
    public RedirectWindow withBundle(Bundle argBundle) {
        coreRedirectWindow.withBundle(argBundle);
        return this;
    }

    public RedirectWindow withFlag() {
        coreRedirectWindow.withFlag();
        return this;
    }

    public RedirectWindow runRedirect() {
        coreRedirectWindow.runRedirect();
        return this;
    }

    public RedirectWindow disposeWindow() {
        coreRedirectWindow.disposeWindow();
        return this;
    }
}

/**
 * The Desciption of the method to explain what the method does
 *
 * @param the parameters used by the method
 * @return self class object
 * @throws what kind of exception does this method throw
 */