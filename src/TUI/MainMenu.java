package TUI;

import Controller.SaleOrderController;

public class MainMenu {
	private static SaleOrderMenu saleOrderMenu = new SaleOrderMenu();

	public static void main(String[] args) {
		runMainMenu();
	}
	
	public static void runMainMenu() {
		boolean running = true;
		while(running) {
			int choice = writeMainMenu();
			switch(choice) {
			case 1: {
				saleOrderMenu.start();
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
	
	private static int writeMainMenu() {
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
}
