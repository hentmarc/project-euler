package eu.hem.euler.project.util;

import static eu.hem.euler.project.util.CombinatoricUtils.factor;
import static java.math.BigInteger.TEN;
import static java.math.BigInteger.ZERO;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DigitUtils {

	public static List<Integer> digits(int n) {
		List<Integer> digits = new ArrayList<>();
		while (n > 0) {
			digits.add(0, n % 10);
			n /= 10;
		}
		return digits;
	}

	public static int sumDigits(long n) {
		int sum = 0;
		while (n > 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}
	
	public static BigInteger sumDigits(BigInteger b) {
		BigInteger sum = ZERO;
		while (b.compareTo(ZERO) == 1) {
			sum = sum.add(b.remainder(TEN));
			b = b.divide(TEN);
		}
		return sum;
	}
	
	public static int sumDigitFactorials(int n) {
		int sum = 0;
		while (n > 0) {
			sum += factor(n % 10);
			n /= 10;
		}
		return sum;
	}

	public static int countDigits(BigInteger b) {
		return b.toString().length();
	}
	
	public static long reverse(long n) {
		long reverse = 0;
		while (n > 0) {
			reverse *= 10;
			reverse += n % 10;
			n /= 10;
		}
		return reverse;
	}
	
	public static BigInteger reverse(BigInteger n) {
		return new BigInteger(new StringBuilder(n.toString()).reverse().toString());
	}

	public static int valueOf(List<Integer> digits) {
		int value = 0;
		for (int d : digits) {
			value *= 10;
			value += d;
		}
		return value;
	}

	public static boolean isPandigital(int n) {
		List<Integer> digits = digits(n);
		List<Integer> sample = IntStream.rangeClosed(1, digits.size()).boxed().collect(Collectors.toList());
		digits.sort(null);
		return sample.equals(digits);
	}

	public static boolean isPalindorme(long n) {
		String s = Long.toString(n);
		String s2 = new StringBuilder(s).reverse().toString();
		return s.equals(s2);
	}
	
	public static boolean isPalindorme(BigInteger n) {
		String s = n.toString();
		String s2 = new StringBuilder(s).reverse().toString();
		return s.equals(s2);
	}

	public static boolean isPalindorme(int n, int radix) {
		String s = Integer.toString(n, radix);
		String s2 = new StringBuilder(s).reverse().toString();
		return s.equals(s2);
	}
}
