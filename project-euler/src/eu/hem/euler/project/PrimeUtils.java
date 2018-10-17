package eu.hem.euler.project;

import static java.lang.Math.sqrt;

public class PrimeUtils {

	public static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}

		if (n < 4) {
			return true;
		}

		if (n % 2 == 0 || n % 3 == 0) {
			return false;
		}

		if (n < 8) {
			return true;
		}

		for (int i = 5; i <= sqrt(n); i += 6) {
			if (n % i == 0 || n % (i + 2) == 0) {
				return false;
			}
		}

		return true;
	}
}
