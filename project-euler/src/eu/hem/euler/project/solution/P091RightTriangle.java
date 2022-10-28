package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;
import static java.lang.Math.min;

import eu.hem.euler.project.fraction.Fraction;

public class P091RightTriangle {

	public static void main(String[] args) {
		final int n = 50;
		long count = 3 * n * n;

		for (int x = 1; x <= n; x++) {
			for (int y = 1; y <= x; y++) {
				Fraction f = new Fraction(y, x);
				long leftCount = min(x / f.n, (n - y) / f.d);
				long rightCount = min((n - x) / f.n, y / f.d);
				count += (leftCount + rightCount) * (x > y ? 2 : 1);
			}
		}
		System.out.println(count);
		printDuration();
	}
}
