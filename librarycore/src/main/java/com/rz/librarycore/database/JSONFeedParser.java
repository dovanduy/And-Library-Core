package com.rz.librarycore.database;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JSONFeedParser {
    public static Map<String, Object> JSONFeedObject(String argJsonObject) throws JSONException {
        return new JSONFeedParser().toMap(new JSONObject(argJsonObject));
    }

    public static List<Object> JSONFeedArray(String argJsonArray) throws JSONException {
        return new JSONFeedParser().toList(new JSONArray(argJsonArray));
    }

    private Map<String, Object> toMap(JSONObject argJsonObject) throws JSONException {
        Map<String, Object> map = new HashMap<String, Object>();

        Iterator<String> keysIterator = argJsonObject.keys();
        while (keysIterator.hasNext()) {
            String key = keysIterator.next();
            Object value = argJsonObject.get(key);

            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            map.put(key, value);
        }
        return map;
    }

    private List<Object> toList(JSONArray argJsonArray) throws JSONException {
        List<Object> list = new ArrayList<Object>();
        for (int i = 0; i < argJsonArray.length(); i++) {
            Object value = argJsonArray.get(i);
            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            list.add(value);
        }
        return list;
    }
}
//https://www.programcreek.com/java-api-examples/?class=org.json.JSONObject&method=keys
//https://www.quora.com/How-do-I-convert-JSONObject-to-HashMap-in-Java
//https://stackoverflow.com/questions/1066589/iterate-through-a-hashmap
//https://tympanus.net/codrops/2013/04/17/slide-and-push-menus/
//https://codepen.io/marclloyd77/pen/gtypB
//https://www.cssscript.com/tag/push-menu/
//http://responsive-nav.com/
//https://aatul.me/tag/passing-array-between-activities-in-android-using-intent-and-bundle/
//https://aatul.me/tag/passing-array-between-activities-in-android-using-intent-and-bundle/
//https://medium.com/the-wtf-files/the-mysterious-case-of-the-bundle-and-the-map-7b15279a794e

//https://beginnersbook.com/2013/12/how-to-loop-hashmap-in-java/
//