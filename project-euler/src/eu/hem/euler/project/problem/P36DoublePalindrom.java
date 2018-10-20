package eu.hem.euler.project.problem;

import static eu.hem.euler.project.EulerUtils.isPalindorme;

public class P36DoublePalindrom {

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
