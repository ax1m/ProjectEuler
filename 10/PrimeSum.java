import java.util.Arrays;
import java.util.stream.LongStream;
import java.util.HashSet;
import java.util.Set;
import java.util.Collection;

public class PrimeSum {
	public static void main(String[] args) {
		int arg = Integer.parseInt(args[0]);
		Set<Integer> res = new HashSet<Integer>();
		for (int i=2; i<arg; i++) {
			if (isPrime(i)) { res.add(i); }
		}
		long[] resArr = toArray(res);
		System.out.println(Arrays.toString(resArr));
		System.out.println("Sum = " + LongStream.of(resArr).sum());
		return;
	}

	private static boolean isPrime(int n) {
		for (int i=2; i<=Math.sqrt(n); i++) {
			if (n%i==0) { return false; }
		}
		return true;
	}

	private static long[] toArray(Collection<Integer> nums) {
		long[] res = new long[nums.size()];
		int i = 0;
		for (int num : nums) {
			res[i++] = (long)num;
		}
		return res;
	}
}
