package db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Product;
import model.SalesOrder;
import model.SalesOrderLine;

public class SalesOrderDB {
	private static final String updateStockQ = "UPDATE LOCATION SET Current_stock = ? WHERE Product_id = ? AND Location_id = ?";
	private PreparedStatement updateStockStatement;
	private DBConnection dbConnection;

	public SalesOrderDB() throws SQLException, DataAccessException {
		dbConnection = DBConnection.getInstance();
		updateStockStatement = dbConnection.getConnection().prepareStatement(updateStockQ);
	}

	public boolean updateStock(SalesOrder salesOrder) throws DataAccessException {
		List<SalesOrderLine> orderlines = salesOrder.getOrderlines();
		int quantitySold = 0;
		int quantityMain = 0;
		int quantityRest = 0;
		Product p = null;
		int result = -1;
		for (SalesOrderLine o : orderlines) {
			quantitySold = o.getQuantity();
			p = o.getProduct();
			quantityMain = p.getStockInLocation(1);
			quantityRest = p.getAllCurrentStock() - quantityMain;
			if (quantitySold < quantityMain) {
				try {
					updateStockStatement.setInt(1, quantityMain - quantitySold);
					updateStockStatement.setInt(3, quantityMain - quantitySold);
					result = dbConnection.executeInsertWithIdentity(updateStockStatement);
				} catch (DataAccessException e) {
					throw new DataAccessException("something happened or didn't happen", e);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	else {
				int minus = quantityMain - quantitySold;
				
			}

	}

}
