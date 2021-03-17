package DB;

import java.sql.SQLException;

import Models.SaleOrder;

public interface SaleOrderDBIF {
	SaleOrder create(SaleOrder saleOrder) throws SQLException;
	 
	SaleOrder update(SaleOrder saleOrder) throws SQLException;
	 
	boolean delete(int id) throws SQLException;
	 
	SaleOrder findByName(String name) throws SQLException;
}
