/**
 * 
 */

/**
 * @author SucharithaReddy
 *
 */
public class PredatorPrey {
	private double autoTropicRate = 0;
	private double heteroTropicRate = 0;
	private double maxPrey = 1.0e100;
	private double deathRate;
	private double maxPopulation = 1.0e100;
	private double population;
	private double populationChange = 0;

	public double take(double time, double prey) {
		populationChange = populationChange + time * heteroTropicRate * population * prey / (1 + prey / maxPrey);
		return populationChange;
	}

	public void lose(double loss) {
		populationChange = populationChange - loss;
	}

	public void accept(double time) {
		populationChange = populationChange + time * population * autoTropicRate * (1.0 - population / maxPopulation);
	}

	public void die(double time) {
		populationChange = populationChange - time * population * deathRate;
	}

	public void doIt() {
		this.population = this.population + this.populationChange;
		this.populationChange = 0;
	}

	public double getAutoTropicRate() {
		return autoTropicRate;
	}

	public void setAutoTropicRate(double autoTropicRate) {
		this.autoTropicRate = autoTropicRate;
	}

	public double getHeteroTropicRate() {
		return heteroTropicRate;
	}

	public void setHeteroTropicRate(double heteroTropicRate) {
		this.heteroTropicRate = heteroTropicRate;
	}

	public double getMaxPrey() {
		return maxPrey;
	}

	public void setMaxPrey(double maxPrey) {
		this.maxPrey = maxPrey;
	}

	public double getDeathRate() {
		return deathRate;
	}

	public void setDeathRate(double deathRate) {
		this.deathRate = deathRate;
	}

	public double getMaxPopulation() {
		return maxPopulation;
	}

	public void setMaxPopulation(double maxPopulation) {
		this.maxPopulation = maxPopulation;
	}

	public double getPopulation() {
		return population;
	}

	public void setPopulation(double population) {
		this.population = population;
	}

	public double getPopulationChange() {
		return populationChange;
	}

	public void setPopulationChange(double populationChange) {
		this.populationChange = populationChange;
	}

}
