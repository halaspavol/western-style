package Models;

import java.time.LocalDate;

public class Price {
	private long id;
	private long productId;
	private float price;
	private LocalDate startDate;
	private PriceType type;
	
	public Price(long id, long productId, float price, LocalDate startDate, PriceType type) {
		this.id = id;
		this.productId = productId;
		this.price = price;
		this.startDate = startDate;
		this.type = type;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public PriceType getType() {
		return type;
	}
	public void setType(PriceType type) {
		this.type = type;
	}	
}
