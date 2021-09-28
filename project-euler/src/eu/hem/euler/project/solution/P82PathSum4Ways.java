package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class P82PathSum4Ways {

	public static final String PATH = "resources/p082_matrix.txt";
	public static final int SIZE = 80;
	public static final int[][] TEST_MATRIX = { { 131, 673, 234, 103, 18 }, { 201, 96, 342, 965, 150 },
			{ 630, 803, 746, 422, 111 }, { 537, 699, 497, 121, 956 }, { 805, 732, 524, 37, 331 } };

	public static void main(String[] args) {
		System.out.println(minPathSum(loadMatrix(PATH, SIZE)));
		printDuration();
	}

	public static int minPathSum(int[][] matrix) {
		int[][] minSumPath = new int[matrix.length][matrix.length];
		for (int row = 0; row < matrix.length; row++) {
			minSumPath[row][0] = matrix[row][0];
		}
		for (int col = 1; col < matrix.length - 1; col++) {
			for (int row = 0; row < matrix.length; row++) {
				minSumPath[row][col] = minSumPath[row][col - 1] + matrix[row][col];
			}
			for (int row = 1; row < matrix.length; row++) {
				if (minSumPath[row - 1][col] + matrix[row][col] < minSumPath[row][col]) {
					minSumPath[row][col] = minSumPath[row - 1][col] + matrix[row][col];
				}
			}
			for (int row = matrix.length - 2; row > -1; row--) {
				if (minSumPath[row + 1][col] + matrix[row][col] < minSumPath[row][col]) {
					minSumPath[row][col] = minSumPath[row + 1][col] + matrix[row][col];
				}
			}
		}
		int min = 0;
		for (int row = 0; row < matrix.length; row++) {
			minSumPath[row][matrix.length - 1] = minSumPath[row][matrix.length - 2] + matrix[row][matrix.length - 1];
			min = (min == 0 || min > minSumPath[row][matrix.length - 1]) ? minSumPath[row][matrix.length - 1] : min;
		}
		return min;
	}

	public static int[][] loadMatrix(String path, int size) {
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

	public static int min(int... numbers) {
		return Arrays.stream(numbers).reduce(numbers[0], (a, b) -> Math.min(a, b));
	}
}
