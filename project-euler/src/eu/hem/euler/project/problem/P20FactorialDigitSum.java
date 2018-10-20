package eu.hem.euler.project.problem;

import static eu.hem.euler.project.util.EulerUtils.factor;
import static eu.hem.euler.project.util.DigitUtils.sumDigits;

public class P20FactorialDigitSum {
	
	public static void main(String[] args) {
		System.out.println(sumDigits(factor(100)));
	}
}
