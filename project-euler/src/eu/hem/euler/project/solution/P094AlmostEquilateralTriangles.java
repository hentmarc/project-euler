package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;

public class P094AlmostEquilateralTriangles {

	public static void main(String[] args) {

		long maxPerimeter = 1_000_000_000;
		long sum = 0L;

		for (long i = 3; 2 * i <= maxPerimeter / 3; i += 2) {
			for (long j = i - 1; j < i + 2; j += 2) {
				long hh = i * i - (j / 2) * (j / 2);
				long h = (long) Math.sqrt(hh);
				if (h * h == hh) {
					sum += i + i + j;
				}
			}
		}

		System.out.println(sum);
		printDuration();
	}

}
