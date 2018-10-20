package eu.hem.euler.project.problem;

import static eu.hem.euler.project.PrimeUtils.divisors;

public class P12TriangularNumber {

	public static void main(String[] args) {
		for (long n = 1, t = 1; t < Long.MAX_VALUE; n++, t += n) {
			int d = divisors(t);
			if (d > 500) {
				System.out.println("d(" + t + ")=" + d);
				break;
			}
		}
	}

}
