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
	private Invoice invoice;
	private Customer customer;

	public SaleOrder(long id, ArrayList<SaleOrderLine> saleOrderLines, LocalDate createDate, float amount,
			boolean deliveryStatus, LocalDate deliveryDate, Invoice invoice, Customer customer) {
		this.id = id;
		this.saleOrderLines = saleOrderLines;
		this.createDate = createDate;
		this.amount = amount;
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
		this.invoice = invoice;
		this.customer = customer;
	}

	public SaleOrder(ArrayList<SaleOrderLine> saleOrderLines, LocalDate createDate, float amount, boolean deliveryStatus,
			LocalDate deliveryDate, Invoice invoice, Customer customer) {
		this.saleOrderLines = saleOrderLines;
		this.createDate = createDate;
		this.amount = amount;
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
		this.invoice = invoice;
		this.customer = customer;
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

	public Invoice getinvoice() {
		return invoice;
	}

	public void setinvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Customer getcustomer() {
		return customer;
	}

	public void setcustomer(Customer customer) {
		this.customer = customer;
	}

}