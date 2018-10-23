package eu.hem.euler.project.util;

import static java.lang.Math.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
			count *= (Collections.frequency(factors, l) + 1);
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
		int gcd = 1;
		List<Integer> factorsN = primeFactors(n);
		List<Integer> factorsM = primeFactors(m);
		factorsN.retainAll(factorsM);
		gcd = factorsN.stream().reduce(1, (a, b) -> a * b);
		return gcd;
	}

}