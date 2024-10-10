package control;

import java.sql.SQLException;

import db.CustomerDB;
import db.CustomerDBIF;
import db.DataAccessException;
import model.Customer;

public class CustomerController {
	
	private CustomerDBIF customerDB;
	
	public CustomerController() throws DataAccessException, SQLException{
		customerDB=new CustomerDB();
	}
	
	public Customer findCustomerByPhoneNo(String phoneNo) throws DataAccessException {
		
		return customerDB.findCustomerByPhoneNo(phoneNo);
	}
	
	public void createCustomer() {
		
	}

}
