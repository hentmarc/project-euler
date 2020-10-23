package eu.hem.euler.project.problem;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P59XORDecription {

	public static void main(String[] args) {
		List<Integer> encripted = loadChars("resources/p059_cipher.txt");
		
		int[] key = findKey(encripted);
		System.out.println("key=" + (char) key[0] + (char) key[1] + (char) key[2]);
		
		List<Integer> decripted = decript(encripted, key);

		for (int c : decripted) {
			System.out.print((char) c);
		}
		System.out.println();
		
		int sum = decripted.stream().reduce(0, Integer::sum);
		System.out.println(sum);

		printDuration();
	}

	private static int[] findKey(List<Integer> encripted) {

		int[] bestKey = null;
		int maxGoodCharsCount = 0;

		for (int[] key = nextKey(null); key != null; key = nextKey(key)) {
			int goodCharsCount = 0;
			for (int i = 0; i < 25; i++) {
				int c = encripted.get(i) ^ key[i % key.length];
				if (checkChar(c)) {
					goodCharsCount++;
				}
			}
			if (goodCharsCount > maxGoodCharsCount) {
				maxGoodCharsCount = goodCharsCount;
				bestKey = Arrays.copyOf(key, key.length);
			}
		}

		return bestKey;
	}

	private static List<Integer> decript(List<Integer> encripted, int[] key) {
		List<Integer> decripted = new ArrayList<>();
		for (int i = 0; i < encripted.size(); i++) {
			decripted.add(encripted.get(i) ^ key[i % key.length]);
		}
		return decripted;
	}

	private static boolean checkChar(int c) {
		return (c > 96 && c < 123) || (c == 32);
	}

	private static int[] nextKey(int[] key) {
		if (key == null) {
			key = new int[] { 'a', 'a', 'a' };
		} else if (key[2] < 'z') {
			key[2]++;
		} else if (key[1] < 'z') {
			key[2] = 'a';
			key[1]++;
		} else if (key[0] < 'z') {
			key[2] = 'a';
			key[1] = 'a';
			key[0]++;
		} else {
			key = null;
		}
		return key;
	}

	private static List<Integer> loadChars(String path) {
		List<Integer> chars = new ArrayList<>();
		try (Scanner sc = new Scanner(Paths.get(path))) {
			sc.useDelimiter(",");
			while (sc.hasNextInt()) {
				chars.add(sc.nextInt());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return chars;
	}
}
