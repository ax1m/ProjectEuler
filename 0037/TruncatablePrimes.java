import java.util.HashSet;

public class TruncatablePrimes {

	private static HashSet<Integer> primes = new HashSet<Integer>();
	private static HashSet<Integer> truncPrimes = new HashSet<Integer>();

	public static void main(String[] args) {
		populatePrimes(1000000);
		populateTruncatablePrimes();
		System.out.println(truncPrimes.size());
		int sum = 0;
		for (int prime : truncPrimes) { sum += prime; }
		System.out.println(sum);
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

	private static void populateTruncatablePrimes() {
		for (int prime : primes) {
			if (prime<10) { continue; }
			String numString = Integer.toString(prime);
			int numLength = numString.length();
			boolean isTruncatable = true;
			for (int i=1; i<numLength; i++) {
				String truncLeft = numString.substring(i);
				String truncRight = numString.substring(0, (numLength-i));
				if (!(primes.contains(Integer.parseInt(truncLeft)) && primes.contains(Integer.parseInt(truncRight)))) {
					isTruncatable = false;
					break;
				}
			}
			if (isTruncatable) { truncPrimes.add(Integer.parseInt(numString)); }
		}
	}
}