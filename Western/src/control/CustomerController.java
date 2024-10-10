package control;

import db.CustomerDBIF;
import model.Customer;

public class CustomerController {
	
	private CustomerDBIF customerDB;
	

	public CustomerController() throws DataAccessException, SQLException{
		customerDB=new CustomerDB();
	}
	
	public Customer findCustomerByPhoneNo(String phoneNo) throws DataAccessException {
		
		return customerDB.findCustomerByPhoneNo(phoneNo);

	
	public void createCustomer() {
		
	}

}
