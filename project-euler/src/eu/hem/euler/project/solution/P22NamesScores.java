package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.EulerUtils.wordValue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P22NamesScores {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(new File("resources/p022_names.txt"))) {
			List<String> names = new ArrayList<>();

			sc.useDelimiter(",");
			while (sc.hasNext()) {
				names.add(sc.next());
			}
			names.sort(null);

			int sum = 0;

			for (int i = 0; i < names.size(); i++) {
				sum += (i + 1) * wordValue(names.get(i));
			}

			System.out.println(sum);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
