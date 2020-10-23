package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;

public class P97LargeNonMersannePrime {

	public static final long MAX = (long) Math.pow(10, 10);

	public static void main(String[] args) {

		long n = 28433;
		for (int i = 0; i < 7830457; i++) {
			n = cut(n * 2);
		}
		n++;
		System.out.println(n);

		printDuration();
	}

	public static long cut(long value) {
		return value < MAX ? value : value - MAX;
	}

}
