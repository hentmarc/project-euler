package eu.hem.euler.project.solution;

import static java.math.BigInteger.*;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class P29DistinctPowers {
	
	public static void main(String[] args) {
		Set<BigInteger> values = new HashSet<>();
		
		for (int i = 2; i <= 100; i++) {
			for (int j = 2; j <= 100; j++) {
				values.add(valueOf(i).pow(j));
			}
		}
		
		System.out.println(values.size());
	}
}
