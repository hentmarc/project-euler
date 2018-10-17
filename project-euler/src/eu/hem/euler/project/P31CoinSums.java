package eu.hem.euler.project;

import static eu.hem.euler.project.ProcessUtils.printDuration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P31CoinSums {

	public static void main(String[] args) {
		System.out.println(partitions(200, Arrays.asList(200, 100, 50, 20, 10, 5, 2, 1)));
		printDuration();
	}

	public static int partitions(int target) {
		List<Integer> values = IntStream.rangeClosed(1, target).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		return partitions(target, values);
	}

	public static int partitions(int target, List<Integer> values) {
		return partitions(target, 0, values.get(0), values);
	}

	public static int partitions(int target, int sum, int value, List<Integer> values) {
		int count = 0;
		for (int i = 0; i <= target - sum; i += value) {
			if (sum + i == target) {
				count++;
			} else if (sum + i < target) {
				int next = values.indexOf(value) + 1;
				if (next < values.size()) {
					count += partitions(target, sum + i, values.get(next), values);
				}
			}
		}
		return count;
	}
}
