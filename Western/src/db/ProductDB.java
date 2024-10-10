package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Clothing;
import model.Equipment;
import model.GunReplica;
import model.Product;

public class ProductDB implements ProductDBIF {
	private static final String findProductByBarcodeQ = "SELECT * FROM PRODUCT WHERE Barcode = ?";
	private static final String findClothingByProductIdQ = "SELECT * FROM CLOTHING WHERE Product_id = ?";
	private static final String findEquipmentByProductIdQ = "SELECT * FROM EQUIPMENT WHERE Product_id = ?";
	private static final String findGunReplicaByProductIdQ = "SELECT * FROM GUN_REPLICA WHERE Product_id = ?";
	private PreparedStatement findProductByBarcodeStatement;
	private PreparedStatement findClothingByProductIdStatement;
	private PreparedStatement findEquipmentByProductIdStatement;
	private PreparedStatement findGunReplicaByProductIdStatement;
	private DBConnection dbConnection;

	public ProductDB() throws SQLException, DataAccessException {
		dbConnection = DBConnection.getInstance();
		findProductByBarcodeStatement = dbConnection.getConnection().prepareStatement(findProductByBarcodeQ);
		findClothingByProductIdStatement = dbConnection.getConnection().prepareStatement(findClothingByProductIdQ);
		findEquipmentByProductIdStatement = dbConnection.getConnection().prepareStatement(findEquipmentByProductIdQ);
		findGunReplicaByProductIdStatement = dbConnection.getConnection().prepareStatement(findGunReplicaByProductIdQ);
	}

	@Override
	public Product findProductByBarcode(String barcode) {

		Product p = null;
		try {
			findProductByBarcodeStatement.setString(1, barcode);
			ResultSet rs = findProductByBarcodeStatement.executeQuery();
			if (rs.next()) {
				p = buildObject(rs, true);
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
			String barcode = rs.getString(2);
			String name = rs.getString(3);
			String isoCode = rs.getString(4);
			int productType = rs.getInt(5);
			switch (productType) {
			case 1:
				ResultSet rs1 = findClothingByProductIdStatement.executeQuery();
				String size = rs1.getString(2);
				String color = rs1.getString(3);
				product = new Clothing(productId, barcode, name, isoCode, size, color);
				break;
			case 2:
				ResultSet rs2 = findEquipmentByProductIdStatement.executeQuery();
				String type = rs1.getString(2);
				String description = rs1.getString(3);
				product = new Equipment(productId, barcode, name, isoCode, type, description);
				break;
			case 3:
				ResultSet rs3 = findGunReplicaByProductIdStatement.executeQuery();
				String calibre = rs1.getString(2);
				String material = rs1.getString(3);
				product = new GunReplica(productId, barcode, name, isoCode, calibre, material);
				break;
			default:
				// throw some sort of exception - invalidProductType
			}

			if (retrieveAssociation) {
				setLocations(product);
			}
		} catch (SQLException e) {
			throw new DataAccessException("Cannot convert from ResultSet", e);
		}
		return product;
	}

	private void setLocations(Product product) {
		LocationDB ldb = new LocationDB();
		product.setLocations(ldb.findAllLocationsOfProduct(product));
	}

}