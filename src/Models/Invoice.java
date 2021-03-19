package Models;

import java.time.LocalDate;

public class Invoice {
	private long id;
	private LocalDate paymentDate;
	private float amount;
	private int invoiceNo;
	
	public Invoice(long id, LocalDate paymentDate, int amount, int invoiceNo) {
		this.id = id;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}
	
	public Invoice(LocalDate paymentDate, float amount) {
		this.paymentDate = paymentDate;
		this.amount = amount;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public int getInvoiceNo() {
		return Integer.parseInt(new String(LocalDate.now().toString().substring(0, 4)) + String.valueOf(this.id));
	}
	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
}
