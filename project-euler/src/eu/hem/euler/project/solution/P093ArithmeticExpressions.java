package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;
import static eu.hem.euler.project.util.CombinatoricUtils.getCombinations;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class P093ArithmeticExpressions {

	public static void main(String[] args) {
		Set<Integer> digits = Set.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<Character> operators = List.of('+', '-', '*', '/');
		Set<Set<Integer>> combinations = getCombinations(digits, 4);

		int max = 0;
		Set<Integer> longest = new HashSet<>();
		
		for (Set<Integer> combination : combinations) {
			List<Double> numbers = combination.stream().map(n -> (double) n).collect(Collectors.toList());
			Set<Integer> results = new HashSet<>();
			
			createExpressions(numbers, operators, results);
			
			int consecutive = 0;
			for (int i = 1; results.contains(i); i++) {
				consecutive = i;
			}
			if (consecutive > max) {
				max = consecutive;
				longest = combination;
			}
		}
		System.out.println(longest.stream().sorted().collect(Collectors.toList()) + " " + max);
		printDuration();
	}
	
	public static void createExpressions(List<Double> numbers, List<Character> operators, Set<Integer> results) {
		if (numbers.size() > 1) {
			for (double n : numbers) {
				for (double m : numbers) {
					if (m != n) {
						for (char o : operators) {
							if (o != '/' || m != 0) {
								double result = calculate(n, o, m);
								List<Double> newNumbers = numbers.stream().filter(a -> a != n && a != m).collect(Collectors.toList());
								newNumbers.add(result);
								createExpressions(newNumbers, operators, results);
							}
						}
					}
				}
			}
		} else {
			double result = numbers.get(0);
			int intResult = (int) result;
			if (intResult == result && result > 0) {
				results.add(intResult);
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
