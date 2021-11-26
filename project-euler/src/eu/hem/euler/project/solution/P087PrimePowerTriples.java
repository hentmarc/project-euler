package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.PrimeUtils.primes;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class P087PrimePowerTriples {

	private static final int LIMIT = (int) Math.pow(10, 7) * 5;

	public static void main(String[] args) {
		int count = 0;
		BitSet primes = primes((int) sqrt(LIMIT));
		Set<Integer> cache = new HashSet<>();

		for (int i = primes.nextSetBit(0); pow(i, 4) < LIMIT; i = primes.nextSetBit(i + 1)) {
			for (int j = primes.nextSetBit(0); (pow(i, 4) + pow(j, 3)) < LIMIT; j = primes.nextSetBit(j + 1)) {
				for (int k = primes.nextSetBit(0); (pow(i, 4) + pow(j, 3) + pow(k, 2)) < LIMIT; k = primes.nextSetBit(k + 1)) {
					int n = (int) (pow(i, 4) + pow(j, 3) + pow(k, 2));
					if (cache.add(n)) {
						count++;
					}
				}
			}
		}

		System.out.println(count);
		printDuration();
	}

}
