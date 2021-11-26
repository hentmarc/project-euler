package eu.hem.euler.project.solution;

public class P006SumSquare {

	public static void main(String[] args) {
		System.out.println(powOfSum(100) - sumOfPows(100));
	}

	public static int sumOfPows(int n) {
		int sum = 0;
		for (int i = 1; i < n + 1; i++) {
			sum += i * i;
		}
		return sum;
	}

	public static int powOfSum(int n) {
		int sum = (n * (1 + n)) / 2;
		return sum * sum;
	}
}
