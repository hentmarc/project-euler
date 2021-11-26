package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.PrimeUtils.gcd;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;
import static java.lang.Math.sqrt;
import static java.util.Arrays.stream;

public class P075SingularIntegerRightTriangles {

	public static void main(String[] args) {
		int max = 1_500_000;
		int[] lengths = new int[max / 2 + 1];

		for (int m = 2; m < sqrt(max / 2); m++) {
			for (int n = 1; n < m; n++) {
				if ((m + n) % 2 == 1 && gcd(m, n) == 1) {
					for (int k = 1; k * m * (m + n) <= max / 2; k++) {
						lengths[k * m * (m + n)]++;
					}
				}
			}
		}

		System.out.println(stream(lengths).filter(c -> c == 1).count());
		printDuration();
	}
}
