package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.PrimeUtils.divisors;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;

public class P012TriangularNumber {

	public static void main(String[] args) {
		for (int n = 1, t = 1; t < Long.MAX_VALUE; n++, t += n) {
			int d = divisors(t);
			if (d > 500) {
				System.out.println("d(" + t + ")=" + d);
				break;
			}
		}
		printDuration();
	}

}
