package control;

import model.Customer;

import model.Product;
import model.SalesOrder;

public class SalesOrderController {

	private SalesOrder salesOrder;
	
	public SalesOrderController() {
		createSaleOrder();
	}
	
	public SalesOrder createSaleOrder() {
		if(salesOrder == null) {
			this.salesOrder = new SalesOrder();
		}
		return salesOrder;
	}
	
	public Customer addCustomerToOrder(String customerNo) {
		CustomerController customerController = new CustomerController();
		Customer customer = customerController.findCustomerByCustomerNumber(customerNo);
		
		return customer;
		
	}
	
	public Product addProductToOrder(String barcode) {
		ProductController productController = new ProductController();
		Product product = productController.findProductByBarcode(barcode, false);
		
		return product;
	}
	
	public SalesOrder finishSaleOrder() {
		
		return null;
	}
}
