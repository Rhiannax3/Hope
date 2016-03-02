package connections;

import java.sql.Connection;

public class ConnectionManager {

	public Connection openConnection (String url, String user, String password) {
		ConnectionSQL connect = new ConnectionSQL ();
		Connection connection = connect.openConnection(url, user, password);
		return connection;
	}
	
}
