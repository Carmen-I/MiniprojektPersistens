package db;

import db.DataAccessException;
import model.Customer;

public interface CustomerDBIF {
	
	void createCustomer(Customer customer);
	Customer findCustomerByCustomerNumber(String customerNo) throws DataAccessException;

}
