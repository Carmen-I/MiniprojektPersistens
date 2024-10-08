package db;

import model.Customer;

public interface CustomerDBIF {
	
	Customer findCustomerByCustomerNumber(String customerNo);
	void createCustomer(Customer customer);

}
