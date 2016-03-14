public class Divisible {
	public static void main(String[] args) {
		int arg = Integer.parseInt(args[0]);
		boolean divByAll = false;
		int next = 0;
		while (!divByAll) {
			next++;
			for (int i = 1; i<=arg; i++) {
				if (next%i == 0) {
					divByAll = true;
				} else {
					divByAll = false;
					break;
				}
			}
		}
		System.out.println(next);
		return;
	}
}