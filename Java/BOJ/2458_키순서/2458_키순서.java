import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] student;
	static boolean[] visited;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		student = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			student[a][b] = 1;
		}

		for (int k = 1; k <= N; k++) { // 경유하는 학생
			for (int i = 1; i <= N; i++) { // 시작하는 학생
				if (i == k)
					continue;
				for (int j = 1; j <= N; j++) { // 도착하는 학생
					// if(i==j) continue;
					if (student[i][j] == 1)
						continue;
					if (student[i][k] == 1 && student[k][j] == 1) {
						student[i][j] = 1;
					}
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				student[i][0] += student[i][j];
				student[0][j] += student[i][j];
			}
		}

		int answer = 0;
		for (int i = 1; i <= N; i++) {
			if (student[i][0] + student[0][i] == N - 1)
				answer++;
		}
		System.out.println(answer);
	}
}
