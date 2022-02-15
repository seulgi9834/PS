import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int answer = Integer.MAX_VALUE;
		boolean chk = false;

		for (int i = 0; i < N; i++) {
			for (int r = 0; r < N; r++) {
				if (5 * i + 3 * r == N) {
					chk = true;
					answer = Integer.min(answer, i + r);
				}
			}
		}

		if (!chk) {
			System.out.println("-1");
		} else {
			System.out.println(answer);
		}
	}
}
