package eu.hem.euler.project.solution;

import static eu.hem.euler.project.fraction.BigFraction.continuedFraction;
import static eu.hem.euler.project.fraction.Fraction.continuedFractionSequence;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;
import static java.lang.Math.sqrt;
import static java.math.BigInteger.ZERO;

import java.math.BigInteger;
import java.util.List;

public class P066DiophantineEquation {

	public static void main(String[] args) {
		BigInteger maxX = ZERO;
		int maxD = 0;

		for (int d = 2; d <= 1000; d++) {
			if ((int) sqrt(d) != sqrt(d)) {
				
				List<Integer> sequence = continuedFractionSequence(d);
				if (sequence.size() % 2 == 0) {
					sequence.addAll(sequence.subList(1, sequence.size()));
				}
				sequence.remove(sequence.size() - 1);
				
				BigInteger x = continuedFraction(sequence).n;
				
				if (maxX.compareTo(x) < 0) {
					maxX = x;
					maxD = d;
				}
			}
		}
		System.out.println(maxD);
		printDuration();
	}
}
