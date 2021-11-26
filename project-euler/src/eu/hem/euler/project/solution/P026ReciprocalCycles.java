package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.PrimeUtils.isPrime;
import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.valueOf;

import java.math.RoundingMode;

public class P026ReciprocalCycles {

	public static void main(String[] args) {

		int max = 0;
		int n = 0;
		for (int i = 7; i < 1000; i += 2) {

			if (isPrime(i)) {
				String s = ONE.divide(valueOf(i), 1000, RoundingMode.HALF_EVEN).movePointRight(1000).toString();
				String sub = s.substring(0, 10);
				int next = s.indexOf(sub, 10);
				if (next > max) {
					max = next;
					n = i;
				}
			}
		}
		System.out.println("1/" + n + " cycle length = " + max);
	}

}
