package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.PrimeUtils.isPrime;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;

public class P058SpiralPrimes {

	public static void main(String[] args) {

		int primes = 0;

		for (int side = 1;; side += 2) {
			primes += isPrime(side * side + side + 1) ? 1 : 0;
			primes += isPrime(side * side + 2 * side + 2) ? 1 : 0;
			primes += isPrime(side * side + 3 * side + 3) ? 1 : 0;

			if (primes * 10 < 2 * side - 1) {
				System.out.format("side length=%d%n", side);
				printDuration();
				return;
			}
		}

	}

}
