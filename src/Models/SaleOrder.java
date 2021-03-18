package Models;

import java.time.LocalDate;
import java.util.ArrayList;

public class SaleOrder {

	private long id;
	private LocalDate createDate;
	private ArrayList<SaleOrderLine> saleOrderLines;
	private float amount;
	private boolean deliveryStatus;
	private LocalDate deliveryDate;
	private long invoiceId;
	private long customerId;
	
	public SaleOrder(long id, ArrayList<SaleOrderLine> saleOrderLines, LocalDate createDate, float amount, boolean deliveryStatus, LocalDate deliveryDate, long invoiceId, long customerId) {
		this.id = id;
		this.saleOrderLines = saleOrderLines;
		this.createDate = createDate;
		this.amount = amount;
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
		this.invoiceId = invoiceId;
		this.customerId = customerId;
	}

	public SaleOrder(ArrayList<SaleOrderLine> saleOrderLines, LocalDate createDate, float amount, boolean deliveryStatus, LocalDate deliveryDate, long invoiceId, long customerId) {
		this.saleOrderLines = saleOrderLines;
		this.createDate = createDate;
		this.amount = amount;
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
		this.invoiceId = invoiceId;
		this.customerId = customerId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public ArrayList<SaleOrderLine> getSaleOrderLines() {
		return saleOrderLines;
	}

	public void setSaleOrderLines(ArrayList<SaleOrderLine> saleOrderLines) {
		this.saleOrderLines = saleOrderLines;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
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

	public long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	

}