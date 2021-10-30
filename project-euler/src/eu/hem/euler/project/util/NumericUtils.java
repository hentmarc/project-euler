package eu.hem.euler.project.util;

import static java.math.BigDecimal.valueOf;
import static java.math.BigInteger.ONE;

import java.math.BigDecimal;

public class NumericUtils {

	public static BigDecimal sqrt(int n, int scale) {
		BigDecimal sqrt = BigDecimal.valueOf((int) Math.sqrt(n));
		BigDecimal d = valueOf(n);

		for (int i = 1; i < scale + 1; i++) {
			BigDecimal unit = new BigDecimal(ONE, i);
			while ((sqrt.add(unit)).pow(2).compareTo(d) < 0) {
				sqrt = sqrt.add(unit);
			}
		}
		return sqrt;
	}
}
