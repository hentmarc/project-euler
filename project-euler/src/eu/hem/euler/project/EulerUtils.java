package eu.hem.euler.project;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TEN;
import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EulerUtils {

	public static BigInteger factor(long n) {
		return n == 0 ? ONE : valueOf(n).multiply(factor(n - 1));
	}
	
	public static int factor(int n) {
		return n == 0 ? 1 : n * factor(n - 1);
	}
	
	public static boolean isPandigital(int n) {
		List<Integer> digits = digits(n);
		if (digits.size() > 9) {
			return false;
		}
		List<Integer> sample = IntStream.rangeClosed(1, digits.size()).boxed().collect(Collectors.toList());
		digits.sort(null);
		return sample.equals(digits);
	}
	
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
	
	public static int countDigits(BigInteger b) {
		return b.toString().length();
	}
	
	public static boolean isPalindorme(int n) {
		String s = Integer.toString(n);
		String s2 = new StringBuilder(s).reverse().toString();
		return s.equals(s2);
	}
	
	public static boolean isPalindorme(int n, int radix) {
		String s = Integer.toString(n, radix);
		String s2 = new StringBuilder(s).reverse().toString();
		return s.equals(s2);
	}
}
