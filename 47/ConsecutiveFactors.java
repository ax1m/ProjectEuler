import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			if(num >= arg) {
				boolean unique = true;
				for(int i = 0; i < arg; i++) {
					unique = (factorMap.get(num - i).size() == arg) ? unique : false;
					if(!unique) { break; }
					for(int j = i + 1; j < arg; j++) {
						if(!fullyDistinct(factorMap.get(num - i), factorMap.get(num - (i + j)))) {
							unique = false;
							break;
						}
					}
				}
				if(unique) {
					resultFound = true;
					for(int i = num - arg; i < num; i++) {
						System.out.println(printFactorization(i + 1));
					}
				}
			}
		}
	}

	public static boolean fullyDistinct(Map<Integer, Integer> facA, Map<Integer, Integer> facB) {
		boolean res = true;
		for(int factor : facA.keySet()) {
			if(facB.containsKey(factor) && facA.get(factor) == facB.get(factor)) {
				res = false;
				break;
			}
		}
		return res;
	}

	public static Map<Integer, Integer> primeFactors(int num) { return primeFactors(num, 2); }

	public static Map<Integer, Integer> primeFactors(int num, int div) {
		Map<Integer, Integer> res = new HashMap<Integer, Integer>();
		if(factorMap.containsKey(num)) { res.putAll(factorMap.get(num)); return res; }
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
