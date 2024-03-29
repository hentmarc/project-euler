package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.CombinatoricUtils.bigCombinations;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;
import static java.math.BigInteger.valueOf;

import java.math.BigInteger;

public class P053CombinatoricSelections {

	public static void main(String[] args) {
		BigInteger limit = valueOf(1_000_000);
		int count = 0;
		for (int n = 1; n <= 100; n++) {
			for (int r = 1; r <= n; r++) {
				if (bigCombinations(n, r).compareTo(limit) > 0) {
					count++;
				}
			}
		}
		System.out.println(count);
		printDuration();
	}

}
