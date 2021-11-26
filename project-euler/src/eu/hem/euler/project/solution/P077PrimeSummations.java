package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.PrimeUtils.nextPrime;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;

public class P077PrimeSummations {

	public static void main(String[] args) {

		int sum = 100;

		long[] ways = new long[sum + 1];
		ways[0] = 1;
		for (int p = 2; p < sum; p = nextPrime(p)) {
			for (int i = p; i <= sum; i++) {
				ways[i] += ways[i - p];
			}
		}
		for (int i = 0; i < ways.length; i++) {
			if (ways[i] > 5000) {
				System.out.println(i);
				printDuration();
				return;
			}
		}
	}

}
