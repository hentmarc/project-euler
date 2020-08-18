package eu.hem.euler.project.problem;

import static eu.hem.euler.project.util.PrimeUtils.isPrime;
import static eu.hem.euler.project.util.DigitUtils.*;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class P51PrimeDigitReplacement {
	
	private static final int[] RANGE_0_TO_9 = IntStream.range(0, 10).toArray();

	public static void main(String[] args) {
//		System.out.println(primesCount(10_000, 100_000));
//		System.out.println(primesWithTripleDigitsCount(100_000, 1_000_000));
//		printPrimesWithTripleDigitsFamilies(10_000, 100_000);
		
//		System.out.println(findPrimeFamiliesWithDoubleAdjacentDigits(100, 1000, 6));
//		Map<Integer, List<Integer>> families = new HashMap<>();
//		List<Integer> base = new ArrayList<>();
//		int startInclusive = 10_000;
//		int endExclusive = 100_000;
//		int digitsCount = 5;
//		for (int i = 0; i < digitsCount; i++) {
//			base.add(0);
//		}
//		
//		for (int n = startInclusive; n < endExclusive; n++) {
//			if (isPrime(n)) {
//				for (int i = 0; i < base.size(); i++) {
//					List<Integer> digits = new ArrayList<>(base);
//					for (int j = i + 1; j < digits.size(); j++) {
//						digits.set(i, 1);
//						digits.set(j, 1);
//						int diff = valueOf(digits);
//						List<Integer> primes = new ArrayList<>();
//						primes.add(n);
//						for (k = 0; k < )
//					}
//				}
//			}
//		}
		List<Integer> base = new ArrayList<>();
		int digitsCount = 6;
		for (int i = 0; i < digitsCount; i++) {
			base.add(0);
		}
		for (int i = 0; i < base.size(); i++) {
			for (int j = i + 1; j < base.size(); j++) {
				for (int k = j + 1; k < base.size(); k++) {
					List<Integer> digits = new ArrayList<>(base);
					digits.set(i, 1);
					digits.set(j, 1);
					digits.set(k, 1);
					int value = valueOf(digits);
					int mod6 = value % 6;
					if (mod6 == 0 || mod6 == 2 || mod6 == 4) {
						System.out.println(digits);
					}
				}
			}
		}
		printDuration();
	}
	
	private static Map<Integer, List<Integer>> findPrimeFamiliesWithDoubleAdjacentDigits(int startInclusive, int endExclusive, int minSize) {
		Map<Integer, List<Integer>> families = new HashMap<>();
		for (int i = startInclusive; i < endExclusive; i++) {
			families.putAll(findPrimeFamiliesWithDoubleAdjacentDigits(i, minSize));
		}
		return families;
	}
	
	private static Map<Integer, List<Integer>> findPrimeFamiliesWithDoubleAdjacentDigits(int n, int minSize) {
		Map<Integer, List<Integer>> families = new HashMap<>();
		List<Integer> digits = digits(n);
		
		for (int i = 0; i < digits.size(); i++) {
			List<Integer> primes = new ArrayList<>();
			for (int d : RANGE_0_TO_9) {
				List<Integer> newDigits = new ArrayList<>(digits);
				newDigits.add(i, d);
				newDigits.add(i, d);
				int value = valueOf(newDigits);
				if (isPrime(value)) {
					primes.add(value);
				}
			}
			if (primes.size() >= minSize) {
				families.put(primes.get(0), primes);
			}
		}
		return families;
	}
	
	private static Map<Integer, List<Integer>> findPrimeFamiliesWithDoubleDigits(int n, int minSize) {
		Map<Integer, List<Integer>> families = new HashMap<>();
		List<Integer> digits = digits(n);
		
		for (int i = 0; i < digits.size(); i++) {
			List<Integer> primes = new ArrayList<>();
			for (int d : RANGE_0_TO_9) {
				List<Integer> newDigits = new ArrayList<>(digits);
				newDigits.add(i, d);
				newDigits.add(i, d);
				int value = valueOf(newDigits);
				if (isPrime(value)) {
					primes.add(value);
				}
			}
			if (primes.size() >= minSize) {
				families.put(primes.get(0), primes);
			}
		}
		return families;
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
	
	public static int replaceDigits(int n, int d, int d2) {
		
		
		return n;
	}
}
