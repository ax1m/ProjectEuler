import java.math.BigInteger;

public class FactorialDigitSum {
	public static void main(String[] args) {
		int arg = Integer.parseInt(args[0]);
		int sum = 0;
		String facString = factorial(arg).toString();
		for (int i=0; i<facString.length(); i++) {
			sum += Integer.parseInt(""+facString.charAt(i));
		}
		System.out.println(sum);
	}

	public static BigInteger factorial(int n) {
		BigInteger bigN = new BigInteger(Integer.toString(n));
		if (n==1) { return new BigInteger("1"); }
		else { return bigN.multiply(factorial(n-1)); }
	}
}