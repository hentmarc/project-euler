package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.PrimeUtils.isPrime;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;

public class P007Prime10001 {

	public static void main(String[] args) {
		int count = 0;
		int prime = 0;

		for (int i = 2; i < Integer.MAX_VALUE && count < 10001; i++) {
			if (isPrime(i)) {
				count++;
				prime = i;
			}
		}
		
		System.out.println("#" + count + " prime=" + prime);
		printDuration();
	}
}
