package DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Models.Price;
import Models.Product;
import Models.Supplier;

public class ProductDB implements ProductDBIF {

	public Product findProduct(long barcode) throws SQLException {
		Product res = null;
		String sqlProduct = "select * from Product where barcode = " + barcode;
		
		try(Statement s = DBConnection.getInstance().getConnection().createStatement()) {
			ResultSet rsProduct = s.executeQuery(sqlProduct);
			
			if(rsProduct.next()) {
				res = buildProduct(rsProduct);
				
				String sqlSupplier = "select * from Supplier where id = " + rsProduct.getLong("supplier_id");
				ResultSet rsSupplier = s.executeQuery(sqlProduct);
				
				if(rsSupplier.next()) {
					res.setSupplier(buildSupplier(rsSupplier));
					
					//address
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return res;				
	}
	
	private Product buildProduct(ResultSet rs) throws SQLException {
		return new Product(rs.getLong("id"), rs.getString("product_name"), new ArrayList<Price>(), rs.getString("country_of_origin"), rs.getInt("min_stock"), null, rs.getLong("barcode"));
	}
	
	private Supplier buildSupplier(ResultSet rs) throws SQLException {
		return null;
		//return new Supplier(rs.getLong("id"), rs.getString("cvr"), rs.getObject("supplier_name"), null,rs.getString("phone_no"), rs.getInt("email"));
	}
}
