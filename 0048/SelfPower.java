import java.math.BigInteger;

public class SelfPower {
	public static void main(String[] args) {
		int arg;
		if(args.length == 0) { arg = 1000; }
		else { arg = Integer.valueOf(args[0]); }
		BigInteger res = BigInteger.valueOf(0);
		for(int i = 1; i <= arg; i++) {
			res = res.add(BigInteger.valueOf(i).pow(i));
		}
		System.out.println(res);
	}
}