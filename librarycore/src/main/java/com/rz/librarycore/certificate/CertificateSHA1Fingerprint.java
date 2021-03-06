package com.rz.librarycore.certificate;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/**
 * Created by Rz Rasel on 2016-08-01.
 */
public class CertificateSHA1Fingerprint {
    //|----|------------------------------------------------------------|
    private static CertificateSHA1Fingerprint instance = null;

    //|----|------------------------------------------------------------|
    //|----|------------------------------------------------------------|
    public static CertificateSHA1Fingerprint getInstance() {
        if (instance == null) {
            instance = new CertificateSHA1Fingerprint();
        }
        return instance;
    }

    //|----|------------------------------------------------------------|
    public String getAuthKey(Context argContext) {
        //LogWriter.Log("123456789");
        return getCertificateSHA1Fingerprint(argContext);
    }

    //|----|------------------------------------------------------------|
    private String getCertificateSHA1Fingerprint_NEW_01(Context argContext) {
        //StringBuilder stringBuilder = new StringBuilder();
        String hexString = null;
        String packageName = argContext.getPackageName();
        PackageManager packageManager = argContext.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNATURES);
            //LogWriter.Log("PACKAGE_NAME: " + packageName);
            Signature[] signatures = packageInfo.signatures;

            for (Signature sig : signatures) {
                InputStream input = new ByteArrayInputStream(sig.toByteArray());
                CertificateFactory cf = CertificateFactory.getInstance("X509");
                X509Certificate cert = (X509Certificate) cf.generateCertificate(input);

                PublicKey publicKey = cert.getPublicKey();
                /*if (!whitelist.contains(publicKey.getEncoded())) {
                    throw new Exception("public key is not valid");
                }*/
                MessageDigest md = MessageDigest.getInstance("SHA1");
                byte[] keyByte = md.digest(publicKey.getEncoded());
                hexString = byte2HexFormatted(keyByte);
                //stringBuilder.append("Certificate subject: " + hexString + "<br>");
                //LogWriter.Log("CERTIFICATE: " + stringBuilder.toString());
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            // e.printStackTrace();
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        }
        return hexString;
    }
    //|----|------------------------------------------------------------|

    private String getCertificateSHA1Fingerprint(Context argContext) {
        //LogWriter.Log("123456789123456789");
        PackageManager pm = argContext.getPackageManager();
        String packageName = argContext.getPackageName();
        int flags = PackageManager.GET_SIGNATURES;
        PackageInfo packageInfo = null;
        try {
            packageInfo = pm.getPackageInfo(packageName, flags);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        Signature[] signatures = packageInfo.signatures;
        byte[] cert = signatures[0].toByteArray();
        InputStream input = new ByteArrayInputStream(cert);
        CertificateFactory cf = null;
        try {
            cf = CertificateFactory.getInstance("X509");
        } catch (CertificateException e) {
            e.printStackTrace();
        }
        X509Certificate c = null;
        try {
            c = (X509Certificate) cf.generateCertificate(input);
        } catch (CertificateException e) {
            e.printStackTrace();
        }
        String hexString = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            byte[] publicKey = md.digest(c.getEncoded());
            hexString = byte2HexFormatted(publicKey);
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (CertificateEncodingException e) {
            e.printStackTrace();
        }
        return hexString;
    }
    //|----|------------------------------------------------------------|

    public static String byte2HexFormatted(byte[] arr) {
        StringBuilder str = new StringBuilder(arr.length * 2);
        for (int i = 0; i < arr.length; i++) {
            String h = Integer.toHexString(arr[i]);
            int l = h.length();
            if (l == 1) h = "0" + h;
            if (l > 2) h = h.substring(l - 2, l);
            str.append(h.toUpperCase());
            if (i < (arr.length - 1)) str.append(':');
        }
        return str.toString();
    }
    //|----|------------------------------------------------------------|
}