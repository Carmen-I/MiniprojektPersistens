package model;

public class BusinessCustomer extends Customer {

	private int businessNo;
	

	public BusinessCustomer(String name, String address, int zipCode, String city, int phoneNo) {
		super(name, address, zipCode, city, phoneNo);
		
	}
	
	public int getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(int businessNo) {
		this.businessNo = businessNo;
	}

}
