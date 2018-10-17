package eu.hem.euler.project;

import java.time.Duration;

public class P31CoinSums2 {

	public static void main(String[] args) {
		int[] coins = new int[] { 1, 2, 5, 10, 20, 50, 100, 200 };
		int[] ways = new int[201];
		int amount = 200;
		ways[0] = 1;
		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j <= amount; j++) {
				ways[j] += ways[j - coins[i]];
			}
		}
		System.out.println(ways[ways.length - 1]);
		System.out.println("duration=" + ProcessHandle.current().info().totalCpuDuration().orElse(Duration.ofMillis(0)).toMillis() + "ms");
	}
}
