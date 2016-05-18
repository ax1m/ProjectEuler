import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NamesScores {
	public static void main(String[] args) {
		String arg;
		if(args.length == 0) { arg = "p022_names.txt"; }
		else { arg = args[0]; }
		String file;
		try {
			file = new Scanner(new File(arg)).useDelimiter("\\Z")
			.next().replace("\"", "");
		}
		catch(FileNotFoundException e) {
			System.out.println(e);
			return;
		}
		List<String> names = Arrays.asList(file.split(","));
		Collections.sort(names);
		long sum = 0;
		for(int i = 0; i < names.size(); i++) {
			sum += sumCharValue(names.get(i)) * (i + 1);
		}
		System.out.println(sum);
	}

	public static int sumCharValue(String str) {
		int res = 0;
		for(char c : str.toCharArray()) { res += c - 64; }
		return res;
	}
}
