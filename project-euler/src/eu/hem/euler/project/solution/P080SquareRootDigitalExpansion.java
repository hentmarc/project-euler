package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.DigitUtils.sumDigits;
import static eu.hem.euler.project.util.NumericUtils.sqrt;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.math.BigDecimal;

public class P080SquareRootDigitalExpansion {

	public static void main(String[] args) {

		int total = 0;
		for (int i = 0; i < 100; i++) {
			int s = (int) Math.sqrt(i);
			if (s * s != i) {
				BigDecimal sqrt = sqrt(i, 99);
				total += sumDigits(sqrt);
			}
		}
		System.out.println(total);
		printDuration();
	}
}