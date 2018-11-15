package com.rz.librarycore.converter;

import com.rz.librarycore.log.original.LogWriter;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

/**
 * Created by Rz Rasel on 2017-12-11.
 */

/**
 * String-Byte-Hex
 * Hex-Byte-String
 */
public class ConvertHexByteString {
    public static byte[] getStringToByte(String argStr) {
        byte[] byteVal = argStr.getBytes();
        return byteVal;
    }

    public static String getByteToString(byte[] argByte) {
        String strVal = "";
        try {
            strVal = new String(argByte, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return strVal;
    }

    public static String getByteToHex(byte[] argByte) {
        StringBuilder stringBuilder = new StringBuilder(argByte.length * 2);
        for (byte byteVal : argByte) {
            stringBuilder.append(String.format("%02x", byteVal));
        }
        return stringBuilder.toString();
    }

    public static byte[] getHexToByte(String argStr) {
        byte[] byteVal = new BigInteger(argStr.toString(), 16).toByteArray();
        return byteVal;
    }

    public static String getHexToString(String argStr) {
        String strVal = "";
        byte[] byteVal = new BigInteger(argStr.toString(), 16).toByteArray();
        try {
            strVal = new String(byteVal, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return strVal;
    }

    public String getHexString(String arg) {
        return String.format("%040x", new BigInteger(1, arg.getBytes(/*YOUR_CHARSET?*/)));
    }

    private void Test() {
        String value = "Hi how are you. This question answers it. Depending on whether you want to see how its done or just use a java built-in method. Here are the solutions copied from this and this answers respectively from the SO question mentioned.";
        byte[] byteVal = value.getBytes();
        String strVal = "";
        try {
            strVal = new String(byteVal, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        LogWriter.Log("BYTE: " + byteVal.toString());
        LogWriter.Log("STRING_01: " + strVal);
        /*public static String bytesToHex(byte[] bytes) {
            char[] hexChars = new char[bytes.length * 2];
            for ( int j = 0; j < bytes.length; j++ ) {
                int v = bytes[j] & 0xFF;
                hexChars[j * 2] = hexArray[v >>> 4];
                hexChars[j * 2 + 1] = hexArray[v & 0x0F];
            }
            return new String(hexChars);
        }*/
        StringBuilder sb = new StringBuilder(byteVal.length * 2);
        for (byte b : byteVal) {
            sb.append(String.format("%02x", b));
        }
        LogWriter.Log("HEX_STRING: " + sb.toString());
        byte[] newByte = new BigInteger(sb.toString(), 16).toByteArray();
        LogWriter.Log("BYTE_STRING: " + newByte.toString());
        try {
            strVal = new String(newByte, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        LogWriter.Log("STRING_02: " + strVal);
    }
}