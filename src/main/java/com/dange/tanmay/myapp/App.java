package com.dange.tanmay.myapp;

import com.dange.tanmay.myapp.util.Utils;
import com.mongodb.client.MongoCollection;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App
{
	public static final String FILE = "/home/tanmay/eclipse-workspace/myapp/input_files/product2.xml";

	public static void main( String[] args )
	{
		try {
			StringBuffer sb = Utils.readFile(FILE);
			Utils.save(XML.toJSONObject(sb.toString()));
		} catch (JSONException je) {
			System.out.println(je.toString());
		}
	}




}
