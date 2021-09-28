package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P81PathSum2Ways {

	private static final String PATH = "resources/p081_matrix.txt";
	private static final int SIZE = 80;
	
	public static void main(String[] args) {
		System.out.println(minPathSum(loadMatrix(PATH, SIZE)));
		printDuration();
	}
	
	public static int minPathSum(int[][] matrix) {
		for (int i = 1; i < matrix.length; i++) {
			matrix[i][0] += matrix[i - 1][0];
			matrix[0][i] += matrix[0][i - 1];
		}
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix.length; j++) {
				matrix[i][j] += matrix[i][j - 1] < matrix[i - 1][j] ? matrix[i][j - 1] : matrix[i - 1][j];
			}
		}
		return matrix[matrix.length - 1][matrix.length - 1];
	}
	
	private static int[][] loadMatrix(String path, int size) {
		int[][] matrix = new int[size][size];
		try (Scanner sc = new Scanner(new File(path))) {
			for (int i = 0; i < size && sc.hasNextLine(); i++) {
				String[] line = sc.nextLine().split(",");
				for (int j = 0; j < size; j++) {
					matrix[i][j] = Integer.valueOf(line[j]);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return matrix;
	}
}
