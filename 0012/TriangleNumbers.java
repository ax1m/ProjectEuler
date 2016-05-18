import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


public class TriangleNumbers {


	public static void main(String[] args) {
		long t0 = System.currentTimeMillis();
		int arg;
		if (args.length>0) { arg = Integer.parseInt(args[0]); }
		else { arg = 500; }
		long triangle = 1;
		int index = 1;
		TriangleNumbers t = new TriangleNumbers();
		while (t.properDivisors(triangle).size()<arg) { triangle += ++index; }
		System.out.println(triangle);
		System.out.println("At position " + index);
		String timeString = "Finished in %d milliseconds";
		System.out.println(String.format(timeString, System.currentTimeMillis()-t0));
	}

	private static Set<Integer> properDivisors(long num) {
		Set<Integer> divs = new HashSet<Integer>();
		for (int i=1; i<=num/2; i++) { if (num%i==0) { divs.add(i); } }
		return divs;
	}
}