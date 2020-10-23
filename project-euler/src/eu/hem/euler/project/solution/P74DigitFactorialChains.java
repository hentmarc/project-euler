package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.DigitUtils.sumDigitFactorials;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.util.ArrayList;
import java.util.List;

public class P74DigitFactorialChains {

	public static void main(String[] args) {
		int count = 0;
		for (int i = 1; i < 1_000_000; i++) {
			if (digitFactorialChain(i).size() == 60) {
				count++;
			}
		}
		System.out.println(count);
		printDuration();
	}

	public static List<Integer> digitFactorialChain(int n) {
		List<Integer> chain = new ArrayList<>();
		while (!chain.contains(n)) {
			chain.add(n);
			n = sumDigitFactorials(n);
		}
		return chain;
	}
}
