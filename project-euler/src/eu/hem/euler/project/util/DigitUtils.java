package eu.hem.euler.project.util;

import static eu.hem.euler.project.util.CombinatoricUtils.factor;
import static java.math.BigInteger.TEN;
import static java.math.BigInteger.ZERO;

import java.math.BigDecimal;
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
	
	public static List<Integer> digits(long n) {
		List<Integer> digits = new ArrayList<>();
		while (n > 0) {
			digits.add(0, (int) (n % 10));
			n /= 10;
		}
		return digits;
	}
	
	public static List<Integer> digits(BigInteger n) {
		List<Integer> digits = new ArrayList<>();
		while (n.compareTo(BigInteger.ZERO) > 0) {
			BigInteger[] div = (n.divideAndRemainder(BigInteger.TEN));
			digits.add(0, div[1].intValue());
			n = div[0];
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
	
	public static int sumDigits(BigInteger b) {
		int sum = 0;
		while (b.compareTo(ZERO) == 1) {
			sum += b.remainder(TEN).intValue();
			b = b.divide(TEN);
		}
		return sum;
	}
	
	public static int sumDigits(BigDecimal d) {
		int sum = 0;
		for (char c : d.toPlainString().toCharArray()) {
			if (c != '.') {
				sum += c - '0';
			}
		}
		return sum;
	}
	
	public static int sumSquaredDigits(int n) {
		int sum = 0;
		while (n > 0) {
			int digit = n % 10;
			sum += digit * digit;
			n /= 10;
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
	
	public static int length(long n) {
		return String.valueOf(n).length();
	}

	public static int length(BigInteger b) {
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

	public static int parseInt(List<Integer> digits) {
		int value = 0;
		for (int d : digits) {
			value *= 10;
			value += d;
		}
		return value;
	}
	
	public static long parseLong(List<Long> digits) {
		long value = 0;
		for (long d : digits) {
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
