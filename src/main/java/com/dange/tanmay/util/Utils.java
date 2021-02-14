package com.dange.tanmay.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Utils {
    public static int PRETTY_PRINT_INDENT_FACTOR = 4;

    public static Map<String, Object> jsonToMap(JSONObject json) throws JSONException {
        return  (json != JSONObject.NULL) ? toMap(json): new HashMap<String, Object>();
    }

    public static List<Object> toList(JSONArray array) throws JSONException {
        List<Object> list = new ArrayList<Object>();
        for(int i = 0; i < array.length(); i++) {
            list.add(convert(array.get(i)));
        }
        return list;
    }

    public static Map<String, Object> toMap(JSONObject object) throws JSONException {
        Map<String, Object> map = new HashMap<String, Object>();
        Iterator<String> keysItr = object.keys();
        while(keysItr.hasNext()) {
            String key = keysItr.next();
            map.put(key,  convert(object.get(key)));
        }
        return map;
    }

    private static Object convert(Object value) throws JSONException {
        if (value instanceof JSONArray) {
           return toList((JSONArray) value);
        } else if (value instanceof JSONObject) {
            return toMap((JSONObject) value);
        }
        return value;
    }
    public static StringBuffer readFile(String filename) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filename));
        sc.useDelimiter("\\Z");// we just need to use \\Z as delimiter
        StringBuffer sb = new StringBuffer(sc.next());
        sc.close();
        return sb;
    }


    public static String prettyPrint(JSONObject xmlJSONObj) throws JSONException {
        return xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
    }



}
