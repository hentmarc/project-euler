package eu.hem.euler.project.util;

import static eu.hem.euler.project.util.PrimeUtils.gcd;
import static java.util.Arrays.copyOfRange;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

	public static Fraction add(Fraction f, Fraction g) {
		return new Fraction(f.n * g.d + g.n * f.d, f.d * g.d);
	}

	public static Fraction subtract(Fraction f, Fraction g) {
		return new Fraction(f.n * g.d - g.n * f.d, f.d * g.d);
	}

	public static Fraction multiply(Fraction f, Fraction g) {
		return new Fraction(f.n * g.n, f.d * g.d);
	}

	public static Fraction divide(Fraction f, Fraction g) {
		return new Fraction(f.n * g.d, f.d * g.n);
	}

	public static Fraction reciprocal(Fraction f) {
		return new Fraction(f.d, f.n);
	}

	public static Fraction continuedFraction(int... parts) {
		if (parts.length == 1) {
			return new Fraction(parts[0]);
		}
		return add(new Fraction(parts[0]), reciprocal(continuedFraction(copyOfRange(parts, 1, parts.length))));
	}

	public static BigDecimal valueOf(Fraction f) {
		BigDecimal nominator = BigDecimal.valueOf(f.n);
		BigDecimal denominator = BigDecimal.valueOf(f.d);
		return nominator.divide(denominator, 10, RoundingMode.HALF_UP);
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
		return n + "/" + d + " ~= " + valueOf(this);
	}

}
