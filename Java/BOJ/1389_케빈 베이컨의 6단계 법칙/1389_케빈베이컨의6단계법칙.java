import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = 5001;
				if (i == j)
					map[i][j] = 0;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}

		for (int r = 1; r <= N; r++) {// 경
			for (int i = 1; i <= N; i++) {// 출
				for (int j = 1; j <= N; j++) { // 도
					if (map[i][r] + map[r][j] < map[i][j]) {
						map[i][j] = map[i][r] + map[r][j];
					}
				}
			}
		}

		int idx = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 1; i <= N; i++) {
			int temp = 0;
			for (int j = 1; j <= N; j++) {
				temp += map[i][j];
			}
			if (temp < min) {
				min = temp;
				idx = i;
			} else if (temp == min) {
				if (i < idx)
					idx = i;
			}
		}

		System.out.println(idx);
	}
}
