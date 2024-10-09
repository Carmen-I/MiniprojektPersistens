package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.Order;
import model.Product;

public class ProductDB implements ProductDBIF {
	private static final String findProductByBarcodeQ = "SELECT * FROM PRODUCT WHERE Barcode = ?";
	private static final String checkUpdateQ = "";
	private static final String findProductTypeByProductIdQ = "SELECT Product_id, 'CLOTHING' AS tableName from CLOTHING where Product_id = ? "
			+ "UNION SELECT Product_id, 'EQUIPMENT' AS tableName FROM EQUIPMENT WHERE Product_id = ? UNION SELECT Product_id, 'GUN_REPLICA' AS tableName from GUN_REPLICA WHERE Product_id = ?";
	
	private PreparedStatement findProductByBarcodeStatement;
	private PreparedStatement checkUpdate;
	private PreparedStatement findProductTypeByProductIdStatement;
	private DBConnection dbConnection;
	
	public ProductDB() throws SQLException, DataAccessException {
		dbConnection = DBConnection.getInstance();
		findProductByBarcodeStatement = dbConnection.getConnection().prepareStatement(findProductByBarcodeQ, Statement.RETURN_GENERATED_KEYS);
		findProductTypeByProductIdStatement = dbConnection.getConnection().prepareStatement(findProductTypeByProductIdQ, Statement.RETURN_GENERATED_KEYS);
	}

	@Override
	public Product findProductByBarcode(String barcode) {
		
		Product p = null;
		try {
			findProductByBarcodeStatement.setString(1, barcode);
			ResultSet rs = findProductByBarcodeStatement.executeQuery();
			if (rs.next()) {
				p = buildObject(rs, retrieveAssociation);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("Something wrong with finding invoice", e);
		}

		return p;
	}
	


private Product buildObject(ResultSet rs, boolean retrieveAssociation) throws DataAccessException {
	Product product = null;
	
	try {
		int productId = rs.getInt(1);
		ResultSet rs = findProductTypeByProductIdStatement.executeQuery();		

		
		
		product = new Product   (Id,   rs.getString(2), rs.getDate(3).toLocalDate(), rs.getString(4));
		if (retrieveAssociation) {
			product.setOrderlines(orderLineDB.findAllOrderLine(orderId));
		}
	} catch (SQLException e) {
		throw new DataAccessException("Cannot convert from ResultSet", e);
	}
	return product;
}

}