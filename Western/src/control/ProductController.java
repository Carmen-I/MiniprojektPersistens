package control;

import db.ProductDB;
import model.Product;

public class ProductController {
	
	public Product findProductByBarcode(String barcode, boolean retrieveAssociation ) {
		
		ProductDB productdb = new ProductDB();
		return productdb.findProductByBarcode(barcode);
		
	}

}
