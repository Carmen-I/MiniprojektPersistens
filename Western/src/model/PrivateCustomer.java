package model;

public class PrivateCustomer extends Customer {

	private int customerNo;
	
	public int getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}

	public PrivateCustomer(String name, String address, int zipCode, String city, int phoneNo) {
		super(name, address, zipCode, city, phoneNo);
		
	}

}
