package eu.hem.euler.project.problem;

public class P17NumberLetterCounts {

	public static final String[] UNITS = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
			"thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };

	public static final String[] TENS = { "zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

	public static final String HUNDRED = "hundred";
	public static final String THOUSAND = "thousand";

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 1000; i++) {
			String s = numberToLetters(i).replaceAll(" ", "").replaceAll("-", "");
			sum += s.length();
		}
		System.out.println(sum);
	}

	public static String numberToLetters(int n) {
		if (n > 1000 || n < 0) {
			throw new IllegalArgumentException("Case n > 1000 and n < 0 not implemented.");
		}
		if (n < 20) {
			return UNITS[n];
		}
		if (n == 1000) {
			return "one thousand";
		}

		int units = n % 10;
		n /= 10;
		int tens = n % 10;
		n /= 10;
		int hundreds = n % 10;

		StringBuilder sb = new StringBuilder();
		if (hundreds > 0) {
			sb.append(UNITS[hundreds] + " " + HUNDRED);
			if (tens > 0 || units > 0) {
				sb.append(" and ");
			}
		}

		if (tens > 1) {
			sb.append(TENS[tens]);
			if (units > 0) {
				sb.append("-");
			}
		}
		if (tens == 1) {
			units += 10;
		}
		if (units > 0) {
			sb.append(UNITS[units]);
		}

		return sb.toString();
	}
}
