public class NthPrime {
	public static void main(String[] args) {
		int arg = Integer.parseInt(args[0]);
		int n = 1;
		long nth = 2;
		while (n<arg) {
			for (long i=nth+1; i<2*nth; i++) {
				if (isPrime(i)) {
					nth = i;
					n++;
					break;
				}
			}
		}
		String out = "Prime(%d) is %2d";
		System.out.println(String.format(out, n, nth));
	}

	private static boolean isPrime(long n) {
		for (int i=2; i<=Math.sqrt(n); i++) {
			if (n%i==0) { return false; }
		}
		return true;
	}
}

