package eu.hem.euler.project.solution;

public class P028Spiral {

	public static void main(String[] args) {
		int n = 1;
		int sum = 1;
		int shift = 2;

		while (n < 1001 * 1001) {
			for (int i = 0; i < 4; i++) {
				n += shift;
				sum += n;
			}
			shift += 2;
		}

		System.out.println(sum);
	}

}
