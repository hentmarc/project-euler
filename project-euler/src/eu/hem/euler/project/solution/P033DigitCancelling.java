package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.DigitUtils.digits;
import static eu.hem.euler.project.util.PrimeUtils.gcd;

import java.util.List;

public class P033DigitCancelling {

	public static void main(String[] args) {
		int prodN = 1;
		int prodD = 1;

		for (int d = 12; d < 100; d++) {
			for (int n = 11; n < d; n++) {
				if (n % 10 != 0 && d % 10 != 0) {
					List<Integer> nDigits = digits(n);
					List<Integer> dDigits = digits(d);
					if (dDigits.contains(nDigits.get(0))) {
						dDigits.remove(nDigits.get(0));
						nDigits.remove(0);
					} else if (dDigits.contains(nDigits.get(1))) {
						dDigits.remove(nDigits.get(1));
						nDigits.remove(1);
					} else {
						continue;
					}

					int n2 = nDigits.get(0);
					int d2 = dDigits.get(0);

					if ((double) n / (double) d == (double) n2 / (double) d2) {
						prodN *= n2;
						prodD *= d2;
					}
				}
			}
		}
		int gcd = gcd(prodN, prodD);
		System.out.println(prodN / gcd + "/" + prodD / gcd);
	}

}
