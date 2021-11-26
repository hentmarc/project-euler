package eu.hem.euler.project.solution;

import static eu.hem.euler.project.fraction.Fraction.continuedFractionSequence;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;
import static java.util.stream.IntStream.range;

public class P064OddPeriodSquareRoots {

	public static void main(String[] args) {
		System.out.println(range(1, 10001).filter(n -> continuedFractionSequence(n).size() % 2 == 0).count());
		printDuration();
	}
}
