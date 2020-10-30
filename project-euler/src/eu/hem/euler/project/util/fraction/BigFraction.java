package eu.hem.euler.project.util.fraction;

import static eu.hem.euler.project.util.PrimeUtils.gcd;
import static java.util.Arrays.copyOfRange;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class BigFraction {

	public final BigInteger n;
	public final BigInteger d;

	public BigFraction(BigInteger n) {
		this.n = n;
		this.d = BigInteger.ONE;
	}

	public BigFraction(BigInteger n, BigInteger d) {
		if (d.equals(BigInteger.ZERO)) {
			throw new ArithmeticException("The denominator cannot be zero.");
		}

		BigInteger gcd = gcd(n, d);
		this.n = n.divide(gcd);
		this.d = d.divide(gcd);
	}

	public static BigFraction add(BigFraction f, BigFraction g) {
		return new BigFraction(f.n.multiply(g.d).add(g.n.multiply(f.d)), f.d.multiply(g.d));
	}

	public static BigFraction subtract(BigFraction f, BigFraction g) {
		return new BigFraction(f.n.multiply(g.d).subtract(g.n.multiply(f.d)), f.d.multiply(g.d));
	}

	public static BigFraction multiply(BigFraction f, BigFraction g) {
		return new BigFraction(f.n.multiply(g.n), f.d.multiply(g.d));
	}

	public static BigFraction divide(BigFraction f, BigFraction g) {
		return new BigFraction(f.n.multiply(g.d), f.d.multiply(g.n));
	}

	public static BigFraction reciprocal(BigFraction f) {
		return new BigFraction(f.d, f.n);
	}

	public static BigFraction continuedFraction(int... parts) {
		if (parts.length == 1) {
			return new BigFraction(BigInteger.valueOf(parts[0]));
		}
		return add(new BigFraction(BigInteger.valueOf(parts[0])),
				reciprocal(continuedFraction(copyOfRange(parts, 1, parts.length))));
	}

	public static BigDecimal valueOf(BigFraction f) {
		return new BigDecimal(f.n).divide(new BigDecimal(f.d), 30, RoundingMode.HALF_UP);
	}

	@Deprecated
	public static BigFraction simplify(BigFraction f) {
		BigInteger gcd = gcd(f.n, f.d);
		BigFraction g = new BigFraction(f.n.divide(gcd), f.d.divide(gcd));
		return g;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((d == null) ? 0 : d.hashCode());
		result = prime * result + ((n == null) ? 0 : n.hashCode());
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
		BigFraction other = (BigFraction) obj;
		if (d == null) {
			if (other.d != null)
				return false;
		} else if (!d.equals(other.d))
			return false;
		if (n == null) {
			if (other.n != null)
				return false;
		} else if (!n.equals(other.n))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return n + "/" + d + " ~= " + valueOf(this);
	}

}
