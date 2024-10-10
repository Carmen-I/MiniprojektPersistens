package model;

public class SalesOrderLine {

	private int quantity;
	private Product product;

	public SalesOrderLine(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

}
