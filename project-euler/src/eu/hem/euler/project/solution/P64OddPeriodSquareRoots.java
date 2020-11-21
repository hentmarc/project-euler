package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;
import static eu.hem.euler.project.util.fraction.Fraction.continuedFractionSequence;
import static java.util.stream.IntStream.range;

public class P64OddPeriodSquareRoots {

	public static void main(String[] args) {
		System.out.println(range(1, 10001).filter(n -> continuedFractionSequence(n).size() % 2 == 0).count());
		printDuration();
	}
}
