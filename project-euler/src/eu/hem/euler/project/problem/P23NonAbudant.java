package eu.hem.euler.project.problem;

import static eu.hem.euler.project.util.PrimeUtils.isAbudant;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class P23NonAbudant {

	public static final int LIMIT = 28124;
	public static final List<Integer> ABUDANT_NUMBERS;

	static {
		ABUDANT_NUMBERS = new ArrayList<>();
		for (int i = 1; i < LIMIT; i++) {
			if (isAbudant(i)) {
				ABUDANT_NUMBERS.add(i);
			}
		}
	}

	public static void main(String[] args) {
		int sum = 0;
		int max = 0;
		for (int i = 1; i < LIMIT; i++) {
			if (!isAbudantSum(i)) {
				sum += i;
				max = i;
			}
		}
		System.out.println("sum=" + sum + " max=" + max); // 4179871
		System.out.println("duration=" + ProcessHandle.current().info().totalCpuDuration().orElse(Duration.ofMillis(0)).toMillis() + "ms");
	}

	public static boolean isAbudantSum(int n) {
		if (n >= LIMIT) {
			return true;
		} else if (n < 24) {
			return false;
		}
		for (int i = 0; ABUDANT_NUMBERS.get(i) <= n / 2; i++) {
			if (ABUDANT_NUMBERS.contains(n - ABUDANT_NUMBERS.get(i))) {
				return true;
			}
		}
		return false;
	}
}
