public class Palindrom {
	public static void main(String[] args) { 
		int arg = Integer.parseInt(args[0]);
		int largest = 0;
		int fac1 = 0;
		int fac2 = 0;
		for (int i=1; i<Math.pow(10, arg); i++) {
			for (int j=1; j<Math.pow(10, arg); j++) {
				int candidate = i*j;
				if (candidate > largest) {
					String candStr = Integer.toString(candidate);
					String reverse = new StringBuffer(candStr).reverse().toString();
					if (candStr.equals(reverse)) {
						largest = candidate;
						fac1 = i;
						fac2 = j;
					}
				}
			}
		}
		System.out.println(String.format("%d * %2d =", fac1, fac2));
		System.out.println(largest);
	}
}