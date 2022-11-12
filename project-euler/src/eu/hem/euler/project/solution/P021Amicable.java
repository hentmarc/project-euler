package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.PrimeUtils.sumOfProperDivisors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P021Amicable {

	public static final Map<Integer, Integer> SUM_OF_PROPER_DIVISORS = new HashMap<>();

	public static void main(String[] args) {
		List<Integer> amicableNumbers = new ArrayList<>();

		for (int i = 1; i < 10_000; i++) {
			int sum = sumOfProperDivisors(i);
			if (sum < i && SUM_OF_PROPER_DIVISORS.containsKey(sum) && i == SUM_OF_PROPER_DIVISORS.get(sum)) {
				amicableNumbers.add(sum);
				amicableNumbers.add(i);
			}
			SUM_OF_PROPER_DIVISORS.put(i, sum);
		}
		System.out.println("sum" + amicableNumbers + "=" + amicableNumbers.stream().mapToInt(i -> i.intValue()).sum());
	}

}
