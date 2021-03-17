package Models;

import java.time.LocalDate;

public class SaleOrder {

	private Long id;
	private LocalDate createDate;
	private int discount;
	private float amount;
	private boolean deliveryStatus;
	private LocalDate deliveryDate;
	private Long invoiceId;
	private Long customerId;
	
	public SaleOrder(Long id, LocalDate createDate, int discount, float amount, boolean deliveryStatus, LocalDate deliveryDate, Long invoiceId, Long customerId) {
		this.id = id;
		this.createDate = createDate;
		this.discount = discount;
		this.amount = amount;
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
		this.invoiceId = invoiceId;
		this.customerId = customerId;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public boolean isDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(boolean deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	

}