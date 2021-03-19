package Controller;

import java.sql.SQLException;
import java.time.LocalDate;

import DB.DBConnection;
import DB.SaleOrderDB;
import Models.Customer;
import Models.Invoice;
import Models.Product;
import Models.SaleOrder;

public class SaleOrderController {
	private SaleOrderDB saleOrderDB;
	private ProductController productController;
	private CustomerController customerController;
	private InvoiceController invoiceController;
	
	public SaleOrderController() {
		this.saleOrderDB = new SaleOrderDB();
		this.customerController = new CustomerController();
		this.productController = new ProductController();
		this.invoiceController = new InvoiceController();
	}
	
	public SaleOrder createOrder(SaleOrder saleOrder) throws SQLException {
		try {
			return this.saleOrderDB.create(saleOrder);
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public Invoice createInvoice(Invoice invoice, SaleOrder saleOrder) throws SQLException {
		try {
			return this.invoiceController.createInvoice(invoice, saleOrder);
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
	
	public float calculatePrice(Customer customer, float amount) {
		if(customer.isLegal() && amount >= 1500) {
			return (float)(amount - amount*0.1);
		}
		else if(!customer.isLegal() && amount >= 2500) {
			return amount - 45;
		}
		else {
			return amount;
		}
	}
}
