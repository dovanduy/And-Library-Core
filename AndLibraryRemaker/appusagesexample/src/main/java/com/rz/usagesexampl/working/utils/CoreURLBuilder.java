package com.rz.usagesexampl.working.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

class CoreURLBuilder {
    private TreeMap<String, String> urlRequestParameters;
    private static String methodName = "methodName-var";

    CoreURLBuilder() {
        methodName = "CoreURLBuilder()";
        urlRequestParameters = new TreeMap<>();
        urlRequestParameters.clear();
    }

    protected CoreURLBuilder withParameter(String argParamKey, String argParamValue) {
        methodName = "CoreURLBuilder withParameter(String argParamKey, String argParamValue)";
        urlRequestParameters.put(argParamKey, argParamValue);
        return this;
    }

    protected String getURLParameter() throws UnsupportedEncodingException {
        methodName = "String getURLParameter()";
        if (urlRequestParameters == null) {
            return null;
        }
        if (urlRequestParameters.size() <= 0) {
            return null;
        }
        HashMap<String, String> urlParameters = new HashMap<>();
        for (Map.Entry<String, String> entry : urlRequestParameters.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            urlParameters.put(key, value);
        }
        return onPrepareParameter(urlParameters, false);
    }

    protected String getURLParameter(boolean argIsRemoveEmpty) throws UnsupportedEncodingException {
        methodName = "String getURLParameter(boolean argIsRemoveEmpty)";
        if (urlRequestParameters == null) {
            return null;
        }
        if (urlRequestParameters.size() <= 0) {
            return null;
        }
        HashMap<String, String> urlParameters = new HashMap<>();
        urlParameters.putAll(urlRequestParameters);
        return onPrepareParameter(urlParameters, argIsRemoveEmpty);
    }

    protected static String getURLParameter(HashMap<String, String> argURLRequestParameters) throws UnsupportedEncodingException {
        methodName = "String getURLParameter(HashMap<String, String> argURLRequestParameters)";
        if (argURLRequestParameters != null) {
            return onPrepareParameter(argURLRequestParameters, false);
        }
        return null;
    }

    protected static String getURLParameter(HashMap<String, String> argURLRequestParameters, boolean argIsRemoveEmpty) throws UnsupportedEncodingException {
        methodName = "String getURLParameter(HashMap<String, String> argURLRequestParameters, boolean argIsRemoveEmpty)";
        if (argURLRequestParameters != null) {
            return onPrepareParameter(argURLRequestParameters, argIsRemoveEmpty);
        }
        return null;
    }

    protected static String onPrepareParameter(HashMap<String, ?> argHashMap, boolean argIsRemoveEmpty) throws UnsupportedEncodingException {
        methodName = "String onPrepareParameter(HashMap<String, ?> argHashMap, boolean argIsRemoveEmpty)";
        final String DEFAULT_ENCODING = "UTF-8";
        if (argHashMap != null) {
            SortedMap<String, ?> sortedMap = new TreeMap<>(argHashMap);
            StringBuilder stringBuilder = new StringBuilder();
            Iterator<? extends Map.Entry<String, ?>> iterator = sortedMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, ?> entry = iterator.next();
                String key = entry.getKey();
                if (!isNullOrEmpty(key)) {
                    Object value = entry.getValue();
                    if (argIsRemoveEmpty && !isNullOrEmpty(value + "")) {
                        stringBuilder.append(URLEncoder.encode(key, DEFAULT_ENCODING));
                        stringBuilder.append("=");
                        String valueAsString = value != null ? URLEncoder.encode(value.toString(), DEFAULT_ENCODING) : "";
                        stringBuilder.append(valueAsString);
                        if (iterator.hasNext()) {
                            stringBuilder.append('&');
                        }
                    } else if (!argIsRemoveEmpty) {
                        stringBuilder.append(URLEncoder.encode(key, DEFAULT_ENCODING));
                        stringBuilder.append("=");
                        String valueAsString = value != null ? URLEncoder.encode(value.toString(), DEFAULT_ENCODING) : "";
                        stringBuilder.append(valueAsString);
                        if (iterator.hasNext()) {
                            stringBuilder.append('&');
                        }
                    }
                }
            }
            String retVal = stringBuilder.toString();
            /*if (!isNullOrEmpty(retVal)) {
                if (retVal.length() > 0 && retVal.charAt(retVal.length() - 1) == '&') {
                    retVal = retVal.substring(0, retVal.length() - 1);
                }
                if (retVal.endsWith("&")) {
                    retVal = retVal.substring(0, retVal.length() - 1);
                }
            }*/
            if (retVal.endsWith("&")) {
                retVal = retVal.substring(0, retVal.length() - 1);
            }
            return retVal;
        }
        /*HashMap<String, String> mapItems = new HashMap<>();
        mapItems.put("str_01", "String01");
        mapItems.put("str_06", "String06");
        mapItems.put("str_03", "String03");
        mapItems.put("str_04", "");
        mapItems.put("", "String05");
        mapItems.put("str_02", "String02");
        mapItems.put("str_02", "String02d");
        try {
            System.out.println("URL_PARAM_STRING: " + Utils.getURLParameter(mapItems));
            System.out.println("URL_PARAM_STRING: " + Utils.getURLParameter(mapItems, true));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
        return null;
        //https://www.geeksforgeeks.org/sortedmap-java-examples/
    }

    protected static boolean isURLAlive(String argURL) throws MalformedURLException, IOException {
        methodName = "boolean isURLAlive(String argURL)";
        try {
            URL url = new URL(argURL);
            HttpURLConnection.setFollowRedirects(false);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("HEAD");
            httpURLConnection.setConnectTimeout(30 * 1000);
            httpURLConnection.setReadTimeout(30 * 1000);
            //conn.setInstanceFollowRedirects(false);
            //conn.connect();
            System.out.println("RESPONSE_CODE: " + httpURLConnection.getResponseCode() + "");
            if (httpURLConnection.getResponseCode() == 200 || httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                //System.out.println("Server exists");
                return true;
            }
        } catch (MalformedURLException ex) {
            //Logger.getLogger(JDBCMain.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println("Server not exists MalformedURLException");
            throw ex;
        } catch (IOException ex) {
            //Logger.getLogger(JDBCMain.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println("Server not exists IOException");
            throw ex;
        }
        return false;
    }

    private static boolean isNullOrEmpty(String argValue) {
        methodName = "boolean isNullOrEmpty(String argValue)";
        if (argValue == null) {
            return true;
        }
        argValue = argValue.replaceAll("\\s+", "");
        if (argValue.trim().isEmpty()) {
            return true;
        }
        if (argValue.equalsIgnoreCase("null")) {
            return true;
        }
        return false;
    }
}
