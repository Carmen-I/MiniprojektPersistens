package model;

public class BusinessCustomer extends Customer {

	private int cvr;
	


	public BusinessCustomer(int customerId, String name, String street, String zipCode, String country, String phoneNo,int cvr) {
		super(customerId, name, street, zipCode,country, phoneNo);
		this.cvr=cvr;
	}

	public int getCvr() {
		return cvr;
	}

	public void setCvr(int cvr) {
		this.cvr = cvr;
	}
	
	@Override
	public String toString() {

		return String.format("PrivateCustomer [customerId=%d, name=%s, street= %s, zipCode=%s, country=%s, phoneNo=%s, cvr=%d]", getCustomerId(), getName(), getStreet(), getZipCode(),getCountry(),getPhoneNo(),cvr);

	}

}
