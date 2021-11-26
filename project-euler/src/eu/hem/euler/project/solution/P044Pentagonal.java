package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.EulerUtils.isPentagonal;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.util.ArrayList;
import java.util.List;

public class P044Pentagonal {

	public static void main(String[] args) {
		List<Integer> pentagonals = new ArrayList<>();
		
		for (int n = 1, p = 1; n < 2500; p += 3 * n + 1, n++) {
			pentagonals.add(p);
			for (int i = 0; i < pentagonals.size() - 1; i++) {
				int pi = pentagonals.get(i);
				if (pentagonals.contains(p - pi) && isPentagonal(p + pi)) {
					System.out.println(p - pi);
					printDuration();
					return;
				}
			}
		}
	}
}
