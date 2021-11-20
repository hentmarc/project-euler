package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;
import static java.lang.Math.min;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

import java.util.ArrayList;
import java.util.List;

public class P88ProductSumNumbers {

	public static final int MAX_LENGTH = 12000;
	public static final int MAX_VALUE = MAX_LENGTH * 2;

	public static void main(String[] args) {
		int[] minProdSums = range(0, MAX_LENGTH + 1).map(a -> a < 2 ? 0 : 2 * a).toArray();

		minProdSum(new ArrayList<Integer>(), minProdSums);

		System.out.println(stream(minProdSums).distinct().sum());
		printDuration();
	}

	public static void minProdSum(List<Integer> seq, int[] minProdSums) {
		int prod = seq.stream().reduce(1, (a, b) -> a * b);
		int sum = seq.stream().reduce(0, (a, b) -> a + b);
		int length = prod - sum + seq.size();
		if (length < minProdSums.length && prod < minProdSums[length]) {
			minProdSums[length] = prod;
		}
		
		int max = seq.size() == 0 ? MAX_LENGTH : min(seq.get(seq.size() - 1), MAX_VALUE / prod);
		for (int i = 2; i <= max; i++) {
			seq.add(i);
			minProdSum(seq, minProdSums);
			seq.remove(seq.size() - 1);
		}
	}
}
