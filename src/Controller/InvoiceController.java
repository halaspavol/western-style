package Controller;

import java.sql.SQLException;
import DB.InvoiceDB;
import Models.Invoice;
import Models.SaleOrder;

public class InvoiceController {
	private InvoiceDB invoiceDB = new InvoiceDB();
		
	public Invoice createInvoice(Invoice invoice, SaleOrder saleOrder) throws SQLException{
		try {
			 return this.invoiceDB.create(invoice, saleOrder);
		} catch (SQLException e) {
			throw e;
		}
	}
}
