package eu.hem.euler.project.problem;

import static eu.hem.euler.project.util.DigitUtils.isPalindorme;
import static eu.hem.euler.project.util.DigitUtils.reverse;

import java.math.BigInteger;

public class P55Lychrel {

	public static void main(String[] args) {
		int count = 0;
		for (int i = 0; i < 10_000; i++) {
			if (isLychrel(i)) {
				count++;
			}
		}
		System.out.println(count);
	}

	public static boolean isLychrel(long n) {
		BigInteger b = BigInteger.valueOf(n);
		for (int i = 0; i < 50; i++) {
			b = b.add(reverse(b));
			if (isPalindorme(b)) {
				return false;
			}
		}
		return true;
	}
}
