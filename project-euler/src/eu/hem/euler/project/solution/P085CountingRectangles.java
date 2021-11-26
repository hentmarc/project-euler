package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;

public class P085CountingRectangles {

	public static final int TARGET = 2_000_000;
	
	public static void main(String[] args) {
		int diff = TARGET;
		int area = 0;

		for (int n = 1; n < Math.sqrt(Math.sqrt(TARGET * 2)); n++) {
			int m = (int) Math.sqrt(4 * TARGET / (n * (n + 1)));
			int count = n * (n + 1) * m * (m + 1) / 4;
			int alt = Math.abs(TARGET - count);
			if (diff >= alt) {
				diff = alt;
				area = n * m;
			}
		}

		System.out.println(area);

		printDuration();
	}

}
