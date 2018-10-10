package com.rz.librarycore.cryption;

import android.text.TextUtils;
import android.util.Base64;

import com.rz.librarycore.enums.Algorithm;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Locale;

/**
 * Created by Rz Rasel 2018-02-19.
 */

public class SHAEncryptor {
    /**
     * Convert a chain of bytes into a {@link String}
     *
     * @param argBytes The chain of bytes
     * @return The converted String
     */
    private static String bytes2Hex(byte[] argBytes) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < argBytes.length; n++) {
            stmp = (Integer.toHexString(argBytes[n] & 0XFF));
            if (stmp.length() == 1) {
                hs += "0" + stmp;
            } else {
                hs += stmp;
            }
        }
        return hs.toLowerCase(Locale.ENGLISH);
    }

    /**
     * Allows to get the SHA of a {@link String} using {@link MessageDigest}
     * if device does not support sha-256, fall back to sha-1 instead
     */
    public static String getSHA(String argText, Algorithm argAlgorithm) {
        String sha = "";
        if (TextUtils.isEmpty(argText)) {
            return sha;
        }

        MessageDigest shaDigest = getShaDigest(argAlgorithm);

        if (shaDigest != null) {
            byte[] textBytes = argText.getBytes();
            shaDigest.update(textBytes, 0, argText.length());
            byte[] shahash = shaDigest.digest();
            return bytes2Hex(shahash);
        }

        return null;
    }

    /**
     * Gets the default {@link MessageDigest} to use.
     * Select {@link Algorithm#SHA256} in {@link //com.github.rzrasel.And-Library-Core#setPasscode(String)}
     * but can be {@link Algorithm#SHA1} for older versions.
     *
     * @param argAlgorithm The {@link Algorithm} to use
     */
    private static MessageDigest getShaDigest(Algorithm argAlgorithm) {
        switch (argAlgorithm) {
            case SHA256:
                try {
                    return MessageDigest.getInstance("SHA-256");
                } catch (Exception e) {
                    try {
                        return MessageDigest.getInstance("SHA-1");
                    } catch (Exception e2) {
                        return null;
                    }
                }
            case SHA1:
            default:
                try {
                    return MessageDigest.getInstance("SHA-1");
                } catch (Exception e2) {
                    return null;
                }
        }
    }

    private String generateSalt(String argDefPasswordSalt, int argKeyLength) {
        byte[] salt = new byte[argKeyLength];
        try {
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
            sr.setSeed(System.currentTimeMillis());
            sr.nextBytes(salt);
            return Arrays.toString(salt);
        } catch (Exception e) {
            salt = argDefPasswordSalt.getBytes();
        }
        return Base64.encodeToString(salt, Base64.DEFAULT);
    }

}
/*
private static final int KEY_LENGTH = 256;
private static final String DEFAULT_PASSWORD_SALT = "7xn7@c$";
setPassCode(String passcode) {
    String salt = getSalt();
    SharedPreferences.Editor editor = mSharedPreferences.edit();

    if (passcode == null) {
        editor.remove(PASSWORD_PREFERENCE_KEY);
        editor.apply();
        this.disable();
    } else {
        passcode = salt + passcode + salt;
        setAlgorithm(Algorithm.SHA256);
        passcode = Encryptor.getSHA(passcode, Algorithm.SHA256);
        editor.putString(PASSWORD_PREFERENCE_KEY, passcode);
        editor.apply();
        this.enable();
    }

    return true;
}
*/
