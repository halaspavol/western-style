package DB;

import java.sql.SQLException;

import Models.SaleOrder;
import Models.SaleOrderLine;

public class SaleOrderDB implements SaleOrderDBIF {
	public SaleOrder create(SaleOrder saleOrder) throws SQLException {
		String sqlSaleOrder = String.format("insert into SaleOrder (id, create_date, amount, delivery_status, delivery_date, customer_id) values ('%s', '%s', '%s', '%s', '%s', '%s')", 
				saleOrder.getId(), 
				saleOrder.getCreateDate(), 
				saleOrder.getAmount(), 
				saleOrder.getDeliveryStatus(), 
				saleOrder.getDeliveryDate(), 
				saleOrder.getcustomer().getId());
		try {
			int idSaleOrder = DBConnection.getInstance().executeUpdate(sqlSaleOrder);
			saleOrder.setId(idSaleOrder);		
		} catch (SQLException e) {
			throw e;
		}	
		
		for(SaleOrderLine sol : saleOrder.getSaleOrderLines()) {
			String sqlSaleOrderLine = String.format("insert into SaleOrderLine (product_id, sale_order_id, qty) values ('%s', '%s', '%s')", 
					sol.getProduct().getId(), 
					saleOrder.getId(), 					
					sol.getQuantity());
			try {
				int idSaleOrderLine = DBConnection.getInstance().executeUpdate(sqlSaleOrderLine);
				sol.setId(idSaleOrderLine);
			} catch (SQLException e) {
				throw e;
			}
		}
		
		return saleOrder;
	}
}
