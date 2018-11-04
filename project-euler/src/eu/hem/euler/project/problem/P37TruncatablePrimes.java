package eu.hem.euler.project.problem;

import static eu.hem.euler.project.util.PrimeUtils.*;
import static eu.hem.euler.project.util.ProcessUtils.*;

public class P37TruncatablePrimes {

	public static void main(String[] args) {
		int count = 0;
		int sum = 0;
		
		System.out.print("Truncatable primes:");
		for (int i = 23; count < 11 && i < Integer.MAX_VALUE; i += 2) {
			if (isTruncatablePrime(i)) {
				count++;
				sum += i;
				System.out.print(" " + i);
			}
		}
		System.out.println(" sum=" + sum);
		printDuration();
	}
	
	public static boolean isTruncatablePrime(int n) {
		if (!isPrime(n)) {
			return false;
		}
		
		for (int left = truncateLeft(n), right = truncateRight(n);
			left > 0 && right > 0;
			left = truncateLeft(left), right = truncateRight(right)) {
			
			if (!isPrime(left) || !isPrime(right)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static int truncateRight(int n) {
		if (n < 10) {
			return 0;
		}
		String s = Integer.toString(n);
		s = s.substring(0, s.length() - 1);
		return Integer.parseInt(s);
	}
	
	public static int truncateLeft(int n) {
		if (n < 10) {
			return 0;
		}
		String s = Integer.toString(n);
		s = s.substring(1);
		return Integer.parseInt(s);
	}
}
