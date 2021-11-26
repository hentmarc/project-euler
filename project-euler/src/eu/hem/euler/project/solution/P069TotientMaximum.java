package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.PrimeUtils.nextPrime;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;

public class P069TotientMaximum {

	public static void main(String[] args) {

		int n = 1;
		for (int i = 2; n * i <= 1_000_000; i = nextPrime(i)) {
			n *= i;
		}
		System.out.println(n);
		
		printDuration();
	}

}
