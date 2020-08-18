package eu.hem.euler.project.problem;

import static eu.hem.euler.project.util.PrimeUtils.isPrime;
import static eu.hem.euler.project.util.DigitUtils.*;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P51PrimeDigitReplacement2 {
	
	private static final int[] RANGE_0_TO_9 = IntStream.range(0, 10).toArray();

	public static void main(String[] args) {
//		System.out.println(primesWithTripleDigitsCount(10_000, 100_000));
		
		List<Integer> primes = IntStream.range(10_000, 100_000).filter(p -> isPrime(p)).filter(p -> containsTripleDigits(p)).boxed().collect(Collectors.toList());
		System.out.println(primes);
		printDuration();
	}
	
	public static long primesCount(int startInclusive, int endExclusive) {
		return IntStream.range(startInclusive, endExclusive).filter(p -> isPrime(p)).count();
	}
	
	public static long primesWithDoubleDigitsCount(int startInclusive, int endExclusive) {
		return IntStream.range(startInclusive, endExclusive).filter(p -> isPrime(p)).filter(p -> containsDoubleDigits(p)).count();
	}
	
	public static long primesWithTripleDigitsCount(int startInclusive, int endExclusive) {
		return IntStream.range(startInclusive, endExclusive).filter(p -> isPrime(p)).filter(p -> containsTripleDigits(p)).count();
	}
	
	public static void printPrimesWithTripleDigitsCount(int startInclusive, int endExclusive) {
		IntStream.range(startInclusive, endExclusive).filter(p -> isPrime(p)).filter(p -> containsTripleDigits(p)).forEach(a -> System.out.println(a));
	}
	
	public static void printPrimesWithTripleDigitsFamilies(int startInclusive, int endExclusive) {
		
		Map<Integer, List<Integer>> families = new HashMap<>();
		for (int i = startInclusive; i < endExclusive; i++) {
			if (isPrime(i)) {
					
				List<Integer> digits = digits(i);
				for (int d : RANGE_0_TO_9) {
					if (Collections.frequency(digits, d) > 2) {
						digits.removeAll(List.of(d));
						int number = valueOf(digits);
						if (!families.containsKey(number)) {
							families.put(number, new ArrayList<>());
						}
						families.get(number).add(i);
						break;
					}
				}
			}
		}
		System.out.println(families);
	}
	
	public static boolean containsDoubleDigits(int n) {
		List<Integer> digitsOfN = digits(n);
		for (int d : IntStream.range(0, 10).toArray()) {
			if (Collections.frequency(digitsOfN, d) > 1) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean containsTripleDigits(int n) {
		List<Integer> digitsOfN = digits(n);
		for (int d : IntStream.range(0, 10).toArray()) {
			if (Collections.frequency(digitsOfN, d) > 2) {
				return true;
			}
		}
		return false;
	}

}
