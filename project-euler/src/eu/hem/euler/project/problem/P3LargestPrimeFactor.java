package eu.hem.euler.project.problem;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;

public class P3LargestPrimeFactor {

	public static void main(String[] args) {

		long l = 600851475143L;
		System.out.println(largestFactor(l));
		printDuration();
	}

	public static long largestFactor(long n) {

		int largestFactor = 1;

		for (int factor = 2; n > 1; factor++) {
			while (n % factor == 0) {
				largestFactor = factor;
				n /= factor;
			}
		}
		return largestFactor;
	}
}
