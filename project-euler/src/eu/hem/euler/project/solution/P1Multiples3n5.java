package eu.hem.euler.project.solution;

import static java.util.stream.IntStream.range;

public class P1Multiples3n5 {

	public static void main(String[] args) {
		System.out.println(range(1, 1000).filter(n -> n % 3 == 0 || n % 5 == 0).sum());
	}
}
