package com.dange.tanmay.util;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class UtilsTest {

    @Test
    public void test() {
        try {
            StringBuffer sb = Utils.readFile("input_files/product2.xml");
            System.out.println(XML.toJSONObject(sb.toString()));
        } catch (JSONException je) {
            System.out.println(je.toString());
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        }
    }

    @Test
    public void test2(){
        String str = "{'employee': { 'name': 'tanmay', 'age': 44 }}";
        JSONObject json = new JSONObject(str);
        String xml = XML.toString(json);
        System.out.println(xml);


    }


}