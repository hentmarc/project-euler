package eu.hem.euler.project.problem;

import static eu.hem.euler.project.PrimeUtils.isPrime;

public class P27QuadraticPrimes {

	public static void main(String[] args) {
		int a = 0;
		int b = 0;
		int max = 0;
		for (int i = -999; i < 1000; i++) {
			for (int j = -1000; j <= 1000; j++) {
				int count = testFormula(i, j);
				if (count > max) {
					a = i;
					b = j;
					max = count;
				}
			}
		}
		System.out.println("n^2 + " + a + "n " + "+ " + b + " formula produces " + max + " primes");
		System.out.println("a * b = " + a * b);
	}

	public static int testFormula(int a, int b) {
		int count = 0;
		int n = 0;
		while(isPrime(n * n + a * n + b)) {
			count++;
			n++;
		}
		return count;
	}
}
