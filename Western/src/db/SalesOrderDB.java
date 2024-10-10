package db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalesOrderDB {
	private static final String findGunReplicaByProductIdQ = "SELECT * FROM GUN_REPLICA WHERE Product_id = ?";
	private PreparedStatement findProductByBarcodeStatement;
	private DBConnection dbConnection;

	public SalesOrderDB() throws SQLException, DataAccessException {
		dbConnection = DBConnection.getInstance();
		findProductByBarcodeStatement = dbConnection.getConnection().prepareStatement(findProductByBarcodeQ);
	}

}
