package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.CombinatoricUtils.getCombinations;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P093ArithmeticExpressions {
	
	public static void main(String[] args) {
		Set<Integer> digits = IntStream.range(0, 10).boxed().collect(Collectors.toSet());
		Set<Character> operators = Set.of('+', '-', '*', '/');
		Set<Set<Integer>> combinations = getCombinations(digits, 4);

		int max = 0;
		Set<Integer> longest = new HashSet<>();

		for (Set<Integer> combination : combinations) {
			Set<Double> numbers = combination.stream().map(n -> (double) n).collect(Collectors.toSet());
			Set<Integer> results = new HashSet<>();

			createExpressions(numbers, operators, results);
			
			int consecutive = 0;
			while (results.contains(consecutive + 1)) {
				consecutive++;
			}
			if (consecutive > max) {
				max = consecutive;
				longest = combination;
			}
		}
		longest.stream().sorted().forEach(System.out::print);
		System.out.println();
		printDuration();
	}

	public static void createExpressions(Set<Double> numbers, Set<Character> operators, Set<Integer> results) {
		if (numbers.size() > 1) {
			for (double n : numbers) {
				for (double m : numbers) {
					if (m != n) {
						for (char o : operators) {
							if (o != '/' || m != 0) {
								double result = calculate(n, o, m);
								Set<Double> newNumbers = numbers.stream().filter(a -> a != n && a != m)
										.collect(Collectors.toSet());
								newNumbers.add(result);
								createExpressions(newNumbers, operators, results);
							}
						}
					}
				}
			}
		} else {
			double result = numbers.iterator().next();
			if (result > 0) {
				int intResult = (int) result;
				if (intResult == result) {
					results.add(intResult);
				}
			}
		}
	}

	public static double calculate(double arg1, char operator, double arg2) {
		switch (operator) {
		case '+':
			return arg1 + arg2;
		case '-':
			return arg1 - arg2;
		case '*':
			return arg1 * arg2;
		case '/':
			return arg1 / arg2;
		}
		return 0;
	}
}
