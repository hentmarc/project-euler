package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;

public class P071OrderedFractions {

	public static void main(String[] args) {
		double max = 0;
		double maxN = 0;
		double maxD = 0;

		for (double d = 1_000_000; d > 1; d--) {
			double n = Math.floor((d * 3 - 1) / 7);
			if (n / d > max) {
				max = n / d;
				maxN = n;
				maxD = d;
			}
		}
		
		System.out.println((int) maxN + "/" + (int) maxD);
		printDuration();
	}

}
