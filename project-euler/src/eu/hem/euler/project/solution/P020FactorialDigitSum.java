package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.CombinatoricUtils.bigFactor;
import static eu.hem.euler.project.util.DigitUtils.sumDigits;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;

public class P020FactorialDigitSum {

	public static void main(String[] args) {
		System.out.println(sumDigits(bigFactor(100)));
		printDuration();
	}
}
