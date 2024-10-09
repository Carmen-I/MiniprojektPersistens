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
	
	public Customer findCustomerByCustomerNumber(String customerNo) throws DataAccessException {
		
		return customerDB.findCustomerByCustomerNumber(customerNo);
	}
	
	public void createCustomer() {
		
	}

}
