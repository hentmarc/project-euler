package eu.hem.euler.project.solution;

import static eu.hem.euler.project.util.EulerUtils.hexagonal;
import static eu.hem.euler.project.util.ProcessUtils.printDuration;
import static java.math.BigInteger.TWO;
import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;

import java.math.BigInteger;

public class P045TriPentaHexa {

	public static void main(String[] args) {
		
		int result = 0;
		for (int x = 995; result < 40756; x += 6) {
			BigInteger[] sqrt = valueOf(x).pow(2).add(TWO).divide(valueOf(3)).sqrtAndRemainder();
			if (sqrt[1].equals(ZERO)) {
				int y = sqrt[0].intValue();
				if ((y + 1) % 4 == 0) {
					int n = (x + 1) / 6;
					int m = (y + 1) / 4;
					int l = 2 * m - 1;
					result = hexagonal(m);
					System.out.println("T(" + l + ")=P(" + n + ")=H(" + m + ")=" + result);
					printDuration();
					return;
				}
			}
		}
	}

	
}
