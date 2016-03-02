package databaseMethods;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;

import connections.ConnectionNoSQL;

import java.util.*;

import userInput.StringScanner;

public class Collection {
	
	public void getCollections (DB database) {
		Set <String> table = database.getCollectionNames ();
		for (String collections : table) {
			System.out.println(collections);
		}
	}
	
	public void createCollection(DB database, Scanner scanner) {
		System.out.println("Enter the name of your new collection: ");
		String collectionName = scanner.nextLine();
		database.createCollection(collectionName, new BasicDBObject());
	}
	
	public void addData(DB database, Scanner scanner) {
		
	}

	public static void main(String[] args) {
		ConnectionNoSQL connection = new ConnectionNoSQL ();
		Collection collection = new Collection ();
		Scanner scanner 	  = new Scanner (System.in);
		
		DB database = connection.accessDatabaseNoSQL();
		
		collection.getCollections(database);
		collection.createCollection(database, scanner);
		collection.getCollections(database);
	}

}
