package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

import eu.hem.euler.project.poker.Hand;

public class P54PokerHands {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(Paths.get("resources/p054_poker.txt"))) {
			int count = 0;
			while (sc.hasNextLine()) {
				String[] line = sc.nextLine().split(" ");
				Hand hand1 = new Hand(Arrays.copyOfRange(line, 0, 5));
				Hand hand2 = new Hand(Arrays.copyOfRange(line, 5, line.length));
				count += hand1.value > hand2.value ? 1 : 0;
			}
			System.out.println(count);
		} catch (IOException e) {
			e.printStackTrace();
		}
		printDuration();
	}

}
