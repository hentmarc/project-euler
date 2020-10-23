package eu.hem.euler.project.problem;

import static eu.hem.euler.project.util.PrimeUtils.gcd;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;
import static java.lang.Math.ceil;
import static java.lang.Math.floor;

public class P73FractionsCountInRange {

	public static void main(String[] args) {

		long count = 0;

		for (int d = 2; d <= 12_000; d++) {
			for (int n = (int) floor(d / 3.0) + 1; n < (int) ceil(d / 2.0); n++) {
				if (gcd(d, n) == 1) {
					count++;
				}
			}
		}

		System.out.println(count); // 7295372
		printDuration();
	}

}
