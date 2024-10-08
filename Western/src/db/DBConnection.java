package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBConnection {

	private Connection connection = null; // the connection to the database
	private static DBConnection dBConnection = new DBConnection(); // unique instance of the class

	// The values of the constants should be read from a configuration file, etc.
	// You need to change the constants to the connection properties of your DB
	private static final String DBNAME = "";
	private static final String SERVERNAME = "";
	private static final String PORTNUMBER = "";
	private static final String USERNAME = "";
	private static final String PASSWORD = "";

	// constructor - private because of singleton pattern
	private DBConnection() {
		String urlString = String.format("jdbc:sqlserver://%s:%s;databaseName=%s;encrypt=false", SERVERNAME, PORTNUMBER,
				DBNAME);
		try {
			connection = DriverManager.getConnection(urlString, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static DBConnection getInstance() {
		if (dBConnection == null) {
			dBConnection = new DBConnection();
		}
		return dBConnection;
	}

	public Connection getConnection() {
		return connection;
	}
	
	public int executeInsertWithIdentity(PreparedStatement ps) throws DataAccessException {
		// requires prepared statement to be created with the additional argument PreparedStatement.RETURN_GENERATED_KEYS  
		int key = -1;
		try {
			int res = ps.executeUpdate();
			if (res > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				rs.next();
				key = rs.getInt(1);
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not execute insert", e);
		}
		return key;
		
	}    


}
