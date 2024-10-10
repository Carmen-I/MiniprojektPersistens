package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Product {
	private int productId;
	private String barcode;
	private String name;
	private List<Location> locations;

	public Product(int productId, String barcode, String name) {
		this.productId = productId;
		this.barcode = barcode;
		this.name = name;
		this.locations = new ArrayList<Location>();

	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAllCurrentStock() {
		int stock = 0;
		for (Location l : locations) {
			stock = +l.getCurrentStock();
		}
		return stock;
	}

	public int getStockInLocation(int locationId) {
		return locations.get(locationId - 1).getCurrentStock();
	}

}
