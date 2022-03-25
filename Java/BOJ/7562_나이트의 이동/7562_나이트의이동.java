import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class position {
		int row;
		int col;

		public position(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

	}

	static int T, l;
	static int[][] map;
	static int[][] move = { { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 }, { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 0; test_case < T; test_case++) {
			l = Integer.parseInt(br.readLine());
			map = new int[l][l];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start_r = Integer.parseInt(st.nextToken());
			int start_c = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int end_r = Integer.parseInt(st.nextToken());
			int end_c = Integer.parseInt(st.nextToken());
			sb.append(bfs(start_r, start_c, end_r, end_c) + "\n");
		}
		System.out.println(sb);
	}

	static int bfs(int sr, int sc, int er, int ec) {
		boolean[][] visited = new boolean[l][l];
		Queue<position> queue = new LinkedList<>();
		queue.add(new position(sr, sc));
		visited[sr][sc] = true;
		while (!queue.isEmpty()) {
			position pos = queue.poll();
			int r = pos.row;
			int c = pos.col;
			if (r == er && c == ec) {
				queue.clear();
				return map[r][c];
			}
			for (int i = 0; i < 8; i++) {
				int nr = r + move[i][0];
				int nc = c + move[i][1];
				if (nr >= l || nc >= l || nr < 0 || nc < 0)
					continue;
				if (!visited[nr][nc]) {
					queue.add(new position(nr, nc));
					map[nr][nc] = map[r][c] + 1;
					visited[nr][nc] = true;

				}
			}
		}
		queue.clear();
		return map[er][ec];
	}
}
