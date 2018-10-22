package eu.hem.euler.project.util;

import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;
import static java.math.BigInteger.valueOf;

import java.math.BigInteger;

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
}
