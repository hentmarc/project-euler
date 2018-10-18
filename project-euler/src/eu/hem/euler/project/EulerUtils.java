package eu.hem.euler.project;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EulerUtils {

	public static List<Integer> digits(int n) {
		List<Integer> digits = new ArrayList<>();
		while (n > 0) {
			digits.add(0, n % 10);
			n /= 10;
		}
		return digits;
	}

	public static boolean isPandigital(int n) {
		List<Integer> digits = digits(n);
		if (digits.size() > 9) {
			return false;
		}
		List<Integer> sample = IntStream.rangeClosed(1, digits.size()).boxed().collect(Collectors.toList());
		digits.sort(null);
		return sample.equals(digits);
	}
}
