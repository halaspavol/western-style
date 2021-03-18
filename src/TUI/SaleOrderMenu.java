package TUI;

import Controller.SaleOrderController;
import Models.Customer;
import Models.Product;

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
		Customer customer = this.controller.getCustomerByEmail("");
		//while
		Product product = this.controller.getProduct(0);
		
	}

}
