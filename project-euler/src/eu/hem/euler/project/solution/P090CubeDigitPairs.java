package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.CombinatoricUtils.getCombinations;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P090CubeDigitPairs {

	public static Set<Integer> SQUARES = IntStream.range(1, 10).map(i -> i * i).boxed().collect(Collectors.toSet());

	public static void main(String[] args) {
		List<Set<Integer>> combinations = new ArrayList<>(
				getCombinations(IntStream.range(0, 10).boxed().collect(Collectors.toSet()), 6));

		int count = 0;
		for (int i = 0; i < combinations.size(); i++) {
			for (int j = i; j < combinations.size(); j++) {
				count += check(combinations.get(i), combinations.get(j)) ? 1 : 0;
			}
		}
		System.out.println(count);

		printDuration();
	}

	private static boolean check(Set<Integer> cube1, Set<Integer> cube2) {
		extend(cube1);
		extend(cube2);
		for (int square : SQUARES) {
			if (!(cube1.contains(square / 10) && cube2.contains(square % 10))
					&& !(cube1.contains(square % 10) && cube2.contains(square / 10))) {
				return false;
			}
		}
		return true;
	}

	private static void extend(Set<Integer> cube) {
		if (cube.contains(6)) {
			cube.add(9);
		}
		if (cube.contains(9)) {
			cube.add(6);
		}
	}
}
