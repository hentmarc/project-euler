package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.DigitUtils.digits;
import static eu.hem.euler.project.util.PrimeUtils.nextPrime;
import static eu.hem.euler.project.util.PrimeUtils.previousPrime;
import static eu.hem.euler.project.util.PrimeUtils.totient;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.util.ArrayList;
import java.util.List;

public class P70TotientPermutation {

	public static void main(String[] args) {

		int max = 10_000_000;
		int start = (int) Math.sqrt(max);
		int n = 0;
		double minRatio = max;

		List<Integer> primesHigh = new ArrayList<>();
		List<Integer> primesLow = new ArrayList<>();
		
		for (int p = nextPrime(start), q = previousPrime(start); primesHigh
				.size() < 101; p = nextPrime(p), q = previousPrime(q)) {

			primesHigh.add(p);
			primesLow.add(q);
		}

		for (int p : primesHigh) {
			for (int q : primesLow) {
				int pq = p * q;
				if (pq < max) {
					int totient = totient(pq);
					if (sameDigits(pq, totient)) {
						double ratio = (double) pq / totient;
						if (ratio < minRatio) {
							n = pq;
							minRatio = ratio;
						}
					}
				}
			}
		}

		System.out.println(n);
		printDuration();
	}

	public static boolean sameDigits(int a, int b) {
		List<Integer> digitsA = digits(a);
		digitsA.sort(null);
		List<Integer> digitsB = digits(b);
		digitsB.sort(null);
		return digitsA.equals(digitsB);
	}
}
