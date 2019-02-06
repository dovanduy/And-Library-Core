package com.rz.librarycore.caching;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * <h1>MemoryCache</h1>
 * <p>
 * Use for object memory cache
 * </p>
 *
 * @author Rz Rasel (Md. Rashed - Uz - Zaman)
 * @version 100.00.01
 * @since 2018-12-17
 */

public class MemoryCache {

    public static Object getCache(Context context, String str) throws UnsupportedEncodingException, NoSuchAlgorithmException, FileNotFoundException, ClassNotFoundException, IOException {
        return C0367a.m1386a(context, str);
    }

    public static void setCache(Context context, String str, Object obj) throws NoSuchAlgorithmException, FileNotFoundException, ClassNotFoundException, IOException {
        C0367a.m1389a(context, str, obj);
    }

    public static boolean onDeleteCache(Context context, String str) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return C0367a.m1392b(context, str);
    }

    public static void onClearAll(Context context) throws UnsupportedEncodingException, NoSuchAlgorithmException, FileNotFoundException, ClassNotFoundException, IOException {
        C0367a.m1388a(context);
    }
}
