import java.util.HashSet;

public class CircularPrimes {

	private static HashSet<Integer> primes = new HashSet<Integer>();
	private static HashSet<Integer> circPrimes = new HashSet<Integer>();

	public static void main(String[] args) {
		populatePrimes(1000000);
		populateCircularPrimes();
		System.out.println(circPrimes.size());
	}

	private static void populatePrimes(int range) {
		for (int cand=2; cand<range; cand++) {
			boolean isPrime = true;
			for (int prime : primes) {
				if (cand%prime == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) { primes.add(cand); }
		}
	}

	private static void populateCircularPrimes() {
		for (int prime : primes) {
			String numString = Integer.toString(prime);
			boolean isCircular = true;
			for (int i=1; i<numString.length(); i++) {
				String rotated = numString.substring(i) + numString.substring(0,i);
				if (!primes.contains(Integer.parseInt(rotated))) {
					isCircular = false;
					break;
				}
			}
			if (isCircular) { circPrimes.add(Integer.parseInt(numString)); }
		}
	}
}