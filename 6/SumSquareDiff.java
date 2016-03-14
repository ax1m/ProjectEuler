public class SumSquareDiff {
	public static void main(String[] args) {
		int arg = Integer.parseInt(args[0]);
		int sum = 0;
		int squareSum = 0;
		for (int i=1; i<=arg; i++) {
			sum += i;
			squareSum += Math.pow(i, 2);
		}
		int sumSquare = ((int)Math.pow(sum, 2));
		System.out.println(squareSum);
		System.out.println(sumSquare);
		System.out.println(sumSquare - squareSum);
	}
}
