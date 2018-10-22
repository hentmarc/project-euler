package eu.hem.euler.project.problem;

import static eu.hem.euler.project.util.PrimeUtils.primeFactors;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.util.HashSet;
import java.util.Set;

public class P47DistinctFactors {

	public static void main(String[] args) {
		for (int i = 1; i < 1_000_000; i++) {
			Set<Long> distinctFactors1 = new HashSet<>(primeFactors(i));
			Set<Long> distinctFactors2 = new HashSet<>(primeFactors(i + 1));
			Set<Long> distinctFactors3 = new HashSet<>(primeFactors(i + 2));
			Set<Long> distinctFactors4 = new HashSet<>(primeFactors(i + 3));
			
			if (distinctFactors1.size() == 4 &&
				distinctFactors2.size() == 4 &&
				distinctFactors3.size() == 4 &&
				distinctFactors4.size() == 4 &&
				!distinctFactors1.removeAll(distinctFactors2) &&
				!distinctFactors2.removeAll(distinctFactors3) &&
				!distinctFactors3.removeAll(distinctFactors4))
			{
				
				System.out.println(i + " " + distinctFactors1);
				System.out.println((i + 1) + " " + distinctFactors2);
				System.out.println((i + 2) + " " + distinctFactors3);
				System.out.println((i + 3) + " " + distinctFactors4);
				printDuration();
				return;
			}
		}
	}

}
