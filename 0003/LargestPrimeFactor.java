public class LargestPrimeFactor {
	public static void main(String[] args) {
		long arg = Long.parseLong(args[0]);
		int largest = 0;
		for (int i=2; i <= Math.sqrt(arg); i++) {
			if (arg%i == 0 && isPrime(i)) { largest = i; }
		}
		System.out.println(largest);
	}

	public static boolean isPrime(long n) {
		for (int i=2; i <= Math.sqrt(n); i++) {
			if (n%i == 0) { return false; }
		}
		return true;
	}
}