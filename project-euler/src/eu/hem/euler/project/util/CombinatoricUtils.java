package eu.hem.euler.project.util;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.valueOf;

import java.math.BigInteger;
import java.util.List;

public class CombinatoricUtils {

	public static BigInteger factor(long n) {
		return n == 0 ? ONE : valueOf(n).multiply(factor(n - 1));
	}

	public static List<Integer> nextPermutation(List<Integer> p) {
		for (int i = p.size() - 1; i > 0; i--) {
			if (p.get(i) > p.get(i - 1)) {
				List<Integer> next = p.subList(i - 1, p.size());
				next.sort(null);
				next.add(0, next.remove(next.indexOf(p.get(i - 1)) + 1));
				next.addAll(0, p.subList(0, i - 1));
				return next;
			}
		}
		return null;
	}

	public static int factor(int n) {
		return n == 0 ? 1 : n * factor(n - 1);
	}

}
