import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, Min;
	static int[][] map;
	static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][][] visited;
	static ArrayList<position> wall;

	static class position {
		int row;
		int col;
		int crush;
		int distance;

		public position(int row, int col, int crush, int distance) {
			super();
			this.row = row;
			this.col = col;
			this.crush = crush;
			this.distance = distance;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Min = Integer.MAX_VALUE;
		map = new int[N + 1][M + 1];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i + 1][j + 1] = str.charAt(j) - '0';
			}
		}

		visited = new boolean[N + 1][M + 1][2];

		System.out.println(dfs(1, 1));

	}

	static int dfs(int r, int c) {
		Queue<position> queue = new LinkedList<>();
		queue.add(new position(r, c, 0, 1));
		visited[r][c][0] = true;
		visited[r][c][1] = true;

		while (!queue.isEmpty()) {
			position pos = queue.poll();
			if (pos.row == N && pos.col == M) {
				return pos.distance;
			}
			for (int i = 0; i < 4; i++) {
				int newR = pos.row + move[i][0];
				int newC = pos.col + move[i][1];

				if (newR > N || newC > M || newR < 1 || newC < 1) {
					continue;
				}
				if (map[newR][newC] == 0) {
					if (!visited[newR][newC][pos.crush]) {
						visited[newR][newC][pos.crush] = true;
						queue.add(new position(newR, newC, pos.crush, pos.distance + 1));
					}
				} else if (map[newR][newC] == 1) {
					if (!visited[newR][newC][1] && pos.crush == 0) {
						visited[newR][newC][1] = true;
						queue.add(new position(newR, newC, 1, pos.distance + 1));
					}
				}
			}
		}
		return -1;
	}

}
