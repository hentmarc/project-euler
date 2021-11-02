package eu.hem.euler.project.roman.numeral;

public class RomanNumeral {

	public final int value;
	public final String numeral;

	public RomanNumeral(int value) {
		this.value = value;
		this.numeral = minimalForm(value);
	}
	
	public RomanNumeral(String notation) {
		this.value = calculateValue(notation);
		this.numeral = minimalForm(value);
	}

	private int calculateValue(String notation) {
		int sum = 0;
		int prev = 0;
		for (int i = notation.length() - 1; i > - 1; i--) {
			int value = Denomination.valueOf(notation.substring(i, i + 1)).value;
			sum += value < prev ? -value : value;
			prev = value;
		}
		return sum;
	}

	private String minimalForm(int value) {
		StringBuilder sb = new StringBuilder();
		for (Denomination d : Denomination.values()) {
			while (value >= d.value) {
				sb.append(d.name());
				value -= d.value;
			}
		}
		return sb.toString();
	}
	
	@Override
	public String toString() {
		return numeral;
	}

	public enum Denomination {
		M(1000), CM(900), D(500), CD(400), C(100), XC(90), L(50), XL(40), X(10), IX(9), V(5), IV(4), I(1);

		private int value;

		private Denomination(int value) {
			this.value = value;
		}
	}
}
