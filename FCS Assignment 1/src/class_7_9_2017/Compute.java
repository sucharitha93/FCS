package class_7_9_2017;

import java.util.Scanner;

public class Compute {
	static double mean(double[] x) {
		double mean = 0;
		for (int i = 0; i < x.length; i++) {
			mean = mean + x[i];
		}
		mean = mean / x.length;
		return mean;
	}

	static double variance(double[] x) {
		double nr = 0, m;
		m = mean(x);
		for (int i = 0; i < x.length; i++) {
			nr = nr + Math.pow((x[i] - m), 2);
		}
		nr = nr / (x.length - 1);
		return nr;
	}

	static double tstat(double[] x, double[] y) {
		double mx, my, vx, vy;
		mx = mean(x);
		// System.out.println("xMean"+mx);
		my = mean(y);
		// System.out.println("yMean"+my);
		vx = variance(x);
		// System.out.println("xVariance"+vx);
		vy = variance(y);
		// System.out.println("yVariance"+vy);
		return (mx - my) / (Math.sqrt((vx / x.length) + (vy / y.length)));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of samples");
		int n = in.nextInt();
		double[] x = new double[n];
		double[] y = new double[n];
		for (int i = 0; i < n; i++) {
			x[i] = in.nextDouble();
			y[i] = in.nextDouble();
		}
		System.out.println(tstat(x, y));
	}

}
