import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

	static String str;
	static HashSet<String> strList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		strList = new HashSet<>();

		for (int i = 0; i < str.length(); i++) {
			for (int r = i + 1; r <= str.length(); r++) {
				if (!strList.contains(str.substring(i, r)))
					strList.add(str.substring(i, r));
			}
		}
		System.out.println(strList.size());
	}

}
