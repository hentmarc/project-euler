package eu.hem.euler.project.problem;

import static eu.hem.euler.project.util.PrimeUtils.isPrime;
import static eu.hem.euler.project.util.DigitUtils.digits;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class P51PrimeDigitReplacement {

	public static void main(String[] args) {
		System.out.println(primesCount(100_000, 1_000_000));
		System.out.println(primesWithDoubleDigitsCount(100_000, 1_000_000));
		printDuration();
	}

	public static long primesCount(int startInclusive, int endExclusive) {
		return IntStream.range(startInclusive, endExclusive).filter(p -> isPrime(p)).count();
	}
	
	public static long primesWithDoubleDigitsCount(int startInclusive, int endExclusive) {
		return IntStream.range(startInclusive, endExclusive).filter(p -> isPrime(p)).filter(p -> containsDoubleDigits(p, 0, 1, 2)).count();
	}
	
	public static boolean containsDoubleDigits(int n, int... digits) {
		List<Integer> digitsOfN = digits(n);
		for (int d : digits) {
			if (Collections.frequency(digitsOfN, d) > 1) {
				return true;
			}
		}
		return false;
	}
	
	public static int replaceDigits(int n, int d, int d2) {
		
		
		return n;
	}
}
