import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int[][] distance;
	static int move[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean visited[][];
	static int goalR, goalC, n, m;

	static class pos {
		int row;
		int col;

		public pos(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		distance = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					goalR = i;
					goalC = j;
				}
			}
		}

		bfs(goalR, goalC);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && distance[i][j] == 0) { // 문제 제대로 읽기!!!
					sb.append(-1 + " ");
				} else
					sb.append(distance[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void bfs(int row, int col) {
		Queue<pos> queue = new LinkedList<>();
		queue.add(new pos(row, col));
		visited[row][col] = true;

		while (!queue.isEmpty()) {
			pos position = queue.poll();
			for (int i = 0; i < 4; i++) {
				int newR = position.row + move[i][0];
				int newC = position.col + move[i][1];
				if (!chk(newR, newC))
					continue;
				distance[newR][newC] += distance[position.row][position.col] + 1;
				visited[newR][newC] = true;
				queue.add(new pos(newR, newC));
			}
		}
	}

	static boolean chk(int row, int col) {
		if (row < 0 || col < 0 || row >= n || col >= m)
			return false;
		if (visited[row][col])
			return false;
		if (map[row][col] == 0 || map[row][col] == 2)
			return false;
		return true;
	}
}
