import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RightTriangles {
	public static void main(String[] args) {
		int arg;
		Map<Integer, Set<Integer[]>> triangleCount = new HashMap<Integer, Set<Integer[]>>();
		if(args.length == 0) { arg = 1000; }
		else { arg = Integer.parseInt(args[0]); }
		for(int number = 3; number <= arg; number++) {
			Set<Integer[]> triangles = new HashSet<Integer[]>();
			for(int a = 1; a < (number / 2.0F); a++) {
				for(int b = 1; b < (number / 2.0F); b++) {
					int c = number - (a + b);
					if(a*a + b*b == c*c) {
						triangles.add(new Integer[]{a, b, c});
					}
				}
			}
			triangleCount.put(number, triangles);
		}
		int max = 0;
		int maxVal = 0;
		for(int key : triangleCount.keySet()) {
			int count = triangleCount.get(key).size();
			if(count > maxVal) {
				max = key;
				maxVal = count;
			}
		}
		System.out.println("Max triangles: " + maxVal + " at p = " + max);
		for(Integer[] triangle : triangleCount.get(max)) {
			System.out.println(Arrays.toString(triangle));
		}
	}
}