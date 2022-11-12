package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.PrimeUtils.sumsOfProperDivisors;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.util.ArrayList;
import java.util.List;

public class P095AmicableChains {

	public static void main(String[] args) {
		int limit = 1_000_000;
		int[] sums = sumsOfProperDivisors(limit);
		List<Integer> longestChain = new ArrayList<>();

		for (int i = 1; i < limit; i++) {
			List<Integer> chain = new ArrayList<Integer>();

			int j = i;
			while (j >= i && j < limit && !chain.contains(j)) {
				chain.add(j);
				j = sums[j];
			}

			if (j == i && chain.size() > longestChain.size()) {
				longestChain = chain;
			}
		}
		System.out.println(longestChain.get(0));
		printDuration();
	}

}
