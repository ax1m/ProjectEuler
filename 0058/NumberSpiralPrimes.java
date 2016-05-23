public class NumberSpiralPrimes {
	public static void main(String[] args) {
		int total = 1;
		int primes = 0;
		int number = 1;
		int i = 0;
		while(primes*10 >= total || number == 1) {
			i += 2;
			for(int j=0; j<4; j++) {
				number += i;
				total++;
				if(isPrime(number)) primes++;
			}
		}
		System.out.println("Side length: " + (i+1));
	}

	public static boolean isPrime(long n) {
		for (int i=2; i <= Math.sqrt(n); i++) {
			if (n%i == 0) { return false; }
		}
		return true;
	}
}