package DB;

import java.sql.SQLException;

import Models.Product;

public interface ProductDBIF {
	Product findProduct(String barcode) throws SQLException;
}
