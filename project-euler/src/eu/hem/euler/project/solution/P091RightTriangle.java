package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import eu.hem.euler.project.fraction.Fraction;

public class P091RightTriangle {

	public static void main(String[] args) {
		final int n = 50;

		// 0,0; x,0; 0,y
		int count = 3 * n * n;

		for (int x = 1; x <= n; x++) {
			for (int y = 1; y <= x; y++) {
				Fraction f = new Fraction(y, x);

				for (int i = x - f.n, j = y + f.d; i >= 0 && j <= n; i -= f.n, j += f.d) {
					count += x > y ? 2 : 1;
				}
				for (int i = x + f.n, j = y - f.d; i <= n && j >= 0; i += f.n, j -= f.d) {
					count += x > y ? 2 : 1;
				}
			}
		}
		System.out.println(count);
		printDuration();
	}
}
