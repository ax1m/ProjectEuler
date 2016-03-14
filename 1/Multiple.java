public class Multiple {
	public static void main(String[] args) {
		int arg = Integer.parseInt(args[0]);
		int sum = 0;
		for (int i=0; i<arg; i++) {
			if (i%3==0 || i%5==0) {
				sum += i;
			}
		}
		System.out.println(sum);
	}
}