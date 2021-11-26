package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;

public class P097LargeNonMersannePrime {

	public static final long MAX = 10_000_000_000L;

	public static void main(String[] args) {

		long n = 28433;
		for (int i = 0; i < 7830457; i++) {
			n *= 2;
			n = n < MAX ? n : n - MAX;
		}
		n += 1;
		
		System.out.println(n);

		printDuration();
	}

}
