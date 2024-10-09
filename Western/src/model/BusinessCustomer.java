package model;

public class BusinessCustomer extends Customer {

	private String cvr;//jeg har skiftet fra int til String, så det er nemmere når man skal finde en kunde baseret på code,plus vi skal have som string kundetype
	

	public BusinessCustomer(int customerId, String name, String street, String zipCode, String country, String phoneNo,String customerType,String cvr) {
		super(customerId, name, street, zipCode,country,phoneNo, customerType);
		this.cvr=cvr;
	}

	public String getCvr() {
		return cvr;
	}

	public void setCvr(String cvr) {
		this.cvr = cvr;
	}
	
	@Override
	public String toString() {
		return String.format("PrivateCustomer [customerId=%d, name=%s, street= %s, zipCode=%s, country=%s, phoneNo=%s, customerType=%s, cvr=%d]", getCustomerId(), getName(), getStreet(), getZipCode(),getCountry(),getPhoneNo(),getCustomerType(),cvr);
	}

}
