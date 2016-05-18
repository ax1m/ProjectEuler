public class CountingSundays {

	private static int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static int weekday = 1;
	private static int monthday = 1;
	private static int month = 1;
	private static int year = 1900;
	private static int count = 0;

	public static void main(String[] args) {
		while(year < 2001) {
			if(year > 1900 && monthday == 1 && weekday == 7) { count++; }
			nextDay();
		}
		System.out.println(count);
	}

	public static boolean isLeapYear(int year) {
		return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
	}

	public static int getDays(int month, int year) {
		return days[month - 1] + (month == 2 && isLeapYear(year) ? 1 : 0);
	}

	public static void nextDay() {
		if(weekday == 7) { weekday = 1; }
		else { weekday++; }
		if(monthday == days[month - 1]) { monthday = 1; month++; }
		else { monthday++; }
		if(month == 13) { month = 1; year++; }
	}
}