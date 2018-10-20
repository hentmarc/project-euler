package eu.hem.euler.project.problem;

import static eu.hem.euler.project.util.EulerUtils.digits;
import static java.lang.Math.pow;

import java.util.ArrayList;
import java.util.List;

public class P30Digit5thPower {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 2; i < 1_000_000; i++) {
			int sum = 0;
			for (int digit : digits(i)) {
				sum += pow(digit, 5);
			}
			if (sum == i) {
				list.add(i);
			}
		}
		System.out.println(list + " sum=" + list.stream().reduce(0, (a, b) -> a + b));
	}

}
