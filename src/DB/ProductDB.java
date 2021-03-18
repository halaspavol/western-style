package DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Models.Product;

public class ProductDB implements ProductDBIF {

	public Product findProduct(long barcode) throws SQLException {
		Product res = null;
		String sql = "select * from Products where barcode = " + barcode;
		System.out.println("ProductDb, Query: " + sql);
		try(Statement s = DBConnection.getInstance().getConnection().createStatement()) {
			ResultSet rs = s.executeQuery(sql);
			if(rs.next()) {
				res = buildObject(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return res;				
	}
	
	private Product buildObject(ResultSet rs) throws SQLException {
		Product p = null;
		//p = new Product(rs.getLong("id"), rs.getString("name"), rs.getObject("price"), rs.getString("countryOfOrigin"), rs.getInt("minStock"), rs.getLong("supplierId"), rs.getLong("barcode"));
		return p;
	}
}
