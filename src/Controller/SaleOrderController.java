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
			e.printStackTrace();
			throw e;
		}
	}
	
	public Customer getCustomerByEmail(String email) {
		return this.customerController.getCustomerByEmail(email);
	}
	
	public Product getProduct(long barcode) {
		return this.getProduct(barcode);
	}
}
