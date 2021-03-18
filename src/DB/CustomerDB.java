package DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Models.Customer;

public class CustomerDB implements CustomerDBIF {
	public Customer findByEmail(String email) throws SQLException {
		Customer res = null;
		String sql = "select * from table_students where email = " + email;
		System.out.println("StudentDb, Query: " + sql);
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
	
	private Customer buildObject(ResultSet rs) throws SQLException {
		Customer b = null;
		//b = new SaleOrder(rs.getLong("id"), rs.getDate("createDate"), rs.getInt("discount"), rs.getFloat("amount"), rs.getBoolean("deliveryStatus"), rs.getBoolean("deliveryStatus"), rs.getLong("invoiceId"), rs.getLong("customerId"));
		return null;
	}
}
