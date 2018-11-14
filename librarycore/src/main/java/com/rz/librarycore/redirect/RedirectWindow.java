package com.rz.librarycore.redirect;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

public class RedirectWindow {
    private Activity f1120a;
    private Context f1121b;
    private static RedirectWindow instance = null;
    private C0372a f1122d;

    public RedirectWindow(Activity argActivity, Context argContext) {
        this.f1120a = argActivity;
        this.f1121b = argContext;
    }

    public static RedirectWindow getInstance(Activity argActivity, Context argContext) {
        if (instance == null) {
            instance = new RedirectWindow(argActivity, argContext);
        }
        return instance;
    }

    public RedirectWindow withBundle(Bundle argBundle) {
        this.f1122d.m1397a(argBundle);
        return this;
    }

    public RedirectWindow withFlag() {
        this.f1122d.m1396a();
        return this;
    }

    public RedirectWindow disposeWindow() {
        this.f1122d.m1401b();
        return this;
    }

    public void runRedirect(Class<?> argRedirectClass) {
        this.f1122d.m1398a((Class) argRedirectClass);
    }

    public void runRedirect(Class<?> argRedirectClass, int argTimeMilliseconds) {
        this.f1122d.m1399a((Class) argRedirectClass, argTimeMilliseconds);
    }

    public void runRedirect(Class<?> argRedirectClass, int argTimeMilliseconds, OnEventListener argOnEventListener) {
        this.f1122d.m1400a(argRedirectClass, argTimeMilliseconds, argOnEventListener);
    }

    public interface OnEventListener {
        public boolean onDependencyWait();
    }
}
