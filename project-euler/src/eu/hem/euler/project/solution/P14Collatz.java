package eu.hem.euler.project.solution;

import java.util.HashMap;
import java.util.Map;

public class P14Collatz {

	public static final Map<Long, Integer> VALUES = new HashMap<>();

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int maxLength = 0;
		int n = 1;

		for (int i = 500_000; i < 1_000_000; i++) {
			int length = collatz(i);
			if (length > maxLength) {
				n = i;
				maxLength = length;
			}

		}
		System.out.println("collatz(" + n + ")=" + maxLength);
		System.out.println("duration=" + (System.currentTimeMillis() - start) + "ms");
	}

	public static int collatz(long n) {
		if (n == 1) {
			return 1;
		} else if (n % 2 == 0) {
			return collatz(n / 2) + 1;
		} else {
			return collatz((3 * n + 1) / 2) + 2;
		}
	}

	public static int collatzCache(long n) {
		int length = 0;

		if (VALUES.containsKey(n)) {
			length = VALUES.get(n);
		} else if (n == 1) {
			length = 1;
			VALUES.put(1L, 1);
		} else if (n % 2 == 0) {
			length = collatz(n / 2) + 1;
			VALUES.put(n, length);
		} else {
			length = collatz((3 * n + 1) / 2) + 2;
			VALUES.put(n, length);
		}
		return length;
	}
}
