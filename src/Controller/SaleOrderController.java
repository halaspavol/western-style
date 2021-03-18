package Controller;

import java.sql.SQLException;
import java.time.LocalDate;

import DB.DBConnection;
import DB.SaleOrderDB;
import Models.Customer;
import Models.Product;
import Models.SaleOrder;

public class SaleOrderController {
	private SaleOrderDB saleOrderDB;
	private ProductController productController;
	private CustomerController customerController;
	
	public SaleOrderController() {
		saleOrderDB = new SaleOrderDB();
	}
	
	public void createOrder(SaleOrder saleOrder) throws SQLException {
		try {
			this.saleOrderDB.create(saleOrder);
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public Customer getCustomerByEmail(String email) throws SQLException {
		try {
			return this.customerController.getCustomerByEmail(email);
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public Product getProduct(long barcode) throws SQLException {		
		try {
			return this.productController.getProduct(barcode);
		} catch (SQLException e) {
			throw e;
		}
	}
}
