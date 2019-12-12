package eu.hem.euler.project.problem;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P67MaxPathSum2 {
	
	private static final String PATH = "resources/p067_triangle.txt";

	public static void main(String[] args) {
		int[][] numbers = loadTriangle(PATH);
		for (int i = numbers.length - 2; i > -1; i--) {
			for (int j = 0; j < numbers[i].length; j++) {
				numbers[i][j] += Integer.max(numbers[i + 1][j], numbers[i + 1][j + 1]);
			}
		}
		System.out.println(numbers[0][0]);
		printDuration();
	}

	private static int[][] loadTriangle(String path) {
		int[][] triangle = new int[100][];
		
		try (Scanner sc = new Scanner(new File(path))) {
			
			for (int i = 0; i < 100 && sc.hasNext(); i++) {
				String line = sc.nextLine();
				String[] lineSplitted = line.split(" ");
				int[] numbers = new int[lineSplitted.length];
				for (int j = 0; j < numbers.length; j++) {
					numbers[j] = Integer.valueOf(lineSplitted[j]);
				}
				triangle[i] = numbers;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return triangle;
	}
}
