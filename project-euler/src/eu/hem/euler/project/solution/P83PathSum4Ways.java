package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import eu.hem.euler.project.matrix.MatrixShortestPath;

public class P83PathSum4Ways {

	public static final String PATH = "resources/p083_matrix.txt";
	public static final int SIZE = 80;
	public static final int[][] TEST_MATRIX = { { 131, 673, 234, 103, 18 }, { 201, 96, 342, 965, 150 },
			{ 630, 803, 746, 422, 111 }, { 537, 699, 497, 121, 956 }, { 805, 732, 524, 37, 331 } };

	public static void main(String[] args) {
		int[][] matrix = loadMatrix(PATH, SIZE);
//		int[][] matrix = TEST_MATRIX;
		MatrixShortestPath matrixShortestPath = new MatrixShortestPath(matrix);
		int sum = matrixShortestPath.getShortestPathSum();
//		int sum = minPathSum(matrix);
		System.out.println(sum);
//		System.out.println(matrixShortestPath);
		printDuration();
	}

	public static int minPathSum(int[][] matrix) {
		int dim = matrix.length;
		int[][] distance = new int[dim][dim];
		boolean changed = true;
		while (changed) {
			changed = false;
			for (int i = 0; i < dim; i++) {
				for (int j = 0; j < dim; j++) {
					int[] neighbours = new int[4];
					neighbours[0] = j > 0 ? distance[i][j - 1] : 0;
					neighbours[1] = i > 0 ? distance[i - 1][j] : 0;
					neighbours[2] = j + 1 < dim ? distance[i][j + 1] : 0;
					neighbours[3] = i + 1 < dim ? distance[i + 1][j] : 0;
					int alt = min(neighbours) + matrix[i][j];
					if (distance[i][j] == 0 || distance[i][j] > alt) {
						distance[i][j] = alt;
						changed = true;
					}
				}
			}
		}
		return distance[matrix.length - 1][matrix.length - 1];
	}

	public static int min(int... numbers) {
		return Arrays.stream(numbers).filter(n -> n != 0).min().orElse(0);
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
