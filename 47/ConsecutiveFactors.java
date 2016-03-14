import java.util.Arrays;
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
			factorization.put(num, primeFactors(num));
			System.out.println((num) + " = " + printFactorization(factorization.get(num)));
			if(num >= arg) {
				Set<Map<Integer, Integer>> factorizations = new HashSet<Map<Integer, Integer>>();
				for(int i = 0; i < arg; i++) {
					factorizations.add(factorization.get(num - i));
				}
				boolean unique = false;
				// TODO -- Add logic
				if(unique) {
					resultFound = true;
					for(int i = num; i < num + arg; i++) {
						System.out.println(i + " = " + printFactorization(factorization.get(i)));
					}
				}
			}
		}
	}

	public static Map<Integer, Integer> primeFactors(int number) {
		Map<Integer, Integer> res = new HashMap<Integer, Integer>();
		int _number = number;
		for(int i = 2; i < _number; i++) {
			int count = 0;
			while(number % i == 0) {
				number /= i;
				count++;
			}
			if(count > 0) { res.put(i, count); }
		}
		return res;
	}

	public static String printFactorization(Map<Integer, Integer> fac) {
		String res = "";
		if(fac.isEmpty()) { res = "PRIME"; }
		else {
			Integer[] keys = fac.keySet().toArray(new Integer[fac.size()]);
			Arrays.sort(keys);
			for(int i : keys) { res += i + " ^ " + fac.get(i) + " * "; }
			res = res.substring(0, res.length() - 3);
		}
		return res;
	}
}
