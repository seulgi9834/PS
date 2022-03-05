import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static long[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		dp = new long[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == N - 1 && j == N - 1 && arr[i][j] == 0) {
					continue;
				} else {
					int newRow = i + arr[i][j];
					int newCol = j + arr[i][j];
					if (newRow < N) {
						dp[newRow][j] += dp[i][j];
					}
					if (newCol < N) {
						dp[i][newCol] += dp[i][j];
					}
				}
			}
		}
		System.out.println(dp[N - 1][N - 1]);

	}

}
