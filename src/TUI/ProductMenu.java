package TUI;

import Controller.ProductController;

public class ProductMenu {
	ProductController productController;
	
	public ProductMenu() {
		productController = new ProductController(); 	//creating an instance of the controller
	}
	
	public void start() {
		productMenu();
	}
	
	public void productMenu() {
		boolean running = true;
		while(running) {
			int choice = writeProductMenu();
		}
	}
	
	private int writeProductMenu() {
		Integer choice = null;
		while(choice == null){				//Once Reader is implemented, this will allow us to choose from different choices
			//choice = Reader.getIntFromUser();
			//if(choice == null){
			//	System.out.println("Input can not be empty. Try it again!");
			}
		return choice;
	}
	
}
