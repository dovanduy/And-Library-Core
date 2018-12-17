package com.rz.librarycore.caching;

import android.content.Context;
import android.util.Base64;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

/**
 * <h1>C0367a</h1>
 * <p>
 * Use for object memory cache
 * </p>
 *
 * @author Rz Rasel (Md. Rashed - Uz - Zaman)
 * @version 100.00.01
 * @since 2018-12-17
 */

class C0367a {

    public static Object m1386a(Context context, String str) throws UnsupportedEncodingException, NoSuchAlgorithmException, FileNotFoundException, ClassNotFoundException, IOException {
        str = C0367a.m1387a(str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getCache -> dataCacheKey ");
        stringBuilder.append(str);
        C0367a.m1394c(stringBuilder.toString());
        try {
            return new ObjectInputStream(context.openFileInput(str)).readObject();
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e2) {
            throw e2;
        } catch (ClassNotFoundException e3) {
            throw e3;
        }
    }

    private static String m1387a(String str) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        try {
            return C0367a.m1391b(Base64.encodeToString(str.getBytes("UTF-8"), 0));
        } catch (UnsupportedEncodingException e) {
            throw e;
        }
    }

    public static void m1388a(Context context) throws UnsupportedEncodingException, NoSuchAlgorithmException, FileNotFoundException, ClassNotFoundException, IOException {
        Object a = C0367a.m1386a(context, C0367a.m1390b(context));
        Set<String> hashSet = a != null ? (Set) a : new HashSet();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("clearAll -> size ");
        stringBuilder.append(hashSet.size());
        C0367a.m1394c(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("clearAll -> data ");
        stringBuilder.append(hashSet.toString());
        C0367a.m1394c(stringBuilder.toString());
        for (String d : hashSet) {
            File file = new File(C0367a.m1395d(context, d));
            if (file.exists()) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("onClearAll dataCacheKey ");
                stringBuilder.append(file);
                C0367a.m1394c(stringBuilder.toString());
                file.delete();
            }
        }
    }

    public static void m1389a(Context context, String str, Object obj) throws FileNotFoundException, NoSuchAlgorithmException, ClassNotFoundException, IOException {
        str = C0367a.m1387a(str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setCache -> dataCacheKey ");
        stringBuilder.append(str);
        C0367a.m1394c(stringBuilder.toString());
        try {
            OutputStream openFileOutput = context.openFileOutput(str, 0);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(openFileOutput);
            objectOutputStream.writeObject(obj);
            objectOutputStream.close();
            openFileOutput.close();
            C0367a.m1393c(context, str);
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e2) {
            throw e2;
        }
    }

    private static String m1390b(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("rzraselrz_raselcore_cache_file_name");
        stringBuilder.append(context.getPackageName());
        stringBuilder.append("fly_cache");
        stringBuilder.append(context.getPackageName());
        stringBuilder.append("rz_raselcache_file_namecore_cache_file_namefly_cacherz_raselrzrasel");
        return stringBuilder.toString();
    }

    private static String m1391b(String str) throws NoSuchAlgorithmException {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            int length = digest.length;
            for (int i = 0; i < length; i++) {
                stringBuffer.append(String.format("%02x", new Object[]{Integer.valueOf(digest[i] & 255)}));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            throw e;
        }
    }

    public static boolean m1392b(Context context, String str) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        File file = new File(C0367a.m1395d(context, C0367a.m1387a(str)));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onDeleteCache dataCacheKey ");
        stringBuilder.append(file);
        C0367a.m1394c(stringBuilder.toString());
        return file.exists() ? file.delete() : false;
    }

    private static void m1393c(Context context, String str) throws FileNotFoundException, NoSuchAlgorithmException, ClassNotFoundException, IOException {
        String b = C0367a.m1390b(context);
        String a = C0367a.m1387a(b);
        Object a2 = C0367a.m1386a(context, b);
        Set hashSet = a2 != null ? (Set) a2 : new HashSet();
        hashSet.add(str);
        try {
            OutputStream openFileOutput = context.openFileOutput(a, 0);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(openFileOutput);
            objectOutputStream.writeObject(hashSet);
            objectOutputStream.close();
            openFileOutput.close();
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e2) {
            throw e2;
        }
    }

    private static void m1394c(String str) {
        PrintStream printStream = System.out;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DEBUG_LOG_PRINT:  ");
        stringBuilder.append(str);
        printStream.println(stringBuilder.toString());
    }

    private static String m1395d(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getCacheDir().getParent());
        stringBuilder.append("");
        for (File file : new File(stringBuilder.toString()).listFiles()) {
            if (file.isDirectory()) {
                File file2 = new File(file, str);
                if (file2.exists()) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(file2);
                    stringBuilder2.append("");
                    return stringBuilder2.toString();
                }
            }
        }
        return "";
    }
}
