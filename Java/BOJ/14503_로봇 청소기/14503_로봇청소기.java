import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	static int N, M, r, c, d;
	static int[][] map;
	static boolean[][] visited;
	static int[][] move = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 세로크기 N과 가로 크기 M 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		// 로봇 청소기가 있는 칸 (r,c)와 바라보는 방향 d 입력 (북, 동, 서, 남)
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		// 장소의 상태 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		clean(r, c);

		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j])
					answer++;
			}
		}
		System.out.println(answer);
	}

	static void clean(int r, int c) {

		// 현재 위치 청소
		visited[r][c] = true;
		int cnt = 0;
		while (true) {

			d = turnD(d);

			// a-1. 현재 위치의 왼쪽에 청소하지 않은 빈 공간이 존재하면, 왼쪽으로 회전후 전진 -> 청소
			if (chk(r + move[d][0], c + move[d][1]) && map[r + move[d][0]][c + move[d][1]] == 0
					&& !visited[r + move[d][0]][c + move[d][1]]) {
				cnt = 0;
				r = r + move[d][0];
				c = c + move[d][1];
				visited[r][c] = true;
			}
			// a-2. 현재 위치의 왼쪽에 청소하지 않은 빈 공간이 존재하지 않는다면, 왼쪽으로 회전
			else if (map[r + move[d][0]][c + move[d][1]] != 0 || visited[r + move[d][0]][c + move[d][1]]) {
				cnt++;
			}
			// a-2가 연속 4번 실행되었을 경우 바로 뒤가 벽이라면 stop
			if (cnt == 4) {
				int nr = 0;
				int nc = 0;
				if (d == 0 || d == 1) { // 후진할 위치
					nr = r + move[d + 2][0];
					nc = c + move[d + 2][1];
				} else {
					nr = r + move[d - 2][0];
					nc = c + move[d - 2][1];
				}
				if (!chk(nr, nc) || map[nr][nc] == 1) {
					return;
				}
				// " 벽이 아니라면 후진
				else {
					r = nr;
					c = nc;
					cnt = 0;
				}
			}
		}

	}

	static boolean chk(int r, int c) {
		if (r >= N || c >= M || r < 0 || c < 0)
			return false;
		return true;
	}

	static int turnD(int d) {
		int newD = 0;
		if (d - 1 >= 4) {
			newD = (d - 1) % 4;
		} else if (d - 1 < 0) {
			newD = (d + 4 - 1) % 4;
		} else {
			newD = d - 1;
		}
		return newD;
	}
}
