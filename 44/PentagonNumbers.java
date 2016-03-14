public class PentagonNumbers {
	public static void main(String[] args) {
		int res = 0;
		boolean notFound = true;
		int i=1;
		while (notFound) {
			i++;
			int n = pentagon(i);
			for (int j=i-1; j>0; j--) {
				int m = pentagon(j);
				if (isPentagonal(n-m) && isPentagonal(n+m)) {
					res = n-m;
					notFound = false;
					break;
				}
			}
		}
		System.out.println(res);
	}

	public static boolean isPentagonal(int n) {
		double penTest = (Math.sqrt(1+24*n)+1.0)/6.0;
		return penTest == ((int)penTest);
	}

	public static int pentagon(int n) {
		return n*(3*n-1)/2;
	}
}