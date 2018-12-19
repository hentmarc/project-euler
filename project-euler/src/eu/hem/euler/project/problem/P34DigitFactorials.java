package eu.hem.euler.project.problem;

import static eu.hem.euler.project.util.CombinatoricUtils.factor;
import static eu.hem.euler.project.util.DigitUtils.digits;

public class P34DigitFactorials {

	public static void main(String[] args) {

		int sum = 0;
		for (int i = 3; i < 2177281; i++) {
			if (i == sumDigitFactorials(i)) {
				sum += i;
				System.out.println(i);
			}
		}
		System.out.println(sum);
	}

	public static int sumDigitFactorials(int n) {
		int sum = 0;
		for (int i : digits(n)) {
			sum += factor(i);
		}
		return sum;
	}
}
