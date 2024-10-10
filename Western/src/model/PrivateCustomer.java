package model;

public class PrivateCustomer extends Customer {
	
	
	public PrivateCustomer(int customerId, String name, String street, String zipCode, String country, String phoneNo) {
		super(customerId, name, street, zipCode,country, phoneNo);
	}
	
	
	@Override
	public String toString() {
		return String.format("PrivateCustomer [customerId=%d, name=%s, street= %s, zipCode=%s, country=%s, phoneNo=%s]", getCustomerId(), getName(), getStreet(), getZipCode(),getCountry(),getPhoneNo());
	}
	

}
