package com.rz.librarycore.redirect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class RedirectWindow {
    private Activity f1462a;
    private Context f1463b;
    private static RedirectWindow instance = null;
    private C0408a f1464d;

    public static RedirectWindow getInstance(Activity argActivity, Context argContext) {
        if (instance == null) {
            instance = new RedirectWindow(argActivity, argContext);
        }
        return instance;
    }

    public RedirectWindow(Activity argActivity, Context argContext) {
        f1462a = argActivity;
        f1463b = argContext;
        f1464d = new C0408a(f1462a, f1463b);
    }

    public Intent withRedirect(Class<?> argRedirectClass) {
        return this.f1464d.m1628a(argRedirectClass);
    }

    public RedirectWindow withBundle(Bundle bundle) {
        this.f1464d.m1630a(bundle);
        return this;
    }

    public RedirectWindow withFlag() {
        this.f1464d.m1629a();
        return this;
    }

    public RedirectWindow runRedirect() {
        this.f1464d.m1631b();
        return this;
    }

    public RedirectWindow disposeWindow() {
        this.f1464d.m1632c();
        return this;
    }
}
