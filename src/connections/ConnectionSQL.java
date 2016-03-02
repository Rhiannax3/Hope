
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

import java.util.*;
import java.io.Closeable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;

public class ConnectionSQL {
	
	private static String url = "jdbc:oracle:thin:@localhost:1521/xe";
	private static String user = "SYSTEM";
	private static String password = "password";
	
	public Connection openConnection(String url, String user, String password) {
		
		Connection connection = null;
		
		try {
			OracleDataSource dataSource = new OracleDataSource();
			dataSource.setURL(url) ;
			connection = dataSource.getConnection(user, password);
			System.out.println("Connected! Yay!");
			
		} catch (SQLException exceptionSQL) {
			exceptionSQL.printStackTrace();
		} return connection;
	}
	
	public void closeConnection (Statement statement, Connection connection) {
		
		if (statement != null)
			try {
				statement.close () ;
			} catch (SQLException exceptionSQL) {
				exceptionSQL.printStackTrace() ;
			}
		
		if (connection != null) {
			try {
				connection.close() ;
				System.out.println("Disconnected! Yay!");
			} catch (SQLException exceptionSQL) {
				exceptionSQL.printStackTrace() ;
			}
		}
	}
	
	public <E> ResultSet selectEntity(E anyObject, String url, String user, String password) {
		ResultSet resultSet   = null;
		Connection connection = null;
		Statement statement   = null;
		
		try {
			connection = openConnection(url, user, password);
			statement  = connection.createStatement (ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultSet  = statement.executeQuery("SELECT * FROM " + anyObject.getClass().getName().toLowerCase().substring(
					anyObject.getClass().getName().lastIndexOf('.') + 1) + " entity");
			
		} catch (SQLException exceptionSQL) {
			exceptionSQL.printStackTrace();
		} finally {
			closeConnection (statement, connection);
		} return resultSet;
	}

	public static void main (String args[]) {
		ConnectionSQL main = new ConnectionSQL ();
		ResultSet resultSet = main.selectEntity(new Address(), url, user, password);
		
	}
}



// 	private String url = "jdbc:oracle:thin:@localhost:1521/xe" ;

