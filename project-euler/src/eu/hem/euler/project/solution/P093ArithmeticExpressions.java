package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.CombinatoricUtils.getCombinations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P093ArithmeticExpressions {
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		Set<Integer> digits = IntStream.range(0, 10).boxed().collect(Collectors.toSet());
		Set<Set<Integer>> combinations = getCombinations(digits, 4);
		double max = 0;
		Set<Integer> longest = new HashSet<>();

		for (Set<Integer> combination : combinations) {
			List<Double> numbers = combination.stream().map(n -> Double.valueOf(n)).collect(Collectors.toList());
			Set<List<Double>> results = new HashSet<>();
			results.add(numbers);
			results = reduce(results);
			Set<Double> result = results.stream().map(a -> a.get(0)).collect(Collectors.toSet());

			double consecutive = 0;
			while (result.contains(consecutive + 1)) {
				consecutive++;
			}
			if (consecutive > max) {
				max = consecutive;
				longest = combination;
			}
		}
		longest.stream().sorted().forEach(System.out::print);
		System.out.println();
		System.out.println("duration=" + (System.currentTimeMillis() - start));
	}

	public static Set<List<Double>> reduce(Set<List<Double>> results) {
		if (results.iterator().next().size() == 1) {
			return results;
		}
		Set<List<Double>> reduced = new HashSet<>();
		for (List<Double> numbers : results) {
			for (int i = 0; i < numbers.size(); i++) {
				double a = numbers.get(i);
				for (int j = i + 1; j < numbers.size(); j++) {
					double b = numbers.get(j);
					List<Double> base = new ArrayList<>(numbers);
					base.remove(a);
					base.remove(b);
					for (double r : calculate(a, b)) {
						List<Double> result = new ArrayList<>(base);
						result.add(r);
						reduced.add(result);
					}
				}
			}
		}
		return reduce(reduced);
	}

	public static Set<Double> calculate(double a, double b) {
		Set<Double> results = new HashSet<>();
		results.add(a + b);
		results.add(a * b);
		results.add(a - b);
		results.add(b - a);
		if (a != 0 && b != 0) {
			results.add(a / b);
			results.add(b / a);
		}
		return results;
	}
}
