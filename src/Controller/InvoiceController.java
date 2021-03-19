package Controller;

import java.sql.SQLException;
import DB.InvoiceDB;
import Models.Invoice;

public class InvoiceController {
	private InvoiceDB invoiceDB = new InvoiceDB();
		
	public Invoice createInvoice(Invoice invoice) throws SQLException{
		try {
			 return this.invoiceDB.create(invoice);
		} catch (SQLException e) {
			throw e;
		}
	}
}
