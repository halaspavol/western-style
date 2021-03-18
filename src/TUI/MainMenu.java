package TUI;

import Controller.SaleOrderController;

public class MainMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world");
	}
	
	private SaleOrderMenu salesMenu = new SaleOrderMenu();
	
	//private SaleOrderController = new SaleOrderController();

	
	public void runMainMenu() {
		boolean running = true;
		while(running) {
			int choice = writeMainMenu();
			switch(choice) {
			case 1: {
				//saleOrderMenu.start();
				break;
			}
			case 0: {
				running = false;
				break;
			}
			default: {
				System.out.println("Unknown Error With Choice" + choice);
			}
			}
		}
	}
	
	private int writeMainMenu() {
		System.out.println("**** Main Menu ****");
		System.out.println("(1) Sales Menu");
		System.out.println("(0) Quit Program");
		
		Integer choice = null;
		while(choice == null) {
			choice = Reader.getIntFromUser();
			if(choice == null) {
				System.out.println("Sorry Input Can Not Be Empty. Please Try Again");
			}
		}
		
		return choice;
	}
	
	private void generateData() {
		System.out.println();
		//TODO
	}
	
}
