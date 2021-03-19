package DB;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import Models.Address;
import Models.Price;
import Models.PriceType;
import Models.Product;
import Models.Supplier;

public class ProductDB implements ProductDBIF {

	public Product findProduct(String barcode) throws SQLException {
		Product res = null;
		String sqlProduct = String.format("select * from Product where barcode = '%s'", barcode);
		System.out.println(sqlProduct);
		
		try(Statement s = DBConnection.getInstance().getConnection().createStatement()) {
			ResultSet rsProduct = s.executeQuery(sqlProduct);
			if(rsProduct.next()) {
				res = buildProduct(rsProduct);
				
				String sqlPrices = String.format("(SELECT TOP 1 * FROM Price WHERE product_id = '%s' AND price_type = 'PURCHASE') UNION ( SELECT TOP 1 * FROM Price WHERE product_id = '%s' AND price_type = 'SELL') UNION ( SELECT TOP 1 * FROM Price WHERE product_id = '%s' AND price_type = 'RENT') ORDER BY start_date DESC", res.getId(), res.getId(), res.getId());
				ResultSet rsPrices = s.executeQuery(sqlPrices);
				if(rsPrices.next()) {
					res.setPrices(buildPrices(rsPrices));		
				}
				
				String sqlSupplier = "select * from Supplier where id = " + rsProduct.getLong("supplier_id");
				ResultSet rsSupplier = s.executeQuery(sqlSupplier);
				
				if(rsSupplier.next()) {
					try (Statement stmt = DBConnection.getInstance().getConnection().createStatement()) {
						String addressSql = "SELECT address.id, address.street, address.house_no, address.city_id, city.city as city, city.zip as zip FROM Address as address LEFT JOIN City AS city ON city.id = Address.city_id where address.id = " + rsSupplier.getInt("address_id");
						ResultSet rsAddress = stmt.executeQuery(addressSql);
						if(rsAddress.next()) {
							Address address = buildObjectAddress(rsAddress);
							res.setSupplier(buildSupplier(rsSupplier, address));
						}
					} catch (SQLException e) {
						throw e;
					}
					//get address
				}
			}
		} catch (SQLException e) {
			throw e;
		}
		return res;				
	}
	
	private Product buildProduct(ResultSet rs) throws SQLException {
		return new Product(rs.getLong("id"), rs.getString("product_name"), new ArrayList<Price>(), rs.getString("country_of_origin"), rs.getInt("min_stock"), null, rs.getString("barcode"));
	}
	
	private Supplier buildSupplier(ResultSet rs, Address address) throws SQLException {
		return new Supplier(rs.getLong("id"), rs.getLong("cvr"), rs.getString("supplier_name"), address, rs.getInt("phone_no"), rs.getString("email"));
	}
	
	private Address buildObjectAddress(ResultSet rs) throws SQLException {
		Address address = null;
		address = new Address(rs.getLong("id"), rs.getString("street"), rs.getString("house_no"), rs.getString("zip"), rs.getString("city"));
		return address;
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
		String y = rs.getString("start_date").substring(0,4);
		int year = Integer.parseInt(y);
		int month = Integer.parseInt(rs.getString("start_date").substring(5,7));
		int day = Integer.parseInt(rs.getString("start_date").substring(8,10));

		LocalDate startDate = LocalDate.of(year, month, day);	
		
		return new Price(rs.getLong("id"), rs.getLong("product_id"), rs.getFloat("price"), startDate, PriceType.valueOf(rs.getString("type"))); //TODO: get address
	}
}
