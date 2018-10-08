package com.rz.librarycore.redirect;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
/**
 * Returns an Image object that can then be painted on the screen.
 * The url argument must specify an absolute {@link URL}. The name
 * argument is a specifier that is relative to the url argument.
 * <p>
 * This method always returns immediately, whether or not the
 * image exists. When this applet attempts to draw the image on
 * the screen, the data will be loaded. The graphics primitives
 * that draw the image will incrementally paint on the screen.
 * </p>
 *
 * @param  url  an absolute URL giving the base location of the image
 * @param  name the location of the image, relative to the url argument
 * @return      the image at the specified URL
 * @see         Image
 */
public class RedirectWindow {
    private Context context;
    private Intent intent;
    private Bundle bundle;
    private boolean haveFlag = false;

    public RedirectWindow(Context argContext) {
        context = argContext;
    }

    /**
     * The Description of the method to explain what the method does
     *
     * @param Bundle type parameters used by the method
     * @return self class object
     */
    public RedirectWindow setBundle(Bundle argBundle) {
        this.bundle = argBundle;
        return this;
    }

    public RedirectWindow setHaveFlag(boolean argHaveFlag) {
        this.haveFlag = argHaveFlag;
        return this;
    }

    public void onRedirect(Class<?> argRedirectClass) {
        intent = new Intent(context, argRedirectClass);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (haveFlag) {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }
}
/**
 * The Desciption of the method to explain what the method does
 *
 * @param the parameters used by the method
 * @return self class object
 * @throws what kind of exception does this method throw
 */