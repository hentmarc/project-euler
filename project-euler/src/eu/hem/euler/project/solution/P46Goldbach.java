package eu.hem.euler.project.problem;

import static eu.hem.euler.project.util.PrimeUtils.*;
import static eu.hem.euler.project.util.ProcessUtils.*;

public class P46Goldbach {

	public static void main(String[] args) {
		for (int i = 9; i < 1_000_000; i += 2) {
			if (!isPrime(i) && !isGoldbach(i)) {
				System.out.println(i + " is the smallest odd composite that cannot be written as the sum of a prime and twice a square");
				printDuration();
				return;
			}
		}
	}

	public static boolean isGoldbach(int n) {
		if (n < 9) {
			return false;
		}
		if (n % 2 == 0) {
			return false;
		}
		if (isPrime(n)) {
			return false;
		}
		
		for (int i = 1; 2 * i * i + 1 < n; i++) {
			if (isPrime(n - 2 * i * i)) {
				return true;
			}
		}
		return false;
	}
}
