package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;

public class P085CountingRectangles {

	public static final int TARGET = 2_000_000;
	public static final int MAX = 100;
	
	public static void main(String[] args) {
		int minDiff = TARGET;
		int area = 0;
		
		for (int n = 1; n <= MAX; n++) {
			for (int m = 1; m <= n; m++) {
				int count = 0;
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= m; j++) {
						count += (n - i + 1) * (m - j + 1);
					}
				}
				int diff = Math.abs(TARGET - count);
				if (minDiff > diff) {
					minDiff = diff;
					area = n * m;
				}
			}
		}

		System.out.println(area);
		
		printDuration();
	}

}
