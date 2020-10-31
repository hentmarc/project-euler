package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.DigitUtils.digits;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;
import static java.lang.Math.pow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P62CubicPermutatitons {

	public static void main(String[] args) {

		Map<List<Integer>, List<Integer>> cubes = new HashMap<>();

		for (int i = 1; i < 10_000; i++) {
			List<Integer> digits = digits((long) pow(i, 3));
			digits.sort(null);

			if (!cubes.containsKey(digits)) {
				List<Integer> cbrts = new ArrayList<>();
				cbrts.add(i);
				cubes.put(digits, cbrts);
			} else {
				List<Integer> cbrts = cubes.get(digits);
				cbrts.add(i);
				if (cbrts.size() == 5) {
					System.out.println((long) pow(cbrts.get(0), 3));
					printDuration();
					return;
				}
			}
		}
	}
}
