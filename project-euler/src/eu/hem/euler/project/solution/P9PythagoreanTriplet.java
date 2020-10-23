package eu.hem.euler.project.solution;

public class P9PythagoreanTriplet {

	public static void main(String[] args) {
		int sum = 1000;
		for (int a = 1; a < (sum - 3) / 3; a++) {
			for (int b = a; b < (sum - a - 1) / 2; b++) {
				int c = sum - a - b;
				if (a * a + b * b == c * c) {
					System.out.println(a + "*" + b + "*" + c + "=" + a * b * c);
				}
			}
		}
		
	}
}
