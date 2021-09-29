package eu.hem.euler.project.fraction;

import static eu.hem.euler.project.util.PrimeUtils.gcd;
import static java.lang.Math.sqrt;
import static java.util.Arrays.copyOfRange;

import static java.math.BigDecimal.valueOf;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Fraction {

	public final int n;
	public final int d;

	public Fraction(int n) {
		this.n = n;
		this.d = 1;
	}

	public Fraction(int n, int d) {
		if (d == 0) {
			throw new ArithmeticException("The denominator cannot be zero.");
		}

		int gcd = gcd(n, d);
		this.n = n / gcd;
		this.d = d / gcd;
	}

	public Fraction add(Fraction f) {
		return new Fraction(this.n * f.d + f.n * this.d, this.d * f.d);
	}

	public Fraction subtract(Fraction f) {
		return new Fraction(this.n * f.d - f.n * this.d, this.d * f.d);
	}

	public Fraction multiply(Fraction f) {
		return new Fraction(this.n * f.n, this.d * f.d);
	}

	public Fraction divide(Fraction f) {
		return new Fraction(this.n * f.d, this.d * f.n);
	}

	public Fraction reciprocal() {
		return new Fraction(this.d, this.n);
	}
	
	public static Fraction continuedFraction(List<Integer> sequence) {
		return continuedFraction(sequence.stream().mapToInt(Integer::intValue).toArray());
	}

	public static Fraction continuedFraction(int... sequence) {
		if (sequence.length == 1) {
			return new Fraction(sequence[0]);
		}
		return new Fraction(sequence[0]).add(continuedFraction(copyOfRange(sequence, 1, sequence.length)).reciprocal());
	}
	
	public static List<Integer> continuedFractionSequence(int n) {
		int sqrt = (int) sqrt(n);
		List<Integer> sequence = new ArrayList<>();
		sequence.add(sqrt);

		if (sqrt * sqrt != n) {
			int m = 0;
			int d = 1;
			int a = sqrt;

			while (a != sqrt * 2) {
				m = d * a - m;
				d = (n - m * m) / d;
				a = (sqrt + m) / d;
				sequence.add(a);
			}
		}
		return sequence;
	}

	public BigDecimal parseBigDecimal() {
		return valueOf(this.n).divide(valueOf(this.d), 20, RoundingMode.HALF_UP);
	}

	@Deprecated
	public static Fraction simplify(Fraction f) {
		int gcd = gcd(f.n, f.d);
		Fraction g = new Fraction(f.n / gcd, f.d / gcd);
		return g;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + d;
		result = prime * result + n;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fraction other = (Fraction) obj;
		if (d != other.d)
			return false;
		if (n != other.n)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return n + "/" + d + " ~= " + parseBigDecimal();
	}

}
