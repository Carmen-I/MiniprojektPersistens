package model;

public class PrivateCustomer extends Customer {

	private String customerNo;
	
	
	public PrivateCustomer(int customerId, String name, String street, String zipCode, String country, String phoneNo,String customerType,String customerNo) {
		super(customerId, name, street, zipCode,country, phoneNo, customerType);
		this.customerNo=customerNo;
	}
	
	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	
	@Override
	public String toString() {
		return String.format("PrivateCustomer [customerId=%d, name=%s, street= %s, zipCode=%s, country=%s, phoneNo=%s, customerNo=%s]", getCustomerId(), getName(), getStreet(), getZipCode(),getCountry(),getPhoneNo(),customerNo);
	}
	

}
