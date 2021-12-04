package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;

public class P100ArrangedProbability {

	public static void main(String[] args) {
		long x = 1, y = 1, z = 1;

		while (x < Math.pow(10, 12) * 2) {
			z = 3 * x + 4 * y;
			y = 2 * x + 3 * y;
			x = z;
		}
		System.out.println((y + 1) / 2);

		printDuration();
	}
}
