import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static int[] time;
	static int[][] map;
	static boolean[][] visited;
	static int[][] move = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	static class position {
		int row;
		int col;

		public position(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		time = new int[R * C]; // 시간에 따른 치즈 수 저장
		map = new int[R][C]; // 치즈 상태

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 치즈 상태 입력

		int cnt = 0; // 시간
		time[cnt] = countCheese(R, C);
		while (countCheese(R, C) != 0) {
			cnt++;
			bfs(0, 0); // 공기인 부분을 너비 우선 탐색하면서 치즈 제거
			time[cnt] = countCheese(R, C); // 시간에 따른 치즈 수 저장
		}

		System.out.println(cnt);
		System.out.println(time[cnt - 1]);
	}

	static void bfs(int row, int col) {
		Queue<position> queue = new LinkedList<>();
		visited = new boolean[R][C];
		queue.add(new position(row, col));
		visited[row][col] = true;

		while (!queue.isEmpty()) {
			position pos = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nR = pos.row + move[i][0];
				int nC = pos.col + move[i][1];
				if (nR >= R || nC >= C || nR < 0 || nC < 0)
					continue;
				if (visited[nR][nC])
					continue;
				if (map[nR][nC] == 1) {
					map[nR][nC] = 0;
				} else if (map[nR][nC] == 0) {
					queue.add(new position(nR, nC));
				}
				visited[nR][nC] = true;
			}
		}
	}

	static int countCheese(int row, int col) {
		int cheese = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (map[i][j] == 1) {
					cheese++;
				}
			}
		}
		return cheese;
	}

}
