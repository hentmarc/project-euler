package eu.hem.euler.project.solution;

import java.util.HashMap;
import java.util.Map;

public class P039RightTriangles {

	public static void main(String[] args) {
		Map<Integer, Integer> perimeters = new HashMap<>();
		
		for (int c = 1; c < 668; c++) {
			for (int b = 1; b < c; b++) {
				for (int a = 1; a <= b && a < 334; a++) {
					if (a + b + c <= 1000 && a * a + b * b == c * c) {
						int p = a + b + c;
						perimeters.put(p, perimeters.containsKey(p) ? perimeters.get(p) + 1 : 1);
					}
				}
			}
		}
		int perimeter = 0;
		int max = 0;
		for (int p : perimeters.keySet()) {
			if (perimeters.get(p) > max) {
				perimeter = p;
				max = perimeters.get(p);
			}
		}
		System.out.println(max + " solutions for " + perimeter + " perimeter");
	}
}
