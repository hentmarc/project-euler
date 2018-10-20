package eu.hem.euler.project.problem;

public class P2EvenFibonacci {

	public static void main(String[] args) {

		int sum = 0;

		for (int i = 1, j = 1, k = 0; j < 4_000_000; k = i + j, i = j, j = k) {

			if (j % 2 == 0) {
				sum += j;
			}
		}
		
		System.out.println("Sum = " + sum);
	}

}
