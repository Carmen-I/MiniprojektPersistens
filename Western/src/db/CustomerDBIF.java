package db;

import db.DataAccessException;
import model.Customer;

public interface CustomerDBIF {
	
	void createCustomer(Customer customer);
	Customer findCustomerByPhoneNo(String phoneNo) throws DataAccessException;

}
