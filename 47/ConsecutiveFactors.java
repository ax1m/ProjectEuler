import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConsecutiveFactors {

	private static Map<Integer, Map<Integer, Integer>> factorMap = new HashMap<Integer, Map<Integer, Integer>>();

	public static void main(String[] args) {
		int arg;
		if(args.length == 0) { arg = 4; }
		else { arg = Integer.parseInt(args[0]); }
		boolean resultFound = false;
		int num = 0;
		while(!resultFound) {
			num++;
			factorMap.put(num, primeFactors(num));
			System.out.println(printFactorization(num));
			if(num >= arg) {
				Set<Map<Integer, Integer>> factorizations = new HashSet<Map<Integer, Integer>>();
				for(int i = 0; i < arg; i++) {
					factorizations.add(factorMap.get(num - i));
				}
				boolean unique = false;
				// TODO -- Add logic
				if(unique) {
					resultFound = true;
					for(int i = num; i < num + arg; i++) {
						System.out.println(printFactorization(i));
					}
				}
			}
		}
	}

	public static Map<Integer, Integer> primeFactors(int num) { return primeFactors(num, 2); }

	public static Map<Integer, Integer> primeFactors(int num, int div) {
		if(factorMap.containsKey(num)) { return factorMap.get(num); }
		Map<Integer, Integer> res = new HashMap<Integer, Integer>();
		if(num < 0) { num *= -1; res.put(-1, 1); }
		if(num == 0) { res.put(0, 1); return res; }
		if(num == 1) { return res; }
		while((div < num) && !(num % div == 0)) { div++; }
		if(div < num) { num /= div; res = primeFactors(num, div); }
		res.put(div, res.containsKey(div) ? res.get(div) + 1 : 1);
		return res;
	}

	public static String printFactorization(int num) {
		Map<Integer, Integer> fac = factorMap.get(num);
		String res = num + " = ";
		Integer[] keys = fac.keySet().toArray(new Integer[fac.size()]);
		Arrays.sort(keys);
		for(int i : keys) { res += i + ((fac.get(i) > 1) ? " ^ " + fac.get(i) : "") + " * "; }
		res = res.substring(0, res.length() - 3);
		return res;
	}
}
