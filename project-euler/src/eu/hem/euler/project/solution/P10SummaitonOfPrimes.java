package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.PrimeUtils.isPrime;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;
import static java.util.stream.IntStream.range;

public class P10SummaitonOfPrimes {

	public static void main(String[] args) {
		System.out.println(range(1, 2_000_000).filter(n -> isPrime(n)).mapToLong(n -> n).sum());
		printDuration();
	}

}
