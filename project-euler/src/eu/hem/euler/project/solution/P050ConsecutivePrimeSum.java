package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.PrimeUtils.isPrime;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;

public class P050ConsecutivePrimeSum {

	public static void main(String[] args) {

		int limit = 1_000_000;
		int longestSequence = 1;
		int longestSequenceSum = 2;
		int longestSequenceStart = 2;

		for (int start = 2; start < limit / longestSequence; start = nextPrime(start)) {
			int sum = 0;
			int count = 0;
			for (int prime = start; sum < limit; prime = nextPrime(prime)) {
				count++;
				sum += prime;
				if (sum < limit && longestSequence < count && isPrime(sum)) {
					longestSequence = count;
					longestSequenceSum = sum;
					longestSequenceStart = start;
				}
			}
		}
		System.out.println("sequence=" + longestSequence + " start=" + longestSequenceStart + " sum=" + longestSequenceSum);

		printDuration();
	}

	public static int nextPrime(int n) {
		for (int i = n + 1; i < 2 * n + 1; i++) {
			if (isPrime(i)) {
				return i;
			}
		}
		throw new ArithmeticException();
	}
}
