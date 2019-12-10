package eu.hem.euler.project.problem;

import static eu.hem.euler.project.util.DigitUtils.countDigits;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;

import java.math.BigInteger;

public class P57SquareRootConvergents {

	public static void main(String[] args) {

		int count = 0;
		for (int i = 1; i <= 1000; i++) {
			BigInteger[] fraction = sqrt2(i);
			if (countDigits(fraction[0]) > countDigits(fraction[1])) {
				count++;
			}
		}
		System.out.println(count); // 153
		printDuration();
	}

	public static BigInteger[] sqrt2(int n) {
		BigInteger[] fraction = iteration(n);
		fraction[0] = fraction[0].add(fraction[1]);
		return fraction;
	}

	public static BigInteger[] iteration(int n) {
		if (n == 1) {
			return new BigInteger[] { ONE, TWO };
		}
		BigInteger[] fraction = iteration(n - 1);
		return new BigInteger[] { fraction[1], fraction[1].multiply(TWO).add(fraction[0]) };
	}
}
