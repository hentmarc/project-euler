package eu.hem.euler.project.problem;

import static eu.hem.euler.project.util.DigitUtils.digits;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;
import static java.lang.Math.ceil;
import static java.lang.Math.pow;
import static java.util.Collections.max;

import java.util.List;

public class P52PandigitalMultiples {

	public static void main(String[] args) {
		List<Integer> multipliers = List.of(2, 3, 4, 5, 6);

		for (int i = 2; i < 10; i++) {
			int start = (int) pow(10, i);
			int end = (int) ceil(start * 10 / max(multipliers));
			for (int j = start; j < end; j++) {
				if (pandigitalMultiples(j, multipliers)) {
					System.out.println(j);
					printDuration();
					return;
				}
			}
		}
	}

	public static boolean sameDigits(int a, int b) {
		List<Integer> digitsA = digits(a);
		List<Integer> digitsB = digits(b);
		digitsA.sort(null);
		digitsB.sort(null);
		return digitsA.equals(digitsB);
	}

	public static boolean pandigitalMultiples(int a, List<Integer> multipliers) {
		for (int m : multipliers) {
			if (!sameDigits(a, a * m)) {
				return false;
			}
		}
		return true;
	}
}
