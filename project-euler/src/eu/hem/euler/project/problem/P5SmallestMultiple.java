package eu.hem.euler.project.problem;

public class P5SmallestMultiple {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		for (int i = 2520; i < Integer.MAX_VALUE; i += 20) {
			if (divisible1To20(i)) {
				System.out.println(i);
				System.out.println(System.currentTimeMillis() - start);
				return;
			}
		}
	}

	public static boolean divisible1To20(int n) {
		for (int i = 2; i < 21; i++) {
			if (n % i != 0) {
				return false;
			}
		}
		return true;
	}
}
