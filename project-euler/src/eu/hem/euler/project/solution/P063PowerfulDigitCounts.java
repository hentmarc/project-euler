package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TEN;

import java.math.BigInteger;

public class P063PowerfulDigitCounts {

	public static void main(String[] args) {

		int count = 0;

		for (BigInteger i = ONE; i.compareTo(TEN) < 0; i = i.add(ONE)) {
			for (int exp = 1; i.pow(exp).toString().length() == exp; exp++) {
				count++;
			}
		}
		System.out.println(count);
		printDuration();
	}

}
