package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P81PathSum2Ways {

	private static final String PATH = "resources/p081_matrix.txt";
	private static final int SIZE = 80;
	
	public static void main(String[] args) {
		System.out.println(minPathSum(loadMatrix(PATH)));
		printDuration();
	}
	
	public static int minPathSum(int[][] m) {
		for (int i = 1; i < m.length; i++) {
			m[i][0] += m[i - 1][0];
			m[0][i] += m[0][i - 1];
		}
		for (int i = 1; i < m.length; i++) {
			for (int j = 1; j < m.length; j++) {
				m[i][j] += m[i][j - 1] < m[i - 1][j] ? m[i][j - 1] : m[i - 1][j];
			}
		}
		return m[m.length - 1][m.length - 1];
	}
	
	private static int[][] loadMatrix(String path) {
		int[][] matrix = new int[SIZE][SIZE];
		try (Scanner sc = new Scanner(new File(path))) {
			
			for (int i = 0; i < SIZE && sc.hasNext(); i++) {
				String[] line = sc.nextLine().split(",");
				for (int j = 0; j < SIZE; j++) {
					matrix[i][j] = Integer.valueOf(line[j]);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return matrix;
	}
}
