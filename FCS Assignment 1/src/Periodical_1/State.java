package Periodical_1;

public class State {

	int population;
	String name;
	double prevPriority = 0;
	double curPriority = 0;

	State(int p, String n) {
		this.population = p;
		this.name = n;
	}

}
