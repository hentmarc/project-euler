package eu.hem.euler.project.fraction;

import static eu.hem.euler.project.util.PrimeUtils.gcd;
import static java.util.Arrays.copyOfRange;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

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

	public BigFraction add(BigFraction f) {
		return new BigFraction(this.n.multiply(f.d).add(f.n.multiply(this.d)), this.d.multiply(f.d));
	}

	public BigFraction subtract(BigFraction f) {
		return new BigFraction(this.n.multiply(f.d).subtract(f.n.multiply(this.d)), this.d.multiply(f.d));
	}

	public BigFraction multiply(BigFraction f) {
		return new BigFraction(this.n.multiply(f.n), this.d.multiply(f.d));
	}

	public BigFraction divide(BigFraction f) {
		return new BigFraction(this.n.multiply(f.d), this.d.multiply(f.n));
	}

	public BigFraction reciprocal() {
		return new BigFraction(this.d, this.n);
	}

	public static BigFraction continuedFraction(List<Integer> sequence) {
		return continuedFraction(sequence.stream().mapToInt(Integer::intValue).toArray());
	}

	public static BigFraction continuedFraction(int... parts) {
		if (parts.length == 1) {
			return new BigFraction(BigInteger.valueOf(parts[0]));
		}
		return new BigFraction(BigInteger.valueOf(parts[0]))
				.add(continuedFraction(copyOfRange(parts, 1, parts.length)).reciprocal());
	}

	public BigDecimal parseBigDecimal() {
		return new BigDecimal(this.n).divide(new BigDecimal(this.d), 30, RoundingMode.HALF_UP);
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
		return n + "/" + d + " ~= " + parseBigDecimal();
	}

}
