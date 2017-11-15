package Periodical_1;

import java.util.ArrayList;
import java.util.Scanner;

public class HuntingtonHill {

	/*
	 * Your program HuntingtonHill.java must be organized as a library of static
	 * methods with the following API: public class HuntingtonHill • double
	 * priority(int p, int n) ---- priority of a state with population p and n
	 * seats already assigned. • int next(int[] populations, int[] seats) ----
	 * index of next state to be assigned a seat given populations and current
	 * apportionment • void main(String[] args) ---- read number of seats H as a
	 * commandline argument; read N and state names and populations from stdin;
	 * write apportionments to stdout Input and output specifications. You must
	 * read input and write output as directed below: • Command-line argument.
	 * The number of seats H to apportion. • Standard input. An integer N
	 * followed by N string–integer pairs, where each pair is the name of a
	 * state and its population. • Standard output. The integer N followed by N
	 * string–integer–integer triples, where each triple is the name of a state,
	 * its population, and its apportionment. (You need not duplicate our exact
	 * spacing.)
	 * 
	 * 
	 */

	static double priority(Double statePopulation, int n) {
		return statePopulation / (Math.sqrt(n * (n + 1)));
	}

	static int next(Double[] priority) {
		double largest = priority[0];
		int index = 0;
		for (int i = 1; i < priority.length; i++) {
			if (priority[i] > largest) {
				largest = priority[i];
				index = i;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of seats for apportion:");
		int h = in.nextInt();
		System.out.println(h);
		System.out.println("Enter the number of states:");
		int n = in.nextInt();

		String[] stateName = new String[n];
		int[] stateSeats = new int[n];
		Double[] statePopulation = new Double[n];
		Double[] priority = new Double[n];

		for (int i = 0; i < n; i++) {

			System.out.println("Name of state " + (i + 1) + ":");
			stateName[i] = in.next();
			System.out.println("Population of state " + (i + 1) + ":");
			statePopulation[i] = in.nextDouble();
			stateSeats[i] = 1;
		}
		int rt = h - n;
		int index;
		while (rt > 0) {
			// compute priority
			for (int i = 0; i < n; i++) {
				priority[i] = HuntingtonHill.priority(statePopulation[i], stateSeats[i]);
			}

			index = HuntingtonHill.next(priority);

			// assign seat
			stateSeats[index] += 1;

			rt = rt - 1;
		}
		for (int i = 0; i < n; i++) {
			System.out.println(stateName[i] + " " + statePopulation[i] + " " + stateSeats[i]);
		}

	}

}
