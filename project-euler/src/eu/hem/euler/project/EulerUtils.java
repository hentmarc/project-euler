package eu.hem.euler.project;

import static java.lang.Math.sqrt;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EulerUtils {

	public static List<Integer> digits(int n) {
		List<Integer> digits = new ArrayList<>();
		while(n > 0) {
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
	
	public static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		} else if (n < 4) {
			return true;
		} else if (n % 2 == 0 || n % 3 == 0) {
			return false;
		} else if (n < 8) {
			return true;
		} else {
			for (int i = 5; i <= sqrt(n); i += 6) {
				if (n % i == 0 || n % (i + 2) == 0) {
					return false;
				}
			}
		}
		return true;
	}
}
