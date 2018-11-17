package com.rz.usagesexampl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

public class RedirectWindow {
    private Activity f1128a;
    private Context f1129b;
    private static RedirectWindow instance = null;
    private C0371a f1130d;

    public RedirectWindow(Activity argActivity, Context argContext) {
        this.f1128a = argActivity;
        this.f1129b = argContext;
        this.f1130d = new C0371a(this.f1128a, this.f1129b);
    }

    public static RedirectWindow getInstance(Activity argActivity, Context argContext) {
        if (instance == null) {
            instance = new RedirectWindow(argActivity, argContext);
        }
        return instance;
    }

    public RedirectWindow withBundle(Bundle argBundle) {
        this.f1130d.m1395a(argBundle);
        return this;
    }

    public RedirectWindow withFlag() {
        this.f1130d.m1394a();
        return this;
    }

    public RedirectWindow disposeWindow() {
        this.f1130d.m1399b();
        return this;
    }

    public void run(Class<?> argRedirectClass) {
        this.f1130d.m1396a((Class) argRedirectClass);
    }

    public void run(Class<?> argRedirectClass, int argTimeMilliseconds) {
        this.f1130d.m1397a((Class) argRedirectClass, argTimeMilliseconds);
    }

    public void run(Class<?> argRedirectClass, int argTimeMilliseconds, OnEventListener argOnEventListener) {
        this.f1130d.m1398a(argRedirectClass, argTimeMilliseconds, argOnEventListener);
    }

    public interface OnEventListener {
        boolean onDependencyWait();
    }
}
