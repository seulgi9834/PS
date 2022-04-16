import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] ch = new char[5][10000];
		int size = 0;
		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			size = str.length();
			for (int j = 0; j < str.length(); j++) {
				ch[i][j] = str.charAt(j);
			}
		}
		String[] dance = new String[3];
		dance[0] = ".omln";
		dance[1] = "owln.";
		dance[2] = "..oLn";

		for (int i = 0; i < size; i++) {
			String temp = "";
			for (int j = 0; j < 5; j++) {
				temp += ch[j][i];
			}
			if (temp.equals(dance[0])) {
				for (int j = 0; j < 5; j++) {
					ch[j][i] = dance[1].charAt(j);
				}
			} else if (temp.equals(dance[1])) {
				for (int j = 0; j < 5; j++) {
					ch[j][i] = dance[0].charAt(j);
				}
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(ch[i][j]);
			}
			System.out.println();
		}
	}
}
