package TUI;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;

import Controller.SaleOrderController;
import Models.Customer;
import Models.Invoice;
import Models.Price;
import Models.PriceType;
import Models.Product;
import Models.SaleOrder;
import Models.SaleOrderLine;

public class SaleOrderMenu {
	private SaleOrderController controller;
	
	public SaleOrderMenu() {
		controller = new SaleOrderController();
	}
	
	public void start() {
		saleOrderMenu();
	}
	
	private int writeSaleOrderMenu() {
		System.out.println("****Sales Menu****");
		System.out.println("(1) Create Order");
		System.out.println("(2) Find Order //not implemented");
		System.out.println("(3) Edit Order //not implemented");
		System.out.println("(4) Delete Order //not implemented");
		
		Integer choice = null;
		while(choice == null) {
			choice = Reader.getIntFromUser();
			if(choice == null) {
				System.out.println("Sorry Input Can Not Be Empty. Please Try Again");
			}
		}
		
		return choice;
	}
	
	private void saleOrderMenu() {
		boolean running = true;
		while(running) {
			int key = writeSaleOrderMenu();
			switch (key) {
				case 1: {
					this.createOrder();
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + key);
			}
		}
	}
	
	private void createOrder() {		
		try {
			System.out.println("Email:");
			String email = Reader.getStringFromUser();
			Customer customer;
			customer = this.controller.getCustomerByEmail(email);
			
			//Deliver date	
			LocalDate deliveryDate = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth()).plusDays(15);
			System.out.println("Deliver date: " + deliveryDate);
			
			//Deliver status		
			boolean deliveryStatus = false;
			System.out.println("Deliver status: " + deliveryStatus);
			
			//CreateDate
			LocalDate createDate = LocalDate.now();
			System.out.println("Create date: " + createDate);
			
			SaleOrder saleOrder = new SaleOrder(new ArrayList<SaleOrderLine>(), createDate, 0, deliveryStatus, deliveryDate, null, customer);
			
			System.out.println("Add products:");
			boolean running = true;
			while(running) {
				Product product;
				try {
					System.out.println("Barcode:");
					String barcode = Reader.getStringFromUser();
					product = this.controller.getProduct(barcode);
					
					System.out.println("Quantity:");
					int qty = Reader.getIntFromUser();
					
					Optional<Price> productPrice = product.getPrices().stream().filter(price -> price.getType() == PriceType.SELL).findFirst();
					if(productPrice.isPresent()) {
						SaleOrderLine saleOrderLine = new SaleOrderLine(product, qty);
						saleOrder.getSaleOrderLines().add(saleOrderLine);
						saleOrder.setAmount(saleOrder.getAmount() + productPrice.get().getPrice() * qty);
					}
					else {
						System.out.println("Err: Can't calculate price. Product wasn't added to order");
					}				
					
				} catch (SQLException e) {
					System.out.println(e);
				}						
				
				System.out.println("Would you like to add one more?");
				System.out.println("0 - No, Any other number - Yes, add more products");
				int choice = Reader.getIntFromUser();
				if(choice == 0) {
					running = false;
				}
			}
			
			try {
				saleOrder = this.controller.createOrder(saleOrder);
				Invoice invoice = new Invoice(
						LocalDate.of(LocalDate.now().getDayOfMonth(), LocalDate.now().getMonthValue(), LocalDate.now().getYear()).plusDays(5), 
						this.controller.calculatePrice(customer, saleOrder.getAmount()));
				invoice = this.controller.createInvoice(invoice, saleOrder);
			} catch (SQLException e) {
				System.out.println(e);
			}	
		} catch (SQLException e) {
			System.out.println(e);
		}			
	}

}
