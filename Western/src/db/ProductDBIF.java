package db;

import model.Product;

public interface ProductDBIF {
	
	Product findProductByBarcode(String barcode);
	void checkStock(int quantity,Product product);

}
