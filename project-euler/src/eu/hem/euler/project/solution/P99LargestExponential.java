package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;
import static java.lang.Double.valueOf;
import static java.lang.Math.pow;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P99LargestExponential {

	public static final String PATH = "resources/p099_base_exp.txt";

	public static void main(String[] args) {
		double maxBase = 0;
		double maxExp = 0;
		int line = 0;

		try (Scanner sc = new Scanner(new File(PATH))) {
			for (int count = 1; sc.hasNextLine(); count++) {
				String[] baseExp = sc.nextLine().split(",");
				double base = valueOf(baseExp[0]);
				double exp = valueOf(baseExp[1]);

				if (valueOf(pow(maxBase, maxExp / exp)).compareTo(base) < 0) {
					maxBase = base;
					maxExp = exp;
					line = count;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(line);
		printDuration();
	}

}
