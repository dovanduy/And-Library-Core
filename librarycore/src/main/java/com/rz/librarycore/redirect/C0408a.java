package com.rz.librarycore.redirect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

class C0408a {
    private Activity f1456a;
    private Context f1457b;
    private Intent f1458c;
    private Bundle f1459d;
    private List<Integer> f1460e = new ArrayList();

    protected C0408a(Activity activity, Context context) {
        this.f1456a = activity;
        this.f1457b = context;
    }

    protected Intent m1628a(Class<?> cls) {
        this.f1458c = new Intent(this.f1457b, cls);
        return this.f1458c;
    }

    protected C0408a m1629a() {
        this.f1458c.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        return this;
    }

    protected C0408a m1630a(Bundle bundle) {
        this.f1459d = bundle;
        if (this.f1458c != null) {
            this.f1458c.putExtras(this.f1459d);
        }
        return this;
    }

    protected C0408a m1631b() {
        this.f1456a.startActivity(this.f1458c);
        return this;
    }

    protected C0408a m1632c() {
        this.f1456a.finish();
        return this;
    }
}
