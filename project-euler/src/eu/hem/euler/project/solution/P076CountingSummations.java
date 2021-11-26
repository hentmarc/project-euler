package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.EulerUtils.partitions;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;
import static java.math.BigInteger.ONE;

public class P076CountingSummations {

	public static void main(String[] args) {
		System.out.println(partitions(100).subtract(ONE));
		printDuration();
	}
}
