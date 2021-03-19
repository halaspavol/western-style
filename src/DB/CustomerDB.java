package DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Models.Address;
import Models.Customer;

public class CustomerDB implements CustomerDBIF {
	public Customer findByEmail(String email) throws SQLException {
		Customer resCustomer = null;
		String sql = "select * from Customer where email = " + email;
		
		try(Statement s = DBConnection.getInstance().getConnection().createStatement()) {
			ResultSet rs = s.executeQuery(sql);
			if(rs.next()) {				
				String addressSql = "SELECT address.id, address.street, address.house_no, address.city_id, city.city as city, city.zip as zip FROM Address as address LEFT JOIN City AS city ON city.id = Address.city_id where address.id = " + rs.getInt("address_id");
				try (Statement stmt = DBConnection.getInstance().getConnection().createStatement()) {
					ResultSet rsAddress = stmt.executeQuery(addressSql);
					Address address = buildObjectAddress(rsAddress);
					resCustomer = buildObject(rs, address);
				} catch (SQLException e) {
					e.printStackTrace();
					throw e;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return resCustomer;	
	}
	
	private Customer buildObject(ResultSet rs, Address address) throws SQLException {
		Customer customer = null;
		customer = new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"), address, rs.getString("phone_no"), rs.getString("email"), rs.getBoolean("is_legal"));
		return customer;
	}
	
	private Address buildObjectAddress(ResultSet rs) throws SQLException {
		Address address = null;
		address = new Address(rs.getLong("id"), rs.getString("street"), rs.getString("house_no"), rs.getString("zip"), rs.getString("city"));
		return address;
	}
}
