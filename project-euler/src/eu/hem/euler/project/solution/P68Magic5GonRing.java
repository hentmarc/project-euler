package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.CombinatoricUtils.getCombinations;
import static eu.hem.euler.project.util.CombinatoricUtils.getPermutations;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;
import static java.lang.Math.pow;
import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.IntStream.range;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class P68Magic5GonRing {
	
	public static void main(String[] args) {
		System.out.println(getMagicRingSolutions(5)
						.stream()
						.filter(a -> a < pow(10, 16))
						.max(naturalOrder())
						.get());
		printDuration();
	}

	public static List<Long> getMagicRingSolutions(int size) {
		List<Long> solutions = new ArrayList<>();
		Set<Integer> values = range(1, size * 2 + 1).boxed().collect(toSet());

		for (Set<Integer> combination : getCombinations(values, size)) {
			Integer start = combination.stream().min(naturalOrder()).get();
			List<Integer> outer = new ArrayList<>(combination);
			outer.remove(start);
			List<Integer> inner = new ArrayList<>(values);
			inner.removeAll(combination);

			for (List<Integer> p : getPermutations(outer)) {
				p.add(0, start);
				for (List<Integer> q : getPermutations(inner)) {
					long[] fill = new long[size * 3];
					for (int i = 0; i < size; i++) {
						fill[i * 3] = p.get(i);
						fill[i * 3 + 1] = q.get(i);
						fill[i * 3 + 2] = q.get((i + 1) % size);
					}
					if (check(fill)) {
						StringBuilder sb = new StringBuilder();
						Arrays.stream(fill).forEach(a -> sb.append(String.valueOf(a)));
						solutions.add(Long.valueOf(sb.toString()));
					}
				}
			}
		}
		return solutions;
	}
	
	public static boolean check(long[] fill) {
		long sum = fill[0] + fill[1] + fill[2];
		for (int i = 3; i < fill.length; i += 3) {
			if (fill[i] + fill[i + 1] + fill[i + 2] != sum) {
				return false;
			}
		}
		return true;
	}

}
