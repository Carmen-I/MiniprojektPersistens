package src.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Location;
import model.Product;

public class LocationDB {
	private static final String findLocationByProductIdQ = "SELECT * FROM LOCATION WHERE Product_id = ?";
	private PreparedStatement findLocationByProductIdStatement;

	public LocationDB() throws SQLException, DataAccessException {
		dbConnection = DBConnection.getInstance();
		findLocationByProductIdStatement = dbConnection.getConnection().prepareStatement(findLocationByProductIdQ);
	}

	public List<Location> findAllLocationsOfProduct(Product product) {
		int productId = product.getProductId();
		List<Location> locations = new ArrayList<Location>();
		try {
			findLocationByProductIdStatement.setInt(1, productId);
			ResultSet rs = findLocationByProductIdStatement.executeQuery();
			if (rs.next()) {
				locations = buildObject(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("blah", e);
		}

		return locations;
	}

	private Location buildObject(ResultSet rs) throws DataAccessException {
		Location l = null;
		try {
			int locationId = rs.getInt("Location_id");
			int currentStock = rs.getInt("Current_stock");
			int minStock = rs.getInt("Min_stock");
			int maxStock = rs.getInt("Max_stock");
			l = new Location(locationId, currentStock, minStock, maxStock);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("blah", e);
		}

		return l;

	}

	private List<Location> buildObjects(ResultSet rs) throws DataAccessException {
		List<Location> locations = new ArrayList<>();
		Location l = null;
		try {
			do {
				l = buildObject(rs);
				locations.add(l);

			} while (rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("blah", e);
		}

		return locations;
	}

}
