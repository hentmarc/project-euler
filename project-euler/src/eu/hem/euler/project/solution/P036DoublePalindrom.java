package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.DigitUtils.isPalindorme;

public class P036DoublePalindrom {

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i < 1_000_000; i++) {
			if (isPalindorme(i) && isPalindorme(i, 2)) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

}
