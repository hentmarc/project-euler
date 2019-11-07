package eu.hem.euler.project.problem;

import static eu.hem.euler.project.util.PrimeUtils.lcm;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.util.stream.IntStream;

public class P5SmallestMultiple {

	public static void main(String[] args) {
		System.out.println(lcm(IntStream.range(2, 21).toArray()));
		printDuration();
	}
}
