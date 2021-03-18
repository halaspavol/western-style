package DB;

import java.sql.SQLException;

import Models.Customer;

public interface CustomerDBIF {
	Customer findByEmail(String email) throws SQLException;
}
