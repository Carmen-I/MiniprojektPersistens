package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import model.Customer;

public class CustomerDB implements CustomerDBIF {

	private static final String findCustomerByCustomerNoQ = "";
	private static final String insertCustomerQ = "";
	private PreparedStatement findCustomerByNo;
	private PreparedStatement addNewCustomer;
	
	@Override
	public Customer findCustomerByCustomerNumber(String customerNo) {
		
		return null;
	}
	
	
	@Override
	public void createCustomer(Customer customer) {
		
	}
	
	private Customer buildObject(ResultSet rs) {
		
		return null;
		
	}
	
	private List<Customer> buildObjects(ResultSet rs){
		
		return null;
	}
	
}
