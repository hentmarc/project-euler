package eu.hem.euler.project.problem;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P96SuDoku {
	
	private static final Set<Integer> RANGE = IntStream.rangeClosed(1, 9).boxed().collect(Collectors.toSet());

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(new File("resources/p096_sudoku.txt"))) {
			int sum = 0;
			while (sc.hasNext()) {
				String line = sc.nextLine();
				if (line.startsWith("Grid")) {
					int[][] sudoku = new int[9][9];
					for (int i = 0; i < 9; i++) {
						char[] row = sc.nextLine().toCharArray();
						for (int j = 0; j < 9; j++) {
							sudoku[i][j] = row[j] - '0';
						}
					}
					solve(sudoku);
					sum += sudoku[0][0] * 100 + sudoku[0][1] * 10 + sudoku[0][2];
				}
			}
			System.out.println(sum);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		printDuration();
	}
	
	public static boolean solve(int[][] sudoku) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (sudoku[i][j] == 0) {
					
					Set<Integer> candidates = getCandidates(sudoku, i, j);
					
					if (candidates.size() == 0) {
						return false;
					}
					for (int n : candidates) {
						sudoku[i][j] = n;
						if (solve(sudoku)) {
							return true;
						}
					}
					sudoku[i][j] = 0;
					return false;
				}
			}
		}
		return true;
	}

	public static Set<Integer> getCandidates(int[][] sudoku, int i, int j) {
		if (sudoku[i][j] != 0) {
			return null;
		}
		Set<Integer> candidates = new HashSet<>(RANGE);

		for (int n = 0; n < 9; n++) {
			candidates.remove(sudoku[i][n]);
			candidates.remove(sudoku[n][j]);
		}
		for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {
			for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) {
				candidates.remove(sudoku[row][col]);
			}
		}
		return candidates;
	}

}
