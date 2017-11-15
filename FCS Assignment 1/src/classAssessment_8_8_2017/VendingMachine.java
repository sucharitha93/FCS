package classAssessment_8_8_2017;

import java.util.Scanner;

public class VendingMachine {

	private double paymentSum;

	public double getPaymentSum() {
		return paymentSum;
	}

	public void setPaymentSum(double paymentSum) {
		this.paymentSum = paymentSum;
	}

	public void selectItem() {
		Scanner stdIn = new Scanner(System.in);
		double price;

		// check if the balance is > 0
		if (this.paymentSum <= 0) {
			System.out.println("Sorry, you can't select, since you haven't inserted money ");
		} else {
			boolean success = false;
			do {
				// prompt user to enter the price
				System.out.println("Enter the price");
				price = stdIn.nextDouble();
				// validate for positive price and not > inserted money
				if (price > 0 && price < paymentSum) {
					// print list of coins to be returned as change

					paymentSum -= price;
					double remainder = paymentSum;
					int quarters, dimes, nickles, pennies;
					quarters = (int) (remainder / 0.25);
					remainder -= (quarters * 0.25);
					dimes = (int) (remainder / 0.1);
					remainder -= (dimes * 0.1);
					nickles = (int) (remainder / 0.05);
					remainder -= (nickles * 0.05);
					pennies = (int) (remainder / 0.01);
					// remainder -= (pennies*0.1);

					System.out.println("Change is: " + paymentSum);
					System.out.println(quarters + " quarter(s)");
					System.out.println(dimes + " dime(s)");
					System.out.println(nickles + " nickle(s)");
					System.out.println(pennies + " penny(ies)");
					success = true;
				} else {
					System.out.println("Invalid price. Must enter a positive number.");
				}

			} while (success == false);

		}
	}

	public void insertMoney() {
		Scanner stdIn = new Scanner(System.in);
		boolean inserted = false;
		do {
			// prompt to accept amount
			System.out.println("Amount of money inserted: ");
			double amount = stdIn.nextDouble();
			// validate for positive num
			if (amount > 0) {
				// add to the collected sum
				paymentSum += amount;
				inserted = true;
			} else {
				System.out.println("Invalid payment. Must enter a positive number.");
			}

		} while (inserted == false);
	}
}
