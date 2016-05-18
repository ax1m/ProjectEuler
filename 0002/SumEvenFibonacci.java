public class SumEvenFibonacci {
	public static void main(String[] args) {
		int arg = Integer.parseInt(args[0]);
		int fib0 = 1;
		int fib1 = 1;
		int fibN = fib0 + fib1;
		int sum = 0;
		while (fibN <= arg) {
			if (fibN%2 == 0) { sum += fibN; }
			fib0 = fib1;
			fib1 = fibN;
			fibN = fib0 + fib1;
		}
		System.out.println(sum);
	}
}