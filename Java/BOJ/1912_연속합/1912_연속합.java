import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		int[] dp = new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int answer = arr[1];
		dp[1] = arr[1];

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + arr[i];
			dp[i] = Integer.max(dp[i], arr[i]);
			answer = Integer.max(answer, dp[i]);
		}
		System.out.println(answer);
	}
}
