package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.EulerUtils.isTriangular;
import static eu.hem.euler.project.util.EulerUtils.wordValue;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class P042CodedTriangle {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(Paths.get("resources/p042_words.txt"))) {
			sc.useDelimiter(",");
			int count = 0;
			while (sc.hasNext()) {
				if (isTriangular(wordValue(sc.next()))) {
					count++;
				}
			}
			System.out.println("Triangular words count: " + count);
		} catch (IOException e) {
			e.printStackTrace();
		}
		printDuration();
	}
}
