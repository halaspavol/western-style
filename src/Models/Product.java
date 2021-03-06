package Models;

import java.util.ArrayList;

public class Product {
	private long id;
	private String name;
	private ArrayList<Price> prices;
	private String countryOfOrigin;
	private int minStock;
	private Supplier supplier;
	private String barcode;
	
	public Product(long id, String name, ArrayList<Price> prices, String countryOfOrigin, int minStock, Supplier supplier,
			String barcode) {
		this.id = id;
		this.name = name;
		this.prices = prices;
		this.countryOfOrigin = countryOfOrigin;
		this.minStock = minStock;
		this.supplier = supplier;
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
	
	public ArrayList<Price> getPrices() {
		return prices;
	}
	public void setPrices(ArrayList<Price> prices) {
		this.prices = prices;
	}
	
	public int getMinStock() {
		return minStock;
	}
	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}
	
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
}
