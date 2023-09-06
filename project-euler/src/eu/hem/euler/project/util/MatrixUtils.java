package eu.hem.euler.project.util;

public class MatrixUtils {

	public static double[][] multiply(double[][] a, double[][] b) {
		double[][] result = new double[a.length][b[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				result[i][j] = 0.0;
				for (int k = 0; k < a[i].length; k++) {
					result[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return result;
	}
}
