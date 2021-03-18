package DB;

import java.sql.SQLException;

import Models.Product;

public interface ProductDBIF {
	Product findProduct(long barcode) throws SQLException;
}
