package com.rz.usagesexampl.working.jxml;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class JSONFastBuilder {
    public static Object getJSONString(Object object) throws JSONException {
        if (object instanceof HashMap) {
            JSONObject jsonObject = new JSONObject();
            HashMap map = (HashMap) object;
            for (Object key : map.keySet()) {
                jsonObject.put(key.toString(), getJSONString(map.get(key)));
            }
            return jsonObject;
        } else if (object instanceof Iterable) {
            JSONArray jsonArray = new JSONArray();
            for (Object value : ((Iterable) object)) {
                jsonArray.put(getJSONString(value));
            }
            return jsonArray;
        } else {
            return object;
        }
    }

    public static boolean isEmptyObject(JSONObject object) {
        return object.names() == null;
    }
}
//https://gist.github.com/sheharyarn/cba56ff154de2cc62fc5
/*
List<HashMap<String, Object>> listItems = new ArrayList<>();
HashMap<String, Object> mapItems = new HashMap<>();
List<String> list = new ArrayList<>();
list.add("LIST_ONE");
list.add("LIST_TWO");
list.add("LIST_THREE");
mapItems.put("str_01", "str01");
mapItems.put("list_01", list);
mapItems.put("str_02", "str02");
listItems.add(mapItems);
try {
    Object object = JSONFastBuilder.getJSONString(listItems);
    System.out.println("JSON_00000000: " + object.toString());
    object = JSONFastBuilder.getJSONString(mapItems);
    System.out.println("JSON_00000000: " + object.toString());
} catch (JSONException e) {
    e.printStackTrace();
}
*/