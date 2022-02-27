import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int R = Integer.MIN_VALUE;
		for (int i = 1; i <= Math.sqrt(str.length()); i++) {
			if (str.length() % i == 0) {
				R = Math.max(R, i);
			}
		}
		int C = str.length() / R;

		char[][] arr = new char[R][C];
		int cnt = 0;

		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				arr[j][i] = str.charAt(cnt);
				cnt++;
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(arr[i][j]);
			}
		}

	}
}
