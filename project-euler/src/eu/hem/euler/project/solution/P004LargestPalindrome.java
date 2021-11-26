package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;

public class P004LargestPalindrome {

	public static void main(String[] args) {

		int largestPalindrome = 1;
		
		for (int i = 999; i > 99; i--) {
			for (int j = i; j > 99; j--) {
				if (i * j > largestPalindrome && isPalindorme(i * j)) {
					largestPalindrome = i * j;
				}
			}
		}
		System.out.println(largestPalindrome);
		printDuration();
	}
	
	public static boolean isPalindorme(int n) {
		String s = Integer.toString(n);
		String s2 = new StringBuilder(s).reverse().toString();
		return s.equals(s2);
	}

}
