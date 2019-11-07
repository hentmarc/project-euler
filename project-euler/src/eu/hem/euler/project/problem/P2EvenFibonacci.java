package eu.hem.euler.project.problem;

public class P2EvenFibonacci {

	public static void main(String[] args) {

		int sum = 0;

		for (int i = 1, j = 1, k = 2; j < 4_000_001; i = j, j = k, k = i + j) {

			if (k % 2 == 0) {
				sum += k;
			}
		}
		
		System.out.println("Sum = " + sum);
//		Sum = 4613732
	}

}
