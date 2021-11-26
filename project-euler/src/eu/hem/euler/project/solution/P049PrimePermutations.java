package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.DigitUtils.digits;
import static eu.hem.euler.project.util.PrimeUtils.isPrime;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;

public class P049PrimePermutations {

	public static void main(String[] args) {

		for (int i = 1489; i < 3340; i++) {
			int j = i + 3330;
			int k = i + 6660;
			if (isPrime(i) && isPrime(j) && isPrime(k)) {
				if (digits(i).containsAll(digits(j)) && digits(i).containsAll(digits(k))) {
					System.out.println(i + "" + j + "" + k);
				}
			}
		}
		printDuration();
	}

}
