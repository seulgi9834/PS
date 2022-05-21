import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = false;
		char[] chars = { 'U', 'C', 'P', 'C' };
		String str = br.readLine();

		int idx = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == chars[idx]) {
				idx++;
			}
			if (idx == 4) {
				flag = true;
				break;
			}
		}

		if (flag) {
			System.out.println("I love UCPC");
		} else {
			System.out.println("I hate UCPC");
		}
	}
}
