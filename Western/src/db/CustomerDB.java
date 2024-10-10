package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import model.Customer;

public class CustomerDB implements CustomerDBIF {


	private static final String findCustomerByPhoneNoQ = "SELECT c.Customer_id, c.Name,c.Cvr, c.Phone, cl.Zip_code, cl.Street, cl.Country FROM CUSTOMER JOIN CUSTOMER_LOCATION cl ON c.Customer_id = cl.Customer_id WHERE c.Phone = ?";
	private static final String insertCustomerQ = "INSERT INTO CUSTOMER VALUES (Customer_id,Name,Cvr,Phone) VALUES (?,?,?,?)";
	private static final String insertCustomerLocationQ="INSERT INTO CUSTOMER_LOCATION(Zip_code,Street,Country,Customer_id) VALUES (?,?,?,?)";
	private PreparedStatement findCustomerByPhoneNo;
	private PreparedStatement addNewCustomer;
	private Connection con;
	
	public CustomerDB()throws SQLException,DataAccessException{
		con=DBConnection.getInstance().getConnection();
		findCustomerByPhoneNo=con.prepareStatement(findCustomerByPhoneNoQ,Statement.RETURN_GENERATED_KEYS);
		addNewCustomer=con.prepareStatement(insertCustomerQ, Statement.RETURN_GENERATED_KEYS);
	}
	
	@Override
	public Customer findCustomerByPhoneNo(String phoneNo) throws DataAccessException {
		Customer c=null;
		try {
			findCustomerByPhoneNo.setString(1, phoneNo);
			ResultSet rs=findCustomerByPhoneNo.executeQuery();
			if(rs.next()) {
			c=buildObject(rs);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("blah",e);
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
				c=new BusinessCustomer(customerId,name,street,zipCode,country,phoneNo,cvr);
			}else if("PRIVATE".equalsIgnoreCase(customerType));
                    	c=new PrivateCustomer(customerId,name,street,zipCode,country,phoneNo);
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("blah",e);
		}

	
	private List<Customer> buildObjects(ResultSet rs){
		
		return null;
	}
	
}
