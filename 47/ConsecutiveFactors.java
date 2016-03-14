import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConsecutiveFactors {
	public static void main(String[] args) {
		int arg;
		if(args.length == 0) { arg = 4; }
		else { arg = Integer.parseInt(args[0]); }
		Map<Integer, Map<Integer, Integer>> factorization = new HashMap<Integer, Map<Integer, Integer>>();
		boolean resultFound = false;
		int num = 0;
		while(!resultFound) {
			num++;
			factorization.put(num, factors(num));
			if(num >= arg) {
				Set<Map<Integer, Integer>> factorizations = new HashSet<Map<Integer, Integer>>();
				for(int i = 0; i < arg; i++) {
					factorizations.add(factorization.get(num - i));
				}
				if(factorizations.size() == arg) {
					resultFound = true;
					System.out.println(num - (arg-1));
				}
			}
		}
	}

	public static Map<Integer, Integer> factors(int number) {
		Map<Integer, Integer> res = new HashMap<Integer, Integer>();
		for(int i = 2; i < Math.sqrt(number); i++) {
			int count = 0;
			while(number % i == 0) {
				number /= i;
				count++;
			}
			if(count > 0) { res.put(i, count); }
		}
		if(res.size() == 0) { res.put(number, 1); }
		return res;
	}
}
