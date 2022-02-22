import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, cnt, answer;
	static int[][] arr;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		answer = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int r = 0; r < N; r++) {
				arr[i][r] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			tsp(i, i, 0, 0);
		}
		System.out.println(answer);
	}

	public static void tsp(int start, int init, int cnt, int sum) {
		if (cnt == N && sum > 0 && start == init) {
			answer = Math.min(answer, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (arr[start][i] == 0) { // 갈 수 x
				continue;
			}
			if (!visited[i]) {
				visited[i] = true;
				tsp(i, init, cnt + 1, sum + arr[start][i]);
				visited[i] = false;
			}

		}

	}
}
