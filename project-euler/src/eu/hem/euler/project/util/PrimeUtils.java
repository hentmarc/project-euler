package eu.hem.euler.project.util;

import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;
import static java.util.Collections.frequency;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeUtils {

	public static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}

		if (n < 4) {
			return true;
		}

		if (n % 2 == 0 || n % 3 == 0) {
			return false;
		}

		if (n < 8) {
			return true;
		}

		for (int i = 5; i <= sqrt(n); i += 6) {
			if (n % i == 0 || n % (i + 2) == 0) {
				return false;
			}
		}

		return true;
	}

	public static List<Integer> primeFactors(int n) {
		List<Integer> factors = new ArrayList<>();

		if (n < 2) {
			return factors;
		}

		while (n % 2 == 0) {
			factors.add(2);
			n /= 2;
		}

		while (n % 3 == 0) {
			factors.add(3);
			n /= 3;
		}

		for (int i = 5; i <= sqrt(n); i += 6) {
			while (n % i == 0) {
				factors.add(i);
				n /= i;
			}
			while (n % (i + 2) == 0) {
				factors.add(i + 2);
				n /= (i + 2);
			}
		}

		if (n > 1) {
			factors.add(n);
		}

		return factors;
	}

	public static List<Long> primeFactors(long n) {
		List<Long> factors = new ArrayList<>();

		if (n < 2) {
			return factors;
		}

		while (n % 2 == 0) {
			factors.add(2L);
			n /= 2;
		}

		while (n % 3 == 0) {
			factors.add(3L);
			n /= 3;
		}

		for (long i = 5; i <= sqrt(n); i += 6) {
			while (n % i == 0) {
				factors.add(i);
				n /= i;
			}
			while (n % (i + 2) == 0) {
				factors.add(i + 2);
				n /= (i + 2);
			}
		}

		if (n > 1) {
			factors.add(n);
		}

		return factors;
	}

	public static int divisors(long n) {
		int count = 1;
		List<Long> factors = primeFactors(n);
		Set<Long> distinctFactors = new HashSet<>(factors);

		for (long l : distinctFactors) {
			count *= frequency(factors, l) + 1;
		}

		return count;
	}

	public static List<Integer> properDivisors(int n) {
		List<Integer> divisors = new ArrayList<>();

		int limit = (int) ceil(sqrt(n));
		int shift = n % 2 == 0 ? 1 : 2;
		int start = n % 2 == 0 ? 2 : 3;

		divisors.add(1);

		if (n > 1 && limit * limit == n) {
			divisors.add(limit);
		}

		for (int i = start; i < limit; i += shift) {
			if (n % i == 0) {
				divisors.add(i);
				divisors.add(n / i);
			}
		}

		return divisors;
	}

	public static int sumOfProperDivisors(int n) {
		int sum = 1;
		int limit = (int) ceil(sqrt(n));
		int shift = n % 2 == 0 ? 1 : 2;
		int start = n % 2 == 0 ? 2 : 3;

		if (n > 1 && limit * limit == n) {
			sum += limit;
		}

		for (int i = start; i < limit; i += shift) {
			if (n % i == 0) {
				sum += i;
				sum += n / i;
			}
		}

		return sum;
	}

	public static boolean isPerfect(int n) {
		return sumOfProperDivisors(n) == n;
	}

	public static boolean isAbudant(int n) {
		return sumOfProperDivisors(n) > n;
	}

	public static boolean isDeficient(int n) {
		return sumOfProperDivisors(n) < n;
	}

	public static int gcd(int n, int m) {
		return m == 0 ? n : gcd(m, n % m);
	}

	public static long gcd(long n, long m) {
		return m == 0 ? n : gcd(m, n % m);
	}

	public static BigInteger gcd(BigInteger n, BigInteger m) {
		return m.equals(BigInteger.ZERO) ? n : gcd(m, n.remainder(m));
	}

	public static int gcd(int... numbers) {
		return Arrays.stream(numbers).reduce(numbers[0], (a, b) -> gcd(a, b));
	}

	public static long gcd(long... numbers) {
		return Arrays.stream(numbers).reduce(numbers[0], (a, b) -> gcd(a, b));
	}

	public static BigInteger gcd(BigInteger... numbers) {
		return Arrays.stream(numbers).reduce(numbers[0], (a, b) -> gcd(a, b));
	}

	public static int lcm(int n, int m) {
		List<Integer> factorsN = primeFactors(n);
		List<Integer> factorsM = primeFactors(m);
		factorsN.stream().forEach(f -> factorsM.remove(f));
		factorsN.addAll(factorsM);
		return factorsN.stream().reduce(1, (a, b) -> a * b);
	}

	public static int lcm(int... numbers) {
		return Arrays.stream(numbers).reduce(1, (a, b) -> lcm(a, b));
	}

	public static int totient(int n) {
		Set<Integer> factors = new HashSet<>(primeFactors(n));

		double coprimes = n;
		for (int factor : factors) {
			coprimes *= 1.0 - (1.0 / factor);
		}

		return (int) coprimes;
	}
	
	public static int nextPrime(int n) {
		if (n < 2) {
			return 2;
		}
		for (int i = n + 1; i < n * 2; i++) {
			if (isPrime(i)) {
				return i;
			}
		}
		throw new ArithmeticException();
	}
	
	public static Integer previousPrime(int n) {
		for (int i = n - 1; i > n / 2; i--) {
			if (isPrime(i)) {
				return i;
			}
		}
		return null;
	}
	
	public static long primesCount(int startInclusive, int endExclusive) {
		return IntStream.range(startInclusive, endExclusive).filter(p -> isPrime(p)).count();
	}
	
	public static List<Integer> primes(int startInclusive, int endExclusive) {
		return IntStream.range(startInclusive, endExclusive).filter(p -> isPrime(p)).boxed().collect(Collectors.toList());
	}
}
