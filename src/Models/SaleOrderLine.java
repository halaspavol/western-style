package Models;

public class SaleOrderLine {
	private long id;
	private Product product;
	private int quantity;
	
	public SaleOrderLine(long id, Product product, int quantity) {
		this.id = id;
		this.product = product;
		this.quantity = quantity;
	}
	
	public SaleOrderLine(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
