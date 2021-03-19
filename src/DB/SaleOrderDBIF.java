package DB;

import java.sql.SQLException;

import Models.SaleOrder;

public interface SaleOrderDBIF {
	SaleOrder create(SaleOrder saleOrder) throws SQLException;
}
