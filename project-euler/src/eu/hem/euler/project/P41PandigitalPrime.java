package eu.hem.euler.project;

import static eu.hem.euler.project.EulerUtils.*;

public class P41PandigitalPrime {

	public static void main(String[] args) {
		int max = 0;
		for (int i = 5; i <= 7654321; i += 6) {
			if (isPandigital(i) && isPrime(i) && i > max) {
				max = i;
			}
			if (isPandigital(i + 2) && isPrime(i + 2) && i + 2 > max) {
				max = i + 2;
			}
		}
		System.out.println(max);
	}

}
