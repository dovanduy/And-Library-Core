package com.rz.librarycore.redirect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.rz.librarycore.redirect.RedirectWindow.OnEventListener;

class C0372a {
    private Class<?> f1109a;
    private Activity f1110b;
    private Context f1111c;
    private Intent f1112d;
    private Bundle f1113e;
    private List<Integer> f1114f = new ArrayList();
    private Handler f1115g;
    private OnEventListener f1116h;
    private boolean f1117i = true;
    private Thread f1118j = new Thread(new C03701(this));

    class C03701 implements Runnable {
        final /* synthetic */ C0372a f1107a;

        C03701(C0372a c0372a) {
            this.f1107a = c0372a;
        }

        public void run() {
            if (this.f1107a.f1117i) {
                this.f1107a.m1393c();
                this.f1107a.f1115g.removeCallbacks(this.f1107a.f1118j);
                return;
            }
            this.f1107a.f1117i = this.f1107a.f1116h.onDependencyWait();
            this.f1107a.f1115g.postDelayed(this.f1107a.f1118j, 50);
        }
    }

    class C03712 implements Comparator<Integer> {
        final /* synthetic */ C0372a f1108a;

        C03712(C0372a c0372a) {
            this.f1108a = c0372a;
        }

        public int m1388a(Integer num, Integer num2) {
            return num.intValue() > num2.intValue() ? 1 : num.intValue() < num2.intValue() ? -1 : 0;
        }

        @Override
        public int compare(Integer obj, Integer obj2) {
            return m1388a((Integer) obj, (Integer) obj2);
        }
    }

    protected C0372a(Activity activity, Context context) {
        this.f1110b = activity;
        this.f1111c = context;
        this.f1114f.clear();
    }

    private void m1393c() {
        Collections.sort(this.f1114f, new C03712(this));
        this.f1112d = new Intent(this.f1111c, this.f1109a);
        for (Integer intValue : this.f1114f) {
            int intValue2 = intValue.intValue();
            if (intValue2 != 1) {
                if (intValue2 == 2) {
                    this.f1112d.putExtras(this.f1113e);
                } else if (intValue2 == 3) {
                    this.f1112d.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                } else if (intValue2 == 4) {
                    this.f1110b.startActivity(this.f1112d);
                } else if (intValue2 == 5) {
                    this.f1110b.finish();
                }
            }
        }
    }

    protected C0372a m1396a() {
        this.f1114f.add(Integer.valueOf(3));
        return this;
    }

    protected C0372a m1397a(Bundle bundle) {
        this.f1113e = bundle;
        this.f1114f.add(Integer.valueOf(2));
        return this;
    }

    protected void m1398a(Class<?> cls) {
        this.f1109a = cls;
        this.f1114f.add(Integer.valueOf(4));
        m1393c();
    }

    protected void m1399a(Class<?> cls, int i) {
        this.f1109a = cls;
        this.f1115g = new Handler();
        this.f1114f.add(Integer.valueOf(4));
        this.f1117i = true;
        this.f1115g.postDelayed(this.f1118j, (long) i);
    }

    protected void m1400a(Class<?> cls, int i, OnEventListener c0373a) {
        this.f1109a = cls;
        this.f1116h = c0373a;
        this.f1115g = new Handler();
        this.f1114f.add(Integer.valueOf(4));
        this.f1117i = false;
        this.f1115g.postDelayed(this.f1118j, (long) i);
    }

    protected C0372a m1401b() {
        this.f1114f.add(Integer.valueOf(5));
        return this;
    }
}
