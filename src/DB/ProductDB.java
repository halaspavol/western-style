package DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import Models.Price;
import Models.PriceType;
import Models.Product;
import Models.Supplier;

public class ProductDB implements ProductDBIF {

	public Product findProduct(long barcode) throws SQLException {
		Product res = null;
		String sqlProduct = "select * from Product where barcode = " + barcode;
		
		try(Statement s = DBConnection.getInstance().getConnection().createStatement()) {
			ResultSet rsProduct = s.executeQuery(sqlProduct);
			
			if(rsProduct.next()) {
				res = buildProduct(rsProduct);
				
				
				String sqlPrices = "(SELECT TOP 1 * FROM Price WHERE product_id =" + res.getBarcode() + " AND price_type = 'PURCHASE') UNION ( SELECT TOP 1 * FROM Price WHERE product_id = " + res.getBarcode() + " AND price_type = 'SELL') UNION ( SELECT TOP 1 * FROM Price WHERE product_id = " + res.getBarcode() + " AND price_type = 'RENT') ORDER BY start_date DESC";
				ResultSet rsPrices = s.executeQuery(sqlPrices);
				if(rsPrices.next()) {
					res.setPrices(buildPrices(rsPrices));		
				}
				
				
				String sqlSupplier = "select * from Supplier where id = " + rsProduct.getLong("supplier_id");
				ResultSet rsSupplier = s.executeQuery(sqlProduct);
				
				if(rsSupplier.next()) {
					res.setSupplier(buildSupplier(rsSupplier));					
					//get address
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return res;				
	}
	
	private Product buildProduct(ResultSet rs) throws SQLException {
		return new Product(rs.getLong("id"), rs.getString("product_name"), new ArrayList<Price>(), rs.getString("country_of_origin"), rs.getInt("min_stock"), null, rs.getLong("barcode"));
	}
	
	private Supplier buildSupplier(ResultSet rs) throws SQLException {
		return new Supplier(rs.getLong("id"), rs.getLong("cvr"), rs.getString("supplier_name"), null,rs.getInt("phone_no"), rs.getString("email")); //TODO: get address
	}
	
	private ArrayList<Price> buildPrices(ResultSet rs) throws SQLException {
		ArrayList<Price> res = new ArrayList<>();
		while(rs.next()) {
			Price b = buildPrice(rs);
			res.add(b);
		}
		return res;
	}
	
	private Price buildPrice(ResultSet rs) throws SQLException {
		int year = Integer.parseInt(rs.getString("startDate").substring(0,4));
		int month = Integer.parseInt(rs.getString("startDate").substring(5,7));
		int day = Integer.parseInt(rs.getString("startDate").substring(8,10));
		LocalDate startDate = LocalDate.of(year, month, day);	
		
		return new Price(rs.getLong("id"), rs.getLong("product_id"), rs.getFloat("price"), startDate, PriceType.valueOf(rs.getString("type"))); //TODO: get address
	}
}
