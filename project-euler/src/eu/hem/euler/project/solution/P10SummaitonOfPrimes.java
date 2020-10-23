package eu.hem.euler.project.solution;

public class P10SummaitonOfPrimes {

	public static void main(String[] args) {
		
		int limit = 2_000_000;
		long sum = 5;
		
		for (int i = 5; i < limit; i += 2) {
			if (isPrime(i)) {
				sum += i;
			}
		}
		
		System.out.println(sum);
	}

	public static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		} else if (n < 4) {
			return true;
		} else if (n % 2 == 0) {
			return false;
		} else if (n % 3 == 0) {
			return false;
		} else {
			int limit = (int) Math.floor(Math.sqrt(n));
			for (int i = 5; i <= limit; i += 6) {
				if (n % i == 0 || n % (i + 2) == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
}
