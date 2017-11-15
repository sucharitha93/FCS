import java.util.Scanner;

/**
 * 
 */

/**
 * @author SucharithaReddy
 *
 */
public class PredatorPreyDriver {

	/**
	 * @param args
	 *
	 *
	 */
	private static Scanner input;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PredatorPrey predator = new PredatorPrey();
		PredatorPrey prey = new PredatorPrey();

		// input = new Scanner(System.in);
		// System.out.println("PREDATOR PREY DYNAMICS");
		// System.out.println("Enter time increment per step: ");
		// int stepIncr = input.nextInt();
		// System.out.println("Prey's nourishing rate: ");
		// prey.setAutoTropicRate(input.nextDouble());
		// System.out.println("Prey's death rate: ");
		// prey.setDeathRate(input.nextDouble());
		// System.out.println("Maximum prey population: ");
		// prey.setMaxPopulation(input.nextDouble());
		// System.out.println("Initial prey population: ");
		// prey.setPopulation(input.nextDouble());
		//
		// System.out.println("Predator's consumption rate / prey: ");
		// predator.setHeteroTropicRate(input.nextDouble());
		// System.out.println("Predator's maximum useful prey: ");
		// predator.setMaxPrey(input.nextDouble());
		// System.out.println("Predator's death rate: ");
		// predator.setDeathRate(input.nextDouble());
		// System.out.println("initial predator population: ");
		// predator.setPopulation(input.nextDouble());
		// System.out.println("predation efficiency (< 1.0): ");
		// double predationEfficiency = input.nextDouble();
		// System.out.println("total simulation time: ");
		// double t=input.nextDouble();

		System.out.println("Enter time increment per step: ");
		int stepIncr = 1;
		System.out.println("Prey's nourishing rate: ");
		prey.setAutoTropicRate(0.5);
		System.out.println("Prey's death rate: ");
		prey.setDeathRate(0.1);
		System.out.println("Maximum prey population: ");
		prey.setMaxPopulation(1000);
		System.out.println("Initial prey population: ");
		prey.setPopulation(500);
		System.out.println("Predator's consumption rate / prey: ");
		predator.setHeteroTropicRate(0.005);
		System.out.println("Predator's maximum useful prey: ");
		predator.setMaxPrey(100);
		System.out.println("Predator's death rate: ");
		predator.setDeathRate(0.4);
		System.out.println("initial predator population: ");
		predator.setPopulation(60);
		System.out.println("predation efficiency (< 1.0): ");
		double predationEfficiency = 0.2;
		System.out.println("total simulation time: ");
		double t = 30;

		double loss, totalTime = 0;
		while (totalTime < t) {
			loss = predator.take(stepIncr, prey.getPopulation()) / predationEfficiency;
			prey.lose(loss);
			prey.accept(stepIncr);
			predator.die(stepIncr);
			prey.die(stepIncr);
			predator.doIt();
			prey.doIt();
			System.out.println(totalTime + " prey population = " + prey.getPopulation() + ", predator population = "
					+ predator.getPopulation());
			totalTime += stepIncr;

		}

	}

}
