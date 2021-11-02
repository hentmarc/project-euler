package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import eu.hem.euler.project.roman.numeral.RomanNumeral;

public class P89RomanNumerals {
	
	public static final String PATH = "resources/p089_roman.txt";

	public static void main(String[] args) {
		int saved = 0;
		try (Scanner sc = new Scanner(new File(PATH))) {
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				RomanNumeral rn = new RomanNumeral(line);
				saved += line.length() - rn.numeral.length();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(saved);
		printDuration();
	}
}
