package eu.hem.euler.project.util;

import static java.lang.Math.ceil;
import static java.lang.Math.floor;
import static java.lang.Math.sqrt;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;
import static java.math.BigInteger.valueOf;

import java.math.BigInteger;
import java.util.List;

public class EulerUtils {

	public static BigInteger factor(long n) {
		return n == 0 ? ONE : valueOf(n).multiply(factor(n - 1));
	}

	public static int factor(int n) {
		return n == 0 ? 1 : n * factor(n - 1);
	}

	public static int pentagonal(int n) {
		return n * (3 * n - 1) / 2;
	}

	public static int hexagonal(int n) {
		return n * (2 * n - 1);
	}

	public static BigInteger pentagonal(BigInteger n) {
		return n.multiply(n).multiply(valueOf(3)).subtract(n).divide(TWO);
	}

	public static boolean isPentagonal(int p) {
		int start = (int) ceil(sqrt(2 / 3 * p)); // n > sqrt(2/3p)
		double end = sqrt(p); // n < sqrt(p)
		for (int i = start; i <= end; i++) {
			if (pentagonal(i) == p) {
				return true;
			} else if (pentagonal(i) > p) {
				return false;
			}
		}
		return false;
	}
	
	public static boolean isTriangular(int t) {
		// t(n) = n(n+1)/2
		// 2t(n) = n(n+1)
		// n < sqrt(2t(n)) < n+1

		int n = (int) floor(sqrt(2 * t));
		return t == n * (n + 1) / 2;
	}
	
	public static int wordValue(String s) {
		int value = 0;
		for (char c : s.toCharArray()) {
			value += c - 'A' + 1;
		}
		return value;
	}
	
	public static List<Integer> nextPermutation(List<Integer> p) {
		for (int i = p.size() - 1; i > 0; i--) {
			if (p.get(i) > p.get(i - 1)) {
				List<Integer> next = p.subList(i - 1, p.size());
				next.sort(null);
				next.add(0, next.remove(next.indexOf(p.get(i - 1)) + 1));
				next.addAll(0, p.subList(0, i - 1));
				return next;
			}
		}
		return null;
	}
}
