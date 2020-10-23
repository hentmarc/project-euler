package eu.hem.euler.project.problem;

import static eu.hem.euler.project.util.CombinatoricUtils.bigFactor;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.math.BigInteger;

public class P15LatticePath {

	public static void main(String[] args) {
		BigInteger n = bigFactor(40);
		BigInteger m = bigFactor(20);

		BigInteger permutationMultiset = n.divide(m).divide(m);
		System.out.println(permutationMultiset); // 137846528820
		printDuration();
	}

}
