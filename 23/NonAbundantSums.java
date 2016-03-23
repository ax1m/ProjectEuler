import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class NonAbundantSums {
	public static void main(String[] args) {
		List<Integer> abundantNums = new ArrayList<Integer>();
		Set<Integer> abundantSums = new HashSet<Integer>();
		for(int i = 1; i <= 28123; i++) {
			if(isAbundant(i)) { abundantNums.add(i); }
		}
		for(int i : abundantNums) {
			for(int j : abundantNums) {
				abundantSums.add(i + j);
			}
		}
		int sum = 0;
		for(int i = 0; i <= 28123; i++) {
			if(!abundantSums.contains(i)) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

	public static boolean isAbundant(int num) {
		int sum = 0;
		for(int i = 1; i <= num / 2; i++) {
			if(num % i == 0) { sum += i; }
		}
		return sum > num;
	}
}