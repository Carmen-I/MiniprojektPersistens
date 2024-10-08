package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import model.Product;

public class ProductDB implements ProductDBIF {
	private static final String findProductByBarcodeQ = "";
	private static final String checkUpdateQ = "";
	private PreparedStatement findProductByBarcode;
	private PreparedStatement checkUpdate;
	

	@Override
	public Product findProductByBarcode(String barcode) {
		
		return null;
	}

	@Override
	public void checkStock(int quantity, Product product) {
		
		
	}
	
private Product buildObject(ResultSet rs) {
		
		return null;
	}
	
	private List<Product> buildObjects(ResultSet rs){
		
		return null;
	}

}
