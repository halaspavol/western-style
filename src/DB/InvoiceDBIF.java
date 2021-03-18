package DB;

import java.sql.SQLException;

import Models.Invoice;

public interface InvoiceDBIF {
	Invoice create(Invoice invoice) throws SQLException;
}
