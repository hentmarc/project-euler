package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.DigitUtils.digits;
import static java.lang.Math.ceil;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P098AnagramicSquares {

	public static final String PATH = "resources/p098_words.txt";
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();

		try (Scanner sc = new Scanner(new File(PATH))) {

			String line = sc.nextLine();
			String[] words = line.replace("\"", "").split(",");
			
			Map<String, List<String>> anagramWordPairs = new HashMap<>();
			Arrays.stream(words).forEach(w -> {
				char[] chars = w.toCharArray();
				Arrays.sort(chars);
				String key = String.valueOf(chars);
				if (!anagramWordPairs.containsKey(key)) {
					anagramWordPairs.put(key, new ArrayList<>());
				}
				List<String> pair = anagramWordPairs.get(key);
				if (!pair.contains(w)) {
					pair.add(w);
				}
			});	
			
			List<String> keys = anagramWordPairs.keySet().stream().filter(k -> anagramWordPairs.get(k).size() > 1).collect(Collectors.toList());
			keys.sort(new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					return Integer.valueOf(o2.length()).compareTo(Integer.valueOf(o1.length()));
				}
			});
			
			long max = 0;
			for (String key : keys) {
				List<String> pair = anagramWordPairs.get(key);
				for (int i = 0; i < pair.size() - 1; i++) {
					String word1 = pair.get(i);
					
					int size = word1.length() - 1;
					for (long n = (long) ceil(sqrt(pow(10, size))); n * n < Math.pow(10, size + 1); n++) {
						List<Integer> digits = digits(n * n);
						Map<Character, Integer> dict = new HashMap<>();
						boolean fit = true;
						for (int k = 0; k < word1.length(); k++) {
							if (!dict.containsKey(word1.charAt(k))) {
								if (dict.containsValue(digits.get(k))) {
									fit = false;
									break;
								}
								dict.put(word1.charAt(k), digits.get(k));
							} else if (dict.get(word1.charAt(k)) != digits.get(k)) {
								fit = false;
								break;
							}
						}
						if (fit) {
							for (int j = i + 1; j < pair.size(); j++) {
								String word2 = pair.get(j);
								long mm = 0;
								for (char c : word2.toCharArray()) {
									mm *= 10;
									mm += dict.get(c);
								}
								long m = (long) ceil(sqrt(mm));
								if (m * m == mm && mm > n * n && mm > max) {
									max = mm;
								}
								
							}
							
						}
					}
				}
			}
			System.out.println(max);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("duration=" + (System.currentTimeMillis() - start));
	}

}
