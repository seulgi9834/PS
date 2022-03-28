import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] map;
	static int[][] dp;
	static int n, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];
		dp = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				answer = Math.max(answer, dfs(i, j));
			}
		}
		System.out.println(answer);
	}

	static int dfs(int row, int col) {
		if (dp[row][col] != 0) {
			return dp[row][col];
		}
		dp[row][col] = 1;

		for (int i = 0; i < 4; i++) {
			int nR = row + move[i][0];
			int nC = col + move[i][1];
			if (nR < 1 || nC < 1 || nR > n || nC > n) {
				continue;
			}
			if (map[nR][nC] > map[row][col]) {
				dp[row][col] = Math.max(dp[row][col], dfs(nR, nC) + 1);
				dfs(nR, nC);
			}
		}
		return dp[row][col];
	}
}
