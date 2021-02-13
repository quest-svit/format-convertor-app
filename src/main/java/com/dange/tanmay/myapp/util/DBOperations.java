package com.dange.tanmay.myapp.util;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class DBOperations {
	public static final String HOST = "localhost";
	public static final int PORT = 27017;
	public static final String DATABASE_NAME = "myappdb";
	public static final String COLLECTION_NAME = "product";
	private static MongoClient mongo ;

	public static MongoCollection<Document> getCollection() {
		return getDatabase().getCollection(COLLECTION_NAME);
	}

	private static MongoDatabase getDatabase() {
		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
				fromProviders(PojoCodecProvider.builder().automatic(true).build()));

		return new MongoClient(HOST, PORT).getDatabase(DATABASE_NAME).withCodecRegistry(pojoCodecRegistry);
	}

	@SuppressWarnings("deprecation")
	public  static void closeDatabase() {
		mongo.close();
	}


}
