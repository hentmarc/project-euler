package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;

public class P40Champernowne {

	public static void main(String[] args) {
		int value = 1;
		for (int i = 1; i <= 1_000_000; i *= 10) {
			value *= getChampernowneDigit(i);
		}
		System.out.println(value);
		printDuration();
	}

	public static int getChampernowneDigit(int n) {
		for (int d = 1; n > 0; d++) {
			int length = (int) Math.pow(10, d - 1) * 9 * d;
			if (n > length) {
				n -= length;
			} else {
				int number = (int) Math.pow(10, d - 1) + (n - 1) / d;
				int index = (n - 1) % d;
				return Integer.toString(number).charAt(index) - '0';
			}
		}
		return 0;
	}
}
