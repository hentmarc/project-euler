package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;

public class P1Multiples3n5 {

	public static void main(String[] args) {
		int i = (999 / 3) * (3 + 999) / 2;
		int j = (995 / 5) * (5 + 995) / 2;
		int k = (990 / 15) * (15 + 990) / 2;

		System.out.println(i + j - k);
		printDuration();
	}
}
