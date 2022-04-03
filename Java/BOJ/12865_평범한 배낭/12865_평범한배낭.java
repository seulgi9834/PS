import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, V;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N + 1][V + 1];
		int[] w = new int[N + 1];
		int[] p = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= N; j++) {
				dp[j][i] = dp[j - 1][i];
				if (i - w[j] >= 0) {
					dp[j][i] = Math.max(dp[j - 1][i - w[j]] + p[j], dp[j - 1][i]);
				}
			}
		}
		System.out.println(dp[N][V]);
	}
}
