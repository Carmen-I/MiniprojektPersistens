package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DBConnection;
import model.BusinessCustomer;
import model.Customer;
import model.PrivateCustomer;

public class CustomerDB implements CustomerDBIF {

	private static final String findCustomerByCustomerNoQ = "SELECT*FROM CUSTOMER WHERE Customer_no=?";
	private static final String insertCustomerQ = "";
	private PreparedStatement findCustomerByNo;
	private PreparedStatement addNewCustomer;
	private Connection con;
	
	public CustomerDB()throws SQLException,DataAccessException{
		con=DBConnection.getInstance().getConnection();
		findCustomerByNo=con.prepareStatement(findCustomerByCustomerNoQ,Statement.RETURN_GENERATED_KEYS);
		addNewCustomer=con.prepareStatement(insertCustomerQ, Statement.RETURN_GENERATED_KEYS);
	}
	
	@Override
	public Customer findCustomerByCustomerNumber(String customerNo) throws DataAccessException {
		Customer c=null;
		try {
			findCustomerByNo.setString(1, customerNo);
			ResultSet rs=findCustomerByNo.executeQuery();
			if(rs.next()) {
			c=buildObject(rs);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("blah",e);
		}
		
		return c;//DET DUER IKKE, VI SKAL bruge id´ en eller noget med database  scripts
	}
	
	
	@Override
	public void createCustomer(Customer customer) {
		
	}
	
	private Customer buildObject(ResultSet rs) throws DataAccessException {
		Customer c=null;
		try {
			int customerId=rs.getInt("Customer_id");
			String name=rs.getString("Name");
			String street=rs.getString("Street");
			String zipCode=rs.getString("Zip_code");//inconsistency in database ,some zip_code is as type int and some is as varchar
			String country=rs.getString("Country");
			String phoneNo=rs.getString("Phone");
			String customerType=rs.getString("Customer_type");
			if("BUSINESS".equalsIgnoreCase(customerType)) {
				String cvr=rs.getString("Cvr");
				c=new BusinessCustomer(customerId,name,street,zipCode,country,phoneNo,customerType,cvr);
			}else if("PRIVATE".equalsIgnoreCase(customerType));
                    	String customerNo=rs.getString("Customer_no");	//review database and add customerNo	
                    	c=new PrivateCustomer(customerId,name,street,zipCode,country,phoneNo,customerType,customerNo);
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("blah",e);
		}
		
		
		return c;
		
	}
	
	private List<Customer> buildObjects(ResultSet rs) throws DataAccessException{
		List<Customer> customers=new ArrayList<>();
		Customer c=null;
		try {
			do 
			{  c=buildObject(rs);
			  customers.add(c);
				
			}while(rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("blah",e);
		}
		
		return  customers;
	}

	
	
}
