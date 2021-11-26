package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.DigitUtils.length;
import static eu.hem.euler.project.util.PrimeUtils.isPrime;
import static eu.hem.euler.project.util.PrimeUtils.primes;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;
import static java.lang.Math.pow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P060PrimePairSets {

	public static void main(String[] args) {

		List<Integer> primes = primes(3, 10_000);
		Map<Integer, List<Integer>> primePairs = new HashMap<>();

		for (int p : primes) {
			for (Integer q : primePairs.keySet()) {
				if (isPrimePair(p, q)) {
					primePairs.get(q).add(p);
				}
			}
			primePairs.put(p, new ArrayList<>());
		}

		for (int p : primes) {
			List<Integer> primePair = new ArrayList<>();
			primePair.add(p);
			List<Integer> primeSet = findPrimeSetOf5(primePair, primePairs);

			if (primeSet.size() > 4) {
				System.out.println(primeSet);
				System.out.println("sum=" + primeSet.stream().reduce(0, Integer::sum));
				printDuration();
				return;
			}
		}
	}

	public static int concat(int n, int m) {
		return n * (int) pow(10, length(m)) + m;
	}

	public static boolean isPrimePair(int n, int m) {
		return isPrime(concat(n, m)) && isPrime(concat(m, n));
	}

	public static List<Integer> findPrimeSetOf5(List<Integer> primeSet, Map<Integer, List<Integer>> allPrimePairs) {
		List<Integer> primePairs = allPrimePairs.get(primeSet.get(0));

		int last = primeSet.get(primeSet.size() - 1);
		if (primePairs.indexOf(last) < primePairs.size() - 1) {

			for (int i = primePairs.indexOf(last) + 1; i < primePairs.size(); i++) {
				int p = primePairs.get(i);
				boolean containsAll = true;
				for (int j = 1; j < primeSet.size(); j++) {
					if (!allPrimePairs.get(primeSet.get(j)).contains(p)) {
						containsAll = false;
						break;
					}
				}
				if (containsAll) {
					List<Integer> newPrimeSet = new ArrayList<>(primeSet);
					newPrimeSet.add(p);
					newPrimeSet = findPrimeSetOf5(newPrimeSet, allPrimePairs);
					if (newPrimeSet.size() > 4) {
						return newPrimeSet;
					}
				}
			}
		}
		return primeSet;
	}
}
