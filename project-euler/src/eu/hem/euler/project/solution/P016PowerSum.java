package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.DigitUtils.sumDigits;
import static java.math.BigInteger.TWO;

public class P016PowerSum {

	public static void main(String[] args) {
		System.out.println(sumDigits(TWO.pow(1000)));
	}
}
