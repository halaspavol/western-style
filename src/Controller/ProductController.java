package Controller;

import java.sql.SQLException;

import DB.ProductDB;
import Models.Product;

public class ProductController {
	private ProductDB productDB = new ProductDB();
	
	public Product getProduct(long barcode) throws SQLException {
		try {
			Product product = this.productDB.findProduct(barcode);
			return product;
		} 
		catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}				
	}
}
