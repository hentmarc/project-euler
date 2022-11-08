package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import static java.lang.Math.min;
import static java.lang.Math.sqrt;

public class P086CuboidRoute {

	public static void main(String[] args) {
		int count = 0;
		int m = 0;

		while (count < 1_000_000) {
			m++;
			for (int n = 1; n <= 2 * m; n++) {
				int kk = m * m + n * n;
				int k = (int) sqrt(kk);
				if (k * k == kk) {
					count += min(m, n - 1) - (n - n / 2) + 1;
				}
			}
		}
		System.out.println(m);
		printDuration();
	}

}
