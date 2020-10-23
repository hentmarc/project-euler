package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class P79Passcode {

	public static void main(String[] args) {

		Map<Integer, Set<Integer>> before = new HashMap<>();
		try (Scanner sc = new Scanner(new File("resources/p079_keylog.txt"))) {
			while (sc.hasNext()) {
				List<Integer> chars = sc.nextLine().chars().mapToObj(e -> e - '0').collect(Collectors.toList());

				for (int i : chars) {
					if (!before.containsKey(i)) {
						before.put(i, new HashSet<>());
					}
				}
				before.get(chars.get(0)).add(chars.get(1));
				before.get(chars.get(0)).add(chars.get(2));
				before.get(chars.get(1)).add(chars.get(2));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		List<Integer> code = new ArrayList<>(before.keySet());

		code.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if (before.get(o1).contains(o2)) {
					return -1;
				} else if (before.get(o2).contains(o1)) {
					return 1;
				} else {
					return 0;
				}
			}
		});

		System.out.println(code);
//		73162890

		printDuration();
	}
}
