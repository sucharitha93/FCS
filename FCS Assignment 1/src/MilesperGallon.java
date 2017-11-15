import java.util.Scanner;

/**
 * 
 */

/**
 * @author SucharithaReddy
 *
 */
public class MilesperGallon {

	private static float miles = 0, gallons = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method
		Scanner input;
		String response = "y";
		input = new Scanner(System.in);

		System.out.print("Do you want to calculate miles per gallon? (y/n): ");
		response = input.next();
		while (response.equals("y")) {
			System.out.print("Enter miles: ");
			miles = miles + input.nextFloat();
			System.out.print("Enter gallons: ");
			gallons = gallons + input.nextFloat();
			System.out.print("Do you want to continue? (y/n): ");
			response = input.next();
		}
		try {
			System.out.print("Overall MPG: " + (miles / gallons));
		} catch (Exception e) {
			System.out.print("Inappropriate values entered.\n Exception " + e);
		}

	}

}
