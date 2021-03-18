package Controller;

import DB.DBConnection;
import Models.Customer;
import Models.Product;

public class SaleOrderController {
	private DBConnection dbConnection;
	
	public SaleOrderController() {
		dbConnection = DBConnection.getInstance();
	}
	
	public boolean createOrder(Long id) {
		return true;
	}
	
	public Customer getCustomerByEmail(String email) {
		return null;
	}
	
	public Product getProduct(long barcode) {
		return null;
	}
}
