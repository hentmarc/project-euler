package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P82PathSum3Ways {

	public static final String PATH = "resources/p082_matrix.txt";
	public static final int SIZE = 80;

	public static void main(String[] args) {
		System.out.println(minPathSum(loadMatrix(PATH, SIZE)));
		printDuration();
	}

	public static int minPathSum(int[][] matrix) {
		int[][] path = new int[matrix.length][matrix.length];
		for (int row = 0; row < matrix.length; row++) {
			path[row][0] = matrix[row][0];
		}
		
		for (int col = 1; col < matrix.length - 1; col++) {
			for (int row = 0; row < matrix.length; row++) {
				path[row][col] = path[row][col - 1] + matrix[row][col];
			}
			for (int row = 1; row < matrix.length; row++) {
				if (path[row - 1][col] + matrix[row][col] < path[row][col]) {
					path[row][col] = path[row - 1][col] + matrix[row][col];
				}
			}
			for (int row = matrix.length - 2; row > -1; row--) {
				if (path[row + 1][col] + matrix[row][col] < path[row][col]) {
					path[row][col] = path[row + 1][col] + matrix[row][col];
				}
			}
		}
		int min = 0;
		for (int row = 0; row < matrix.length; row++) {
			path[row][matrix.length - 1] = path[row][matrix.length - 2] + matrix[row][matrix.length - 1];
			min = (min == 0 || min > path[row][matrix.length - 1]) ? path[row][matrix.length - 1] : min;
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
}
