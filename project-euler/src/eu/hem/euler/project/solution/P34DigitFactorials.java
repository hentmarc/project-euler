package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import eu.hem.euler.project.util.DigitUtils;

public class P34DigitFactorials {

	
	public static void main(String[] args) {

		int sum = 0;
		for (int i = 3; i < 2_177_281; i++) {
			if (i == DigitUtils.sumDigitFactorials(i)) {
				sum += i;
				System.out.println(i);
			}
		}
		System.out.println(sum);
		printDuration();
	}
}
