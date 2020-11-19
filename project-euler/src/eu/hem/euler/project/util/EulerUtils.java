package eu.hem.euler.project.util;

import static java.lang.Math.ceil;
import static java.lang.Math.floor;
import static java.lang.Math.sqrt;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;
import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;

import java.math.BigInteger;

public class EulerUtils {

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

	public static int polygonal(int s, int n) {
		return ((s - 2) * n * n - (s - 4) * n) / 2;
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
	
	public static BigInteger partitions(int n) {
		BigInteger[] partitions = new BigInteger[n + 1];
		partitions[0] = ONE;

		for (int i = 1; i < n + 1; i++) {
			partitions[i] = ZERO;

			for (int j = 1, p = (3 * j * j - j) / 2, s = 1; p <= i; j++, p = (3 * j * j - j) / 2, s *= -1) {
				partitions[i] = partitions[i].add(partitions[i - p].multiply(valueOf(s)));
			}
			for (int j = 1, p = (3 * j * j + j) / 2, s = 1; p <= i; j++, p = (3 * j * j + j) / 2, s *= -1) {
				partitions[i] = partitions[i].add(partitions[i - p].multiply(valueOf(s)));
			}
		}
		return partitions[n];
	}
}
