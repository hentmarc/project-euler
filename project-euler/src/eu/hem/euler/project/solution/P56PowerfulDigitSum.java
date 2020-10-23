package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.DigitUtils.sumDigits;
import static java.math.BigInteger.valueOf;

public class P56PowerfulDigitSum {

	public static void main(String[] args) {

		int max = 0;
		for (int i = 1; i < 100; i++) {
			for (int j = 1; j <= i; j++) {
				int sum = sumDigits(valueOf(i).pow(j));
				if (sum > max) {
					max = sum;
				}
			}
		}
		System.out.println(max);
	}
}
