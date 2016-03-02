
package connections;

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

import databaseMethods.Collection;

import java.util.*;

public class ConnectionNoSQL {
	
@SuppressWarnings("resource")
	public DB accessDatabaseNoSQL () {
		
// Connect to MongoDB server
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		System.out.println ("Connected to database successfully");
		
// Connect to database
@SuppressWarnings ("deprecation")
		DB database = mongoClient.getDB ("Garden");
		return database;
	}

	public static void main (String args[]) {
		
		ConnectionNoSQL connection = new ConnectionNoSQL ();
		DB database = connection.accessDatabaseNoSQL ();
	}
	
}



//boolean auth = database.authenticate(username, password.toCharArray());
//System.out.println("Authentication: "+auth);

//DBCollection collection = database.getCollection (collectionString);



/*			@SuppressWarnings("deprecation")
List<String> databases = mongoClient.getDatabaseNames();

for (String databaseReturned : databases) {
	System.out.println (databaseReturned);
}
*/				




/*		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
DB database 	= mongoClient.getDatabase("Garden");

@SuppressWarnings("deprecation")

System.out.println("Connect to database successfully");
boolean auth = db.authenticate(username, password);
System.out.println("Authentication: "+auth);
DBCollection table = database.getCollection("user");
} */






//String username = "SYSTEM";
//String password = "Bonsai20";
/*Return connection names
Set <String> table = database.getCollectionNames ();
		
for (String collections : table) {
	
	System.out.println(collections);
	
}

*/






