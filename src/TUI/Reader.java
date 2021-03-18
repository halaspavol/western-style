package TUI;
import java.util.Scanner; 

public class Reader {
	private static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Gets int from user
	 * @return int
	 */
	public static Integer getIntFromUser() {
		scanner = new Scanner(System.in);
		while(!scanner.hasNextInt()) {
			System.out.println("Input must be a number. Try it again!");
			scanner.nextLine();
		}
		
		String value = scanner.nextLine();
		Integer intValue = null;
		try {
			 intValue = Integer.parseInt(value);
		} catch (Exception e) {
			//nothing
		}
		return intValue;
		
	}
	
	/**
	 * Gets float from user
	 * @return float
	 */
	public static float getFloatFromUser() {
		while(!scanner.hasNextFloat()) {
			System.out.println("Input must be a number. Try it again!");
			scanner.nextLine();
		}
		
		String value = scanner.nextLine(); 
		return Float.parseFloat(value);
	}
	
	/**
	 * Gets long from user
	 * @return long
	 */
	public static long getLongFromUser() {
		while(!scanner.hasNextLong()) {
			System.out.println("Input must be a number. Try it again!");
			scanner.nextLine();
		}
		
		String value = scanner.nextLine(); 
		return Long.parseLong(value);
	}
	
	/**
	 * Gets string from user
	 * @return string
	 */
	public static String getStringFromUser() {		
		return scanner.nextLine(); 
	}
}
