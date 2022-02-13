import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int[][] move = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // 우, 하, 좌, 상
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int r = 0; r < M; r++) {
				arr[i][r] = Integer.parseInt(st.nextToken());
			}
		}

		int min = Integer.min(N / 2, M / 2);

		for (int i = 0; i < R; i++) {
			for (int r = 0; r < min; r++) {
				int stx = r;
				int sty = r;
				int dir = 0; // 우, 하, 좌, 상

				int start = arr[stx][sty];

				while (dir < 4) {
					int nx = stx + move[dir][0];
					int ny = sty + move[dir][1];

					if (nx >= r && nx < N - r && ny >= r && ny < M - r) {
						arr[stx][sty] = arr[nx][ny];
						stx = nx;
						sty = ny;
					} else {
						dir++;
					}
				}
				arr[r + 1][r] = start;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int r = 0; r < M; r++) {
				sb.append(arr[i][r]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
