package eu.hem.euler.project.solution;

public class P002EvenFibonacci {

	public static void main(String[] args) {

		int sum = 0;

		for (int i = 1, j = 1, k = 2; j < 4_000_001; i = j, j = k, k = i + j) {
			sum += k % 2 == 0 ? k : 0;
		}
		
		System.out.println(sum);
	}

}
