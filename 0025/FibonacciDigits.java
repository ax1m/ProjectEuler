import java.math.BigInteger;

public class FibonacciDigits {
	public static void main(String[] args) {
		int arg = Integer.parseInt(args[0]);
		BigInteger fib0 = new BigInteger("1");
		BigInteger fib1 = new BigInteger("1");
		BigInteger next = fib0.add(fib1);
		int count = 3;
		while (next.toString().length() < arg) {
			fib0 = new BigInteger(fib1.toString());
			fib1 = new BigInteger(next.toString());
			next = fib0.add(fib1);
			count++;
		}
		System.out.println(next);
		System.out.println(count);
	}
}