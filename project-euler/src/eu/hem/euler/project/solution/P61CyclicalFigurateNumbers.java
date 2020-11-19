package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import eu.hem.euler.project.util.polygon.PolygonalNumber;

public class P61CyclicalFigurateNumbers {

	public static void main(String[] args) {
		List<PolygonalNumber> polygonals = new ArrayList<>();
		IntStream.range(3, 9).forEach(s -> IntStream.range(1, 1000).mapToObj(n -> new PolygonalNumber(s, n))
				.dropWhile(p -> p.value < 1000).takeWhile(p -> p.value < 10000).forEach(p -> polygonals.add(p)));

		List<PolygonalNumber> links = new ArrayList<>();
		findLinks(links, polygonals);

		System.out.println("sum" + links + "=" + links.stream().mapToInt(p -> p.value).sum());
		printDuration();
	}

	public static void findLinks(List<PolygonalNumber> links, List<PolygonalNumber> polygonals) {
		for (PolygonalNumber p : polygonals) {
			if (linked(links, p)) {
				links.add(p);
				findLinks(links, polygonals);
				if (links.size() == 6) {
					return;
				}
				links.remove(p);
			}
		}
	}

	public static boolean linked(List<PolygonalNumber> links, PolygonalNumber p) {
		return links.stream().filter(l -> l.s == p.s).findAny().isEmpty()
				&& (links.size() == 0 || (links.get(links.size() - 1).value % 100 == p.value / 100
						&& (links.size() < 5 || p.value % 100 == links.get(0).value / 100)));
	}

}
