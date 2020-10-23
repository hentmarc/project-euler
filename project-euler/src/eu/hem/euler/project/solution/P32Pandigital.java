package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.DigitUtils.digits;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P32Pandigital {

	public static final List<Integer> SAMPLE = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

	public static void main(String[] args) {
		Set<Integer> pandigitalProducts = new HashSet<>();

		for (int i = 1; i < 10; i++) {
			for (int j = 1_000; j < 10_000; j++) {
				if(isPandigitalProduct(i, j)) {
					System.out.println(i + "*" + j + "=" + i * j);
					pandigitalProducts.add(i * j);
				}
			}
		}
		
		for (int i = 10; i < 100; i++) {
			for (int j = 100; j < 1_000; j++) {
				if(isPandigitalProduct(i, j)) {
					System.out.println(i + "*" + j + "=" + i * j);
					pandigitalProducts.add(i * j);
				}
			}
		}
		System.out.println(pandigitalProducts);
		System.out.println(pandigitalProducts.stream().reduce(0, (a, b) -> a + b));
	}
	
	public static boolean isPandigitalProduct(int a, int b) {
		List<Integer> digits = new ArrayList<>();
		digits.addAll(digits(a));
		digits.addAll(digits(b));
		digits.addAll(digits(a * b));
		digits.sort(null);
		return digits.equals(SAMPLE);
	}
}
