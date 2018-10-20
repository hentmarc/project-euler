package eu.hem.euler.project.util;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.valueOf;

import java.math.BigInteger;

public class EulerUtils {

	public static BigInteger factor(long n) {
		return n == 0 ? ONE : valueOf(n).multiply(factor(n - 1));
	}

	public static int factor(int n) {
		return n == 0 ? 1 : n * factor(n - 1);
	}

}
