package com.rz.usagesexampl.working.caching;

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
    private static String methodName = "methodName-var";

    public static void setCache(Context argContext, String argCacheKey, Object argObject) throws NoSuchAlgorithmException, FileNotFoundException, ClassNotFoundException, IOException {
        methodName = "static void setCache(Context argContext, String argCacheKey, Object argObject) throws NoSuchAlgorithmException, FileNotFoundException, ClassNotFoundException, IOException";
        CoreMemoryCache.setCache(argContext, argCacheKey, argObject);
    }

    public static Object getCache(Context argContext, String argCacheKey) throws UnsupportedEncodingException, NoSuchAlgorithmException, FileNotFoundException, ClassNotFoundException, IOException {
        methodName = "static Object getCache(Context argContext, String argCacheKey) throws UnsupportedEncodingException, NoSuchAlgorithmException, FileNotFoundException, ClassNotFoundException, IOException";
        return CoreMemoryCache.getCache(argContext, argCacheKey);
    }

    public static boolean onDeleteCache(Context argContext, String argCacheKey) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        methodName = "static boolean onDeleteCache(Context argContext, String argCacheKey) throws UnsupportedEncodingException, NoSuchAlgorithmException";
        return CoreMemoryCache.onDeleteCache(argContext, argCacheKey);
    }

    public static void onClearAll(Context argContext) throws UnsupportedEncodingException, NoSuchAlgorithmException, FileNotFoundException, ClassNotFoundException, IOException {
        methodName = "static void onClearAll(Context argContext) throws UnsupportedEncodingException, NoSuchAlgorithmException, FileNotFoundException, ClassNotFoundException, IOException";
        CoreMemoryCache.onClearAll(argContext);
    }
}