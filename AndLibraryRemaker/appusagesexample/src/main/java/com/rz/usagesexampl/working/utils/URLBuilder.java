package com.rz.usagesexampl.working.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.HashMap;

public class URLBuilder {
    private CoreURLBuilder coreURLBuilder;
    private static String methodName = "methodName-var";

    public URLBuilder() {
        coreURLBuilder = new CoreURLBuilder();
    }

    public URLBuilder withParameter(String argParamKey, String argParamValue) {
        coreURLBuilder.withParameter(argParamKey, argParamValue);
        return this;
    }

    public String getURLParameter() throws UnsupportedEncodingException {
        return coreURLBuilder.getURLParameter();
    }

    public String getURLParameter(boolean argIsRemoveEmpty) throws UnsupportedEncodingException {
        return coreURLBuilder.getURLParameter(argIsRemoveEmpty);
    }

    public static String getURLParameter(HashMap<String, String> argURLRequestParameters) throws UnsupportedEncodingException {
        return CoreURLBuilder.getURLParameter(argURLRequestParameters);
    }

    public static String getURLParameter(HashMap<String, String> argURLRequestParameters, boolean argIsRemoveEmpty) throws UnsupportedEncodingException {
        return CoreURLBuilder.getURLParameter(argURLRequestParameters, argIsRemoveEmpty);
    }

    public static boolean isURLAlive(String argURL) throws MalformedURLException, IOException {
        return CoreURLBuilder.isURLAlive(argURL);
    }

    public static boolean isJson(String argJson) {
        methodName = "boolean isJson(String argJson)";
        try {
            new JSONObject(argJson);
        } catch (JSONException ex) {
            try {
                new JSONArray(argJson);
            } catch (JSONException exc) {
                return false;
            }
        }
        return true;
    }
}
