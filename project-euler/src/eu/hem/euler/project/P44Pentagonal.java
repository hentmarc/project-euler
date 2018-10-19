package eu.hem.euler.project;

import static eu.hem.euler.project.ProcessUtils.printDuration;
import static java.lang.Math.sqrt;

import java.util.ArrayList;
import java.util.List;

public class P44Pentagonal {

	public static void main(String[] args) {
		List<Integer> pentagonals = new ArrayList<>();
		
		for (int n = 1, p = 1; n < 2500; p += 3 * n + 1, n++) {
			pentagonals.add(p);
			for (int i = 0; i < pentagonals.size() - 1; i++) {
				int pi = pentagonals.get(i);
				if (pentagonals.contains(p - pi) && isPentagonal(p + pi)) {
					System.out.println(p - pi);
				}
			}
		}
		printDuration();
	}
	
	public static int nextPentagonal(int n, int p) {
		return p + 3 * n + 1; //P(n+1) = P(n) + 3n + 1
	}

	public static int pentagonal(int n) {
		return n * (3 * n - 1) / 2;
	}

	public static boolean isPentagonal(int p) {
		double start = sqrt(2 / 3 * p); // n > sqrt(2/3p)
		double end = sqrt(p); // n < sqrt(p)
		for (int i = (int) start; i < end; i++) {
			if (pentagonal(i) == p) {
				return true;
			} else if (pentagonal(i) > p) {
				return false;
			}
		}
		return false;
	}
}
