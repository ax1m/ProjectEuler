public class PythagoreanTriplet {
	public static void main(String[] args) {
		int arg=1000;
		for (int a=1; a<arg; a++) {
			for (int b=a+1; b<arg; b++) {
				for (int c=b+1; c<arg; c++) {
					if ((a*a + b*b == c*c) && (a+b+c == arg)) {
						System.out.println(String.format("a == %d;   b == %2d;   c == %3d", a, b, c));
						System.out.println("a * b * c == " + a * b * c);
						return;
					}
				}
			}
		}
	}
}