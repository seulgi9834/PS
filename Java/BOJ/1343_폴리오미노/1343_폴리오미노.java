import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1343_폴리오미노 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		boolean chk = true;
		str = str.replace("XXXX", "AAAA");
		str = str.replace("XX", "BB");

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'X') {
				chk = false;
			}
		}

		if (chk)
			System.out.println(str);
		else
			System.out.println("-1");
	}
}
