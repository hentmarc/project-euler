package eu.hem.euler.project.problem;

import static eu.hem.euler.project.util.CombinatoricUtils.combinations;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;
import static java.math.BigInteger.valueOf;

import java.math.BigInteger;

public class P53CombinatoricSelections {

	public static void main(String[] args) {
		BigInteger limit = valueOf(1_000_000);
		int count = 0;
		for (int n = 1; n <= 100; n++) {
			for (int r = 1; r <= n; r++) {
				if (combinations(n, r).compareTo(limit) > 0) {
					count++;
				}
			}
		}
		System.out.println(count);
		printDuration();
	}

}
