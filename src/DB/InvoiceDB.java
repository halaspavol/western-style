package DB;

import java.sql.SQLException;
import Models.Invoice;

public class InvoiceDB implements InvoiceDBIF {

	public Invoice create(Invoice invoice) throws SQLException {
		//String sql = String.format("insert into table_students (id, name) values ('%s', '%s')", saleOrder.getId(), saleOrder.getName());
		String sql = "";
		int id = DBConnection.getInstance().executeUpdate(sql);
		invoice.setId(id);
		return invoice;
	}
}
