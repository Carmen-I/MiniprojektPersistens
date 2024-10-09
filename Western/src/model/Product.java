package model;

public abstract class Product {
	private int productId;
	private String barcode;
	private String name;
	

public Product (int productId, String barcode, String name) {
		this.productId = productId;
		this.barcode = barcode;
		this.name = name;

	
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
}
