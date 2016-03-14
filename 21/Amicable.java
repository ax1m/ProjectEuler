import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Amicable {
	public static void main(String[] args) {
		long t0 = System.currentTimeMillis();
		int arg;
		if (args.length>0) {
			arg = Integer.parseInt(args[0]);
		} else {
			arg = 10000;
		}
		int[] numbers = amicableNums(arg);
		System.out.println(String.format("Amicable numbres up to %d:", arg));
		System.out.println(Arrays.toString(numbers));
		System.out.println("Sum: " + IntStream.of(numbers).sum());
		System.out.println(String.format("Finished after %d milliseconds", System.currentTimeMillis()-t0));
	}

	private static int[] amicableNums(int range) {
		Set<Integer> numbers = new HashSet<Integer>();
		for (int i=1; i<=range; i++) {
			int j = IntStream.of(properDivisors(i)).sum();
			if (i==j || numbers.contains(j)) { continue; }
			else if (isAmicable(i)){
				numbers.add(i);
				numbers.add(j);
			}
		}
		int[] res = toArray(numbers);
		Arrays.sort(res);
		return res;
	} // Returns an array of all amicable numbers between 0 and range

	private static boolean isAmicable(int numA) {
		int[] divA = properDivisors(numA);
		int sumA = IntStream.of(divA).sum();
		int[] divB = properDivisors(sumA);
		int sumB = IntStream.of(divB).sum();
		return numA==sumB;
	} // Returns whether numA and numB are amicable numbers

	private static int[] properDivisors(int n) {
		if (n==0) {
			int[] res = new int[1];
			res[0] = 0;
			return res;
		}
		Set<Integer> resSet = new HashSet<Integer>();
		for (int i=1; i<n; i++) {
			if (n%i==0) {
				resSet.add(i);
			}
		}
		return toArray(resSet);
	} // Returns an array of all integers < n that are proper divisors of n

	private static int[] toArray(Collection<Integer> set) {
		int[] res = new int[set.size()];
		int i = 0;
		for (int number : set) {
			res[i++] = number;
		}
		return res;
	} // Converts a Collection of Integers to an int array
}