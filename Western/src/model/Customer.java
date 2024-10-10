package model;

public abstract class Customer {

	private int customerId;
	private String name;
	private String street;
	private String zipCode;
	private String country;
	private String phoneNo;
	
	
	public Customer(int customerId,String name,String address,String zipCode, String country,String phoneNo) {
		this.customerId=customerId;
		this.name=name;
		this.street=street;
		this.zipCode=zipCode;
		this.country=country;
		this.phoneNo=phoneNo;
		
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	
}
