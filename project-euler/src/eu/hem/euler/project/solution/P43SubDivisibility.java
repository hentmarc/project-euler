package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.util.ArrayList;
import java.util.List;

public class P43SubDivisibility {

	public static void main(String[] args) {
		List<List<Integer>> pandigitals = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (j != i) {
					pandigitals.add(List.of(j, i));
				}
			}
		}
		for (int divider : List.of(17, 13, 11, 7, 5, 3, 2, 1)) {
			List<List<Integer>> newPandigitals = new ArrayList<>();
			for (List<Integer> digits : pandigitals) {
				for (int d = 0; d < 10; d++) {
					if (!digits.contains(d) && (d * 100 + digits.get(0) * 10 + digits.get(1)) % divider == 0) {
						List<Integer> newDigits = new ArrayList<>(digits);
						newDigits.add(0, d);
						newPandigitals.add(newDigits);
					}
				}
			}
			pandigitals = newPandigitals;
		}

		long sum = 0;
		for (List<Integer> digits : pandigitals) {
			StringBuilder sb = new StringBuilder();
			for (int d : digits) {
				sb.append(d);
			}
			sum += Long.parseLong(sb.toString());
		}
		System.out.println(sum); // 16695334890

		printDuration();
	}

}
