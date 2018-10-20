package eu.hem.euler.project.problem;

import static eu.hem.euler.project.util.EulerUtils.factor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P24Lexicographic {

	public static void main(String[] args) {
		System.out.println(getNthPermutation(10, 1_000_000)); // 2783915460
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
			step = step % factor(i);
			pn.add(p1.remove(shift));
		}

		return pn;
	}
}
