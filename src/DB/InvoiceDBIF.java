package DB;

import java.sql.SQLException;

import Models.Invoice;
import Models.SaleOrder;

public interface InvoiceDBIF {
	Invoice create(Invoice invoice, SaleOrder saleOrder) throws SQLException;
}
