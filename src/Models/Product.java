package Models;

public class Product {
	private long id;
	private String name;
	private Price price;
	private String countryOfOrigin;
	private int minStock;
	private long supplierId;
	private long barcode;
	
	public Product(long id, String name, Price price, String countryOfOrigin, int minStock, long supplierId,
			long barcode) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.countryOfOrigin = countryOfOrigin;
		this.minStock = minStock;
		this.supplierId = supplierId;
		this.barcode = barcode;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}
	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}
	
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}
	
	public int getMinStock() {
		return minStock;
	}
	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}
	
	public long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	
	public long getBarcode() {
		return barcode;
	}
	public void setBarcode(long barcode) {
		this.barcode = barcode;
	}
}
