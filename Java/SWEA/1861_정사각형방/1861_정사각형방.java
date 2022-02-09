import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[][] room;
	static int[][] cnt;

	static int N, min, max, mr, mc;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			min = Integer.MAX_VALUE;
			max = 0;
			room = new int[N][N];
			cnt = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int r = 0; r < N; r++) {
					room[i][r] = Integer.parseInt(st.nextToken());
				}
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					cnt[r][c] = search(r, c, 1);
					if (cnt[r][c] > max) {
						max = cnt[r][c];
						min = room[r][c];
					} else if (cnt[r][c] == max && min > room[r][c]) {
						min = room[r][c];
					}

				}
			}
			sb.append("#").append(test_case).append(" ").append(min).append(" ").append(max).append("\n");

		}

		System.out.println(sb);
	}

	static int search(int x, int y, int cnt) {
		int[][] search = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우
		for (int i = 0; i < search.length; i++) {
			int nr = x + search[i][0]; // 행
			int nc = y + search[i][1]; // 열
			if (nr >= N || nr < 0) {
				continue;
			}
			if (nc >= N || nc < 0) {
				continue;
			}
				if (room[x][y] + 1 == room[nr][nc]) {
					cnt++;
					cnt = search(nr, nc, cnt);
				}
			}
		return cnt;
	}
}
