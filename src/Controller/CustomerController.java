package Controller;

import java.sql.SQLException;
import DB.CustomerDB;
import Models.Customer;

public class CustomerController {
	private CustomerDB customerDB = new CustomerDB();
	
	public Customer getCustomerByEmail(String email) throws SQLException {
		try {
			return this.customerDB.findByEmail(email);
		} 
		catch (SQLException e) {
			throw e;
		}
	}
}
