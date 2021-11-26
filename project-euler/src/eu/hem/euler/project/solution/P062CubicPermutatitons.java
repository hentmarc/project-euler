package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;
import static java.lang.Math.pow;
import static java.util.Arrays.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P062CubicPermutatitons {

	public static void main(String[] args) {

		Map<String, List<Integer>> cubes = new HashMap<>();

		for (int i = 1; i < 10_000; i++) {
			String key = generateKey((long) pow(i, 3));
			List<Integer> cbrts = cubes.containsKey(key) ? cubes.get(key) : new ArrayList<>();
			cbrts.add(i);
			cubes.put(key, cbrts);
			if (cbrts.size() == 5) {
				System.out.println((long) pow(cbrts.get(0), 3));
				printDuration();
				return;
			}
		}
	}

	public static String generateKey(long l) {
		char[] chars = String.valueOf(l).toCharArray();
		sort(chars);
		return String.valueOf(chars);
	}
}
