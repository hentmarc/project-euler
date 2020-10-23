package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.PrimeUtils.coprimes;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;

public class P72FractionsCount {

	public static void main(String[] args) {

		long sum = 0;

		for (int d = 2; d <= 1_000_000; d++) {
			sum += coprimes(d);
		}

		System.out.println(sum); // 303963552391
		printDuration();
	}

}
