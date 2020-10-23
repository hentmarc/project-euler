package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.DigitUtils.isPandigital;
import static eu.hem.euler.project.util.PrimeUtils.isPrime;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;

public class P41PandigitalPrime {

	public static void main(String[] args) {
		System.out.println(maxPandigitalPrime());
		printDuration();
	}

	public static int maxPandigitalPrime() {
		for (int i = 7654321; i > 1234; i -= 6) {
			if (isPandigital(i) && isPrime(i)) {
				return i;
			}
			if (isPandigital(i - 2) && isPrime(i - 2)) {
				return i - 2;
			}
		}
		return 0;
	}
}
