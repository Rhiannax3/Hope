package connections;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public class Test {

	private static String url = "jdbc:oracle:thin:@localhost:1521/xe" ;
	private static String user = "SYSTEM" ;
	private static String password = "password" ;
	private static Statement statement = null ;
	

	
	public static void main (String args[]) {
		
		ConnectionSQL connect = new ConnectionSQL ();
		Connection connection = connect.openConnection(url, user, password);
		connect.closeConnection(statement, connection);
	}

}
