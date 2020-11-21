package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;
import static java.lang.Math.sqrt;
import static java.util.stream.IntStream.range;

import java.util.ArrayList;
import java.util.List;

public class P64OddPeriodSquareRoots {

	public static void main(String[] args) {
		System.out.println(range(1, 10001).filter(n -> fraction(n).size() % 2 == 0).count());
		printDuration();
	}

	public static List<Integer> fraction(int n) {
		int sqrt = (int) sqrt(n);
		List<Integer> fraction = new ArrayList<>();
		fraction.add(sqrt);

		if (sqrt * sqrt != n) {
			int m = 0;
			int d = 1;
			int a = sqrt;

			while (a != sqrt * 2) {
				m = d * a - m;
				d = (n - m * m) / d;
				a = (sqrt + m) / d;
				fraction.add(a);
			}
		}
		return fraction;
	}
}
