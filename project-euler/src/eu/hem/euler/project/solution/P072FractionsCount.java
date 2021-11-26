package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.PrimeUtils.totient;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;

public class P072FractionsCount {

	public static void main(String[] args) {

		long sum = 0;

		for (int d = 2; d <= 1_000_000; d++) {
			sum += totient(d);
		}

		System.out.println(sum); // 303963552391
		printDuration();
	}

}
