package TUI;

import Controller.CustomerController;

public class CustomerMenu {
private CustomerController controller;
	
	public CustomerMenu() {
		controller = new CustomerController();
	}
	
	public void start() {
		customerMenu();
	}
	
	private void customerMenu() {
		boolean running = true;
		while(running) {
			int choice = writeCustomerMenu();
			}
		}
	
	private int writeCustomerMenu() {
		System.out.println("****Customer Menu****");
		System.out.println("(1) Create Customer");
		System.out.println("(2) Find Customer By Id");
		System.out.println("(3) Edit Account");
		System.out.println("(4) Delete Account");
		System.out.println("(5) List Of All Customers");
		System.out.println("(0) Go Back");
		
		Integer choice = null;
		while(choice == null) {
			choice = Reader.getIntFromUser();
			if(choice == null) {
				System.out.println("Sorry But Input Can Not Be Empty. Please Try Again");
			}
		}
		
		return choice;
	}
	
	/*private void createCustomer(String personType) {
		String firstName = "";
		String lastName = "";
		String address = "";
		String phone = "";
		String email = "";
	}*/
	
	// Todo in the furture in case we have time.
}


