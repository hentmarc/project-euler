package eu.hem.euler.project.util;

public class BitUtils {

	public static int bitCount(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n >>= 1;
		}
		return count;
	}
}
