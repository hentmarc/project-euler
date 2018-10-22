package eu.hem.euler.project.problem;

import static eu.hem.euler.project.util.ProcessUtils.printDuration;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;

import java.math.BigInteger;

public class P48SelfPowers {

	public static void main(String[] args) {
		BigInteger sum = ZERO;
		for (BigInteger i = ONE; i.compareTo(valueOf(1000)) <= 0; i = i.add(ONE)) {
			sum = sum.add(i.pow(i.intValue()));
		}
		String s = sum.toString();
		System.out.println(s.substring(s.length() - 10));
		printDuration();
	}
}
