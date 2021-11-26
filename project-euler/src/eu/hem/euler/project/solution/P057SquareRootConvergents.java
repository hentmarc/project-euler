package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.DigitUtils.length;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;

import java.math.BigInteger;

public class P057SquareRootConvergents {

	public static void main(String[] args) {

		int count = 0;
		BigInteger[] fraction = { ONE, ONE };
		for (int i = 1; i < 1001; i++) {
			fraction = new BigInteger[] { fraction[1].multiply(TWO).add(fraction[0]), fraction[0].add(fraction[1]) };
			if (length(fraction[0]) > length(fraction[1])) {
				count++;
			}
		}

		System.out.println(count); // 153
		printDuration();
	}

}
