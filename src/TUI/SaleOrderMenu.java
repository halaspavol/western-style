package TUI;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import Controller.SaleOrderController;
import Models.Customer;
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
		System.out.println("(2) Find Order");
		System.out.println("(3) Edit Order");
		System.out.println("(4) Delete Order");
		
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
			int choice = writeSaleOrderMenu();
			switch(choice) {
			
			}
		}
	}
	
	private void createOrder() {
		System.out.println("Email:");
		String email = Reader.getStringFromUser();
		Customer customer = this.controller.getCustomerByEmail(email);
		
		//Deliver date	
		LocalDate deliveryDate = LocalDate.of(LocalDate.now().getDayOfMonth(), LocalDate.now().getMonthValue(), LocalDate.now().getYear()).plusDays(15);
		System.out.println("Deliver date: " + deliveryDate);
		
		//Deliver status		
		boolean deliveryStatus = false;
		System.out.println("Deliver status: " + deliveryStatus);
		
		//CreateDate
		LocalDate createDate = LocalDate.now();
		System.out.println("Create date: " + createDate);
		
		SaleOrder saleOrder = new SaleOrder(new ArrayList<SaleOrderLine>(), createDate, 0, deliveryStatus, deliveryDate, 0, customer.getId());
		
		boolean running = true;
		while(running) {
			Product product = this.controller.getProduct(0);
			
			System.out.println("Quantity:");
			int qty = Reader.getIntFromUser();
			
			SaleOrderLine saleOrderLine = new SaleOrderLine(0, product, qty);
			saleOrder.getSaleOrderLines().add(saleOrderLine);
			
			System.out.println("Would you like to add one more?");
			System.out.println("0 - No, Any other number - Yes, add more products");
			int choice = Reader.getIntFromUser();
			if(choice == 0) {
				running = false;
			}
		}
		
		try {
			this.controller.createOrder(saleOrder);
		} catch (SQLException e) {
			System.out.println(e);
		}		
	}

}
