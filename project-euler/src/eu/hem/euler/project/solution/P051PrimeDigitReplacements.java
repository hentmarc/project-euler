package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.DigitUtils.digits;
import static eu.hem.euler.project.util.DigitUtils.parseInt;
import static eu.hem.euler.project.util.PrimeUtils.isPrime;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.util.ArrayList;
import java.util.List;

public class P051PrimeDigitReplacements {

	public static void main(String[] args) {

		for (int n = 101; n < 1000; n += 2) {
			for (int i = 0; i < 3; i++) {
				for (int j = i + 1; j < 4; j++) {
					for (int k = j + 1; k < 5; k++) {
						List<Integer> primes = new ArrayList<>();
						for (int l = i == 0 ? 1 : 0; l < 10; l++) {
							List<Integer> digits = digits(n);
							digits.add(i, l);
							digits.add(j, l);
							digits.add(k, l);
							int p = parseInt(digits);
							if (isPrime(p)) {
								primes.add(p);
							}
						}
						if (primes.size() > 7) {
							System.out.println(primes);
							printDuration();
							return;
						}
					}
				}
			}
		}
	}
}
