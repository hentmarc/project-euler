package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.CombinatoricUtils.getCombinations;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P090CubeDigitPairs {

	public static Set<Integer> SQUARES = IntStream.range(1, 10).map(i -> i * i).boxed().collect(Collectors.toSet());

	public static void main(String[] args) {
		List<Set<Integer>> combinations = getCombinations(IntStream.range(0, 10).boxed().collect(Collectors.toSet()), 6)
				.stream()
				.peek(c -> { if (c.contains(6)) c.add(9); else if (c.contains(9)) c.add(6);})
				.collect(Collectors.toList());

		System.out.println(IntStream.range(0, combinations.size())
				.mapToLong(i -> IntStream.range(i, combinations.size()).filter(j -> SQUARES.stream()
						.allMatch(s -> (combinations.get(i).contains(s / 10) && combinations.get(j).contains(s % 10))
								|| (combinations.get(i).contains(s % 10) && combinations.get(j).contains(s / 10))))
						.count())
				.sum());

		printDuration();
	}
}
