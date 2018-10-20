package eu.hem.euler.project.problem;

import static eu.hem.euler.project.util.EulerUtils.factor;

import java.math.BigInteger;

public class P15LatticePath {

	public static void main(String[] args) {
		BigInteger n = factor(40L);
		BigInteger m = factor(20L);
		
		BigInteger permutationMultiset = n.divide(m).divide(m);
		System.out.println(permutationMultiset); //137846528820
	}

}
