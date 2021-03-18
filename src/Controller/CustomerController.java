package Controller;

import java.sql.SQLException;
import DB.CustomerDB;
import Models.Customer;

public class CustomerController {
	private CustomerDB customerDB = new CustomerDB();
	
	public Customer getCustomerByEmail(String email) throws SQLException {
		try {
			Customer customer = this.customerDB.findByEmail(email);
			return customer;
		} 
		catch (SQLException e) {
			e.printStackTrace(); 
			throw e;
		}
	}
}
