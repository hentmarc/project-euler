package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.DigitUtils.sumDigits;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;
import static eu.hem.euler.project.util.fraction.BigFraction.continuedFraction;

public class P65ConvergentsOfE {

	public static void main(String[] args) {

		int[] convergent = new int[100];
		convergent[0] = 2;
		for (int i = 1; i < 100; i++) {
			convergent[i] = i % 3 == 2 ? (i / 3 + 1) * 2 : 1;
		}

		System.out.println(sumDigits(continuedFraction(convergent).n));

		printDuration();
	}

}
