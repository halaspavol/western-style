package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	private Connection connection = null; // the connection to the database
	private static DBConnection dbConnection; //unique instance of the class
	
	//information about the connection to the database
	private static final String dbName = "dmaj0920_1086315";
	private static final String serverName = "hildur.ucn.dk";
	private static final String instanceName = "SQLEXPRESS17";
	private static final String portNumber = "1433";

	// constructor - private because of singleton pattern
	private DBConnection() {
		String urlString = String.format("jdbc:sqlserver://%s\\%s:%s;databaseName=%s", 
				serverName, instanceName, portNumber, dbName) ;
	
		String userName = getUserName();
		String password = getPassword();
		
		try {
			connection = DriverManager.getConnection(urlString, userName,  password);
		} catch (SQLException e) {
			System.err.println("Could not connect to database ");
			System.out.println("URl string was: " + urlString);
			e.printStackTrace();
		}

	}
		
	public static DBConnection getInstance() {
		if(dbConnection == null) {
			dbConnection = new DBConnection();
		}
		return dbConnection;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void disconnect() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public int executeUpdate(String sql) throws SQLException {
		System.out.println("DBConnection, Updating: " + sql);
		int res = -1;
		try (Statement s = connection.createStatement()){
			res = s.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return res;
	}
	
	
	private String getUserName() {
		//here we should read from a configuration file or ...
		return "dmaj0920_1086315";
	}
	
	private String getPassword() {
		//here we should read from a configuration file or ...
		return "Password1!";
	}
}

