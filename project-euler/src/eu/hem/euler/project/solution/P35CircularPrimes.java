package eu.hem.euler.project.problem;

import static eu.hem.euler.project.util.PrimeUtils.isPrime;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P35CircularPrimes {

	public static void main(String[] args) {
		List<Integer> circularPrimes = new ArrayList<>();

		for (int n = 2; n < 1_000_000; n++) {
			String s = Integer.toString(n);
			if (s.indexOf('0') == -1) {
				Set<Integer> circularNumbers = getCircularNumbers(n);

				boolean circularPrime = true;
				for (int i : circularNumbers) {
					if (!isPrime(i)) {
						circularPrime = false;
						break;
					}
				}
				if (circularPrime) {
					circularPrimes.add(n);
				}
			}
		}
		System.out.println(circularPrimes);
		System.out.println(circularPrimes.size());
		printDuration();

	}

	public static Set<Integer> getCircularNumbers(int n) {
		Set<Integer> numbers = new HashSet<>();
		numbers.add(n);

		char[] chars = Integer.toString(n).toCharArray();
		for (int i = 1; i < Integer.toString(n).length(); i++) {
			chars = shiftRight(chars);
			int number = Integer.valueOf(new String(chars));
			numbers.add(number);
		}
		return numbers;
	}

	public static char[] shiftRight(char[] chars) {
		char[] shifted = Arrays.copyOfRange(chars, 1, chars.length + 1);
		shifted[shifted.length - 1] = chars[0];
		return shifted;
	}
}
