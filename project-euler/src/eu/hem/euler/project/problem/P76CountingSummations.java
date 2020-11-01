package eu.hem.euler.project.problem;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;

public class P76CountingSummations {

	public static void main(String[] args) {
		int sum = 100;
		long[] ways = new long[sum + 1];
		ways[0] = 1;
		for (int i = 1; i < sum; i++) {
			for (int j = i; j <= sum; j++) {
				ways[j] += ways[j - i];
			}
		}
		System.out.println(ways[ways.length - 1]);
		printDuration();
	}

}
