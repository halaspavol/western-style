package DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Models.Product;

public class ProductDB implements ProductDBIF {
	public Product findProduct(String barcode) throws SQLException {
		Product res = null;
		String sql = "select * from table_students where barcode = " + barcode;
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
		Product b = null;
		//b = new SaleOrder(rs.getLong("id"), rs.getDate("createDate"), rs.getInt("discount"), rs.getFloat("amount"), rs.getBoolean("deliveryStatus"), rs.getBoolean("deliveryStatus"), rs.getLong("invoiceId"), rs.getLong("customerId"));
		return null;
	}
}
