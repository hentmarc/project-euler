package eu.hem.euler.project.problem;

import static eu.hem.euler.project.util.DigitUtils.countDigits;
import static java.math.BigInteger.ONE;

import java.math.BigInteger;

public class P25Fibonacci1KDigits {

	public static void main(String[] args) {
		BigInteger f1 = ONE;
		BigInteger f2 = ONE;
		int index = 2;

		while (countDigits(f1) < 1000) {
			BigInteger f = f1.add(f2);
			f2 = f1;
			f1 = f;
			index++;
		}
		System.out.println("F(" + index + ") contains 1000 digits"); // 4782
	}

	public static BigInteger fibonacci(int n) {
		if (n < 1) {
			throw new IllegalArgumentException("n must be positive");
		}
		if (n < 3) {
			return ONE;
		}

		BigInteger f1 = ONE;
		BigInteger f2 = ONE;

		for (int i = 3; i <= n; i++) {
			BigInteger f = f1.add(f2);
			f2 = f1;
			f1 = f;
		}

		return f1;
	}
}
