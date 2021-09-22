package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.DigitUtils.sumSquaredDigits;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.IntStream.range;

import java.util.Set;

public class P92SquareDigitChains {

	public static void main(String[] args) {
		Set<Integer> chainsTo89 = range(2, 568).filter(n -> chainsTo89(n)).boxed().collect(toSet());

		int count = 0;
		count += chainsTo89.size();
		count += range(568, 10_000_000).filter(n -> chainsTo89.contains(sumSquaredDigits(n))).count();

		System.out.println(count);
		printDuration();
	}

	public static boolean chainsTo89(int n) {
		return n > 1 && (n == 89 || chainsTo89(sumSquaredDigits(n)));
	}

}
