package DB;

import java.sql.SQLException;
import Models.Invoice;
import Models.SaleOrder;

public class InvoiceDB implements InvoiceDBIF {

	public Invoice create(Invoice invoice, SaleOrder saleOrder) throws SQLException {
		String sql = String.format("insert into Invoice (payment_date, amount, sale_order_id) values ('%s', %s, %s)", invoice.getPaymentDate(), invoice.getAmount(), saleOrder.getId());
		
		try {
			int id = DBConnection.getInstance().executeUpdate(sql);
			invoice.setId(id);			
		} catch (SQLException e) {
			throw e;
		}
		return invoice;
	}
}
