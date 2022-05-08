import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] ch = { 'd', 'r', 'i', 'i', 'p' };
		boolean flag = true;

		if (str.length() <= 5) {
			flag = false;
		} else {
			for (int i = str.length() - 5, r = 0; i < str.length(); i++, r++) {
				if (ch[r] != str.charAt(i))
					flag = false;
			}
		}
		if (flag)
			System.out.println("cute");
		else
			System.out.println("not cute");
	}
}
