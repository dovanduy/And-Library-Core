package com.rz.librarycore.redirect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.rz.librarycore.redirect.RedirectWindow.OnEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class C0372a {
    protected Thread f1116a;
    private Activity f1117b;
    private Context f1118c;
    private Intent f1119d;
    private Bundle f1120e;
    private Class<?> f1121f;
    private List<Integer> f1122g;
    private Handler f1123h;
    private OnEventListener f1124i;
    private boolean f1125j;

    protected C0372a(Activity activity, Context context) {
        this.f1122g = new ArrayList();
        this.f1125j = true;
        this.f1116a = new Thread(new C03702(this));
        this.f1117b = activity;
        this.f1118c = context;
        this.f1122g = new ArrayList();
        this.f1122g.clear();
    }

    protected C0372a m1409a(Bundle bundle) {
        m1407d();
        this.f1120e = bundle;
        return this;
    }

    protected C0372a m1408a() {
        m1407d();
        return this;
    }

    protected C0372a m1413b() {
        m1407d();
        return this;
    }

    protected void m1410a(Class<?> cls) {
        m1407d();
        this.f1121f = cls;
        m1414c();
    }

    protected void m1410a(Class<?> cls, int i) {
        m1407d();
        this.f1121f = cls;
        this.f1123h = new Handler();
        this.f1125j = true;
        this.f1123h.postDelayed(this.f1116a, (long) i);
    }

    protected void m1410a(Class<?> cls, int i, OnEventListener c0373a) {
        m1407d();
        this.f1121f = cls;
        this.f1124i = c0373a;
        this.f1123h = new Handler();
        this.f1125j = false;
        this.f1123h.postDelayed(this.f1116a, (long) i);
    }

    protected void m1414c() {
        Collections.sort(this.f1122g, new C03691(this));
        this.f1119d = new Intent(this.f1118c, this.f1121f);
        for (Integer intValue : this.f1122g) {
            int intValue2 = intValue.intValue();
            if (intValue2 != 1) {
                if (intValue2 == 2) {
                    this.f1119d.putExtras(this.f1120e);
                } else if (intValue2 == 3) {
                    this.f1119d.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                } else if (intValue2 == 4) {
                    this.f1117b.startActivity(this.f1119d);
                } else if (intValue2 == 5) {
                    this.f1117b.finish();
                }
            }
        }
    }

    private void m1407d() {
        String toUpperCase = Thread.currentThread().getStackTrace()[3].getMethodName().replaceAll("(.)([A-Z])", "$1_$2").toUpperCase();
        if (m1404a(C0371a.class, toUpperCase)) {
            this.f1122g.add(Integer.valueOf(C0371a.valueOf(toUpperCase).f1115f));
        }
    }

    class C03702 implements Runnable {
        final C0372a f1108a;

        C03702(C0372a c0372a) {
            this.f1108a = c0372a;
        }

        public void run() {
            if (this.f1108a.f1125j) {
                this.f1108a.m1414c();
                this.f1108a.f1123h.removeCallbacks(this.f1108a.f1116a);
                return;
            }
            this.f1108a.f1125j = this.f1108a.f1124i.onDependencyWait();
            this.f1108a.f1123h.postDelayed(this.f1108a.f1116a, 50);
        }
    }

    class C03691 implements Comparator<Integer> {
        final C0372a f1107a;

        C03691(C0372a c0372a) {
            this.f1107a = c0372a;
        }

        public int m1400a(Integer num, Integer num2) {
            return num.intValue() > num2.intValue() ? 1 : num.intValue() < num2.intValue() ? -1 : 0;
        }

        public int compare(Integer obj, Integer obj2) {
            return m1400a((Integer) obj, (Integer) obj2);
        }
    }

    private <E extends Enum<E>> boolean m1404a(Class<E> cls, String str) {
        for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
            if (enumR.toString().equals(str)) {
                return true;
            }
        }
        return false;
    }

    private enum C0371a {
        WITH_INTENT(1),
        M1409A(2),
        M1408A(3),
        M1410A(4),
        M1413B(5);

        private int f1115f;

        private C0371a(int i) {
            this.f1115f = i;
        }
    }
}
