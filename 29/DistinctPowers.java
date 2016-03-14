import java.math.BigInteger;
import java.util.HashSet;

public class DistinctPowers {
	public static void main(String[] args) {
		HashSet<BigInteger> powers = new HashSet<BigInteger>();
		for (int i=2; i<=100; i++) {
			for (int j=2; j<=100; j++) {
				powers.add(new BigInteger(Integer.toString(i)).pow(j));
			}
		}
		System.out.println(powers.size());
	}
}