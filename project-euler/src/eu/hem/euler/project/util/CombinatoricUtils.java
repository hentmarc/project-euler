package eu.hem.euler.project.util;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.valueOf;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CombinatoricUtils {

	public static int factor(int n) {
		return n == 0 ? 1 : n * factor(n - 1);
	}

	public static BigInteger bigFactor(int n) {
		return n == 0 ? ONE : valueOf(n).multiply(bigFactor(n - 1));
	}

	public static List<Integer> nextPermutation(List<Integer> p) {
		for (int i = p.size() - 1; i > 0; i--) {
			if (p.get(i) > p.get(i - 1)) {
				List<Integer> next = new ArrayList<>(p.subList(i - 1, p.size()));
				next.sort(null);
				next.add(0, next.remove(next.indexOf(p.get(i - 1)) + 1));
				next.addAll(0, p.subList(0, i - 1));
				return next;
			}
		}
		return null;
	}

	public static List<List<Integer>> getPermutations(int n) {
		return getPermutations(IntStream.range(1, n + 1).boxed().collect(Collectors.toList()));
	}

	public static List<List<Integer>> getPermutations(List<Integer> elements) {
		List<List<Integer>> permutations = new ArrayList<>();
		if (elements.size() == 1) {
			permutations.add(elements);
		} else {
			for (Integer e : elements) {
				List<Integer> tail = new ArrayList<>(elements);
				tail.remove(e);
				for (List<Integer> permutation : getPermutations(tail)) {
					permutation.add(0, e);
					permutations.add(permutation);
				}
			}
		}
		return permutations;
	}

	public static int combinations(int n, int k) {
		return factor(n) / (factor(k) * factor(n - k));
	}
	
	public static BigInteger bigCombinations(int n, int k) {
		return bigFactor(n).divide(bigFactor(k).multiply(bigFactor(n - k)));
	}

	public static Set<Set<Integer>> getCombinations(int n, int k) {
		return getCombinations(IntStream.range(1, n + 1).boxed().collect(Collectors.toSet()), k);
	}

	public static Set<Set<Integer>> getCombinations(Set<Integer> elements, int k) {
		Set<Set<Integer>> combinations = new HashSet<>();
		if (k == 0) {
			combinations.add(new HashSet<>());
		} else if (k == elements.size()) {
			combinations.add(elements);
		} else {
			Set<Integer> part = new HashSet<>(elements);
			for (Integer e : elements) {
				part.remove(e);
				for (Set<Integer> combination : getCombinations(part, k - 1)) {
					combination.add(e);
					combinations.add(combination);
				}
			}
		}
		return combinations;
	}

}
