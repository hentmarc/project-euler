package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;
import static java.lang.Math.min;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

public class P088ProductSumNumbers {

	public static final int N = 12000;
	
	public static void main(String[] args) {
		int[] minProdSums = range(0, N + 1).map(a -> a < 2 ? 0 : 2 * a).toArray();
		minProdSum(1, 1, N, minProdSums);
		System.out.println(stream(minProdSums).distinct().sum());

		printDuration();
	}

	public static void minProdSum(int prod, int n, int max, int[] minProdSums) {
		if (n < minProdSums.length && prod < minProdSums[n]) {
			minProdSums[n] = prod;
		}
		for (int i = 2; i <= max; i++) {
			minProdSum(prod * i, n + (prod - 1) * (i - 1), min(i, (N * 2) / (prod * i)), minProdSums);
		}
	}

}
