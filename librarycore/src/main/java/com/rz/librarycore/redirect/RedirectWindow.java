package com.rz.librarycore.redirect;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

public class RedirectWindow {
    private Activity f1128a;
    private Context f1129b;
    private static RedirectWindow instance = null;
    private C0372a f1130d;

    public RedirectWindow(Activity argActivity, Context argContext) {
        this.f1128a = argActivity;
        this.f1129b = argContext;
        this.f1130d = new C0372a(this.f1128a, this.f1129b);
    }

    public static RedirectWindow getInstance(Activity argActivity, Context argContext) {
        if (instance == null) {
            instance = new RedirectWindow(argActivity, argContext);
        }
        return instance;
    }

    public RedirectWindow withBundle(Bundle bundle) {
        this.f1130d.m1409a(bundle);
        return this;
    }

    public RedirectWindow withFlag() {
        this.f1130d.m1408a();
        return this;
    }

    public RedirectWindow disposeWindow() {
        this.f1130d.m1413b();
        return this;
    }

    public void run(Class<?> argRedirectClass) {
        this.f1130d.m1410a((Class) argRedirectClass);
    }

    public void run(Class<?> argRedirectClass, int argTimeMilliseconds) {
        this.f1130d.m1410a((Class) argRedirectClass, argTimeMilliseconds);
    }

    public void run(Class<?> argRedirectClass, int argTimeMilliseconds, OnEventListener argOnEventListener) {
        this.f1130d.m1410a(argRedirectClass, argTimeMilliseconds, argOnEventListener);
    }

    public interface OnEventListener {
        public boolean onDependencyWait();
    }
}