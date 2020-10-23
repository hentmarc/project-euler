package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.DigitUtils.digits;
import static eu.hem.euler.project.util.DigitUtils.valueOf;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P38PandigitalMultiples {

	private static final List<Integer> SAMPLE = IntStream.rangeClosed(1, 9).boxed().collect(Collectors.toList());

	public static void main(String[] args) {
		List<Integer> pandigitals = new ArrayList<>();
		for (int i = 1; i < 10_000; i++) {
			for (int j = 2; j < 10; j++) {
				List<Integer> digits = new ArrayList<>();
				List<Integer> multipliers = IntStream.rangeClosed(1, j).boxed().collect(Collectors.toList());
				for (int m : multipliers) {
					digits.addAll(digits(i * m));
				}
				if (digits.size() == SAMPLE.size() && digits.containsAll(SAMPLE)) {
					int pandigital = valueOf(digits);
					pandigitals.add(pandigital);
					// System.out.println(pandigital + " is the concatenated product of " + i + " and " + multipliers);
				} else if (digits.size() > SAMPLE.size()) {
					break;
				}
			}
		}
		System.out.println("Largest pandigital: " + pandigitals.stream().max(Comparator.naturalOrder()).get());
		printDuration();
	}

}
