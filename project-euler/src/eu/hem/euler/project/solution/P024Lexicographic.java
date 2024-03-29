package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.CombinatoricUtils.factor;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P024Lexicographic {

	public static void main(String[] args) {
		System.out.println(getNthPermutation(10, 1_000_000)); // 2783915460
		printDuration();
	}

	public static List<Integer> getNthPermutation(int range, int n) {
		if (range < 1 || n < 1 || factor(range) < n) {
			return null;
		}

		List<Integer> p1 = IntStream.range(0, range).boxed().collect(Collectors.toList());
		List<Integer> pn = new ArrayList<>();

		int step = n - 1;
		for (int i = range - 1; i > -1; i--) {
			int shift = step / factor(i);
			step %= factor(i);
			pn.add(p1.remove(shift));
		}

		return pn;
	}
}
