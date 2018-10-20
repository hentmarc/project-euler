package eu.hem.euler.project.problem;

public class P7Prime10001 {

	public static void main(String[] args) {
		int count = 0;
		int prime = 0;

		for (int i = 1; i < Integer.MAX_VALUE && count < 10001; i++) {
			if (isPrime(i)) {
				count++;
				prime = i;
			}
		}
		System.out.println("count=" + count + " prime=" + prime);
		
//		System.out.println(isPrime(6));
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
	
	public static boolean isPrime2(int n) {
		if (n == 2) {
			return true;
		}
		
		if (n < 2 || n % 2 == 0) {
			return false;
		}
		
		int limit = (int) Math.ceil(Math.sqrt(n));
		
		for (int i = 3; i <= limit; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}
