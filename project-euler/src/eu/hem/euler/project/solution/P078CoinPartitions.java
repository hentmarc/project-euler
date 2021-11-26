package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;

import java.math.BigInteger;

public class P078CoinPartitions {

	public static void main(String[] args) {

		int n = 100_000;
		BigInteger d = valueOf(1_000_000);
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

			if (partitions[i].divideAndRemainder(d)[1].equals(ZERO)) {
				System.out.println(i);
				printDuration();
				return;
			}
		}
	}
}
