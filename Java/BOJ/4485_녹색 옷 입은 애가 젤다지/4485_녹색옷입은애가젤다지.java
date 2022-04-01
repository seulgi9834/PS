import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, test_case;
	static int[][] map;
	static int[][] distance;
	static boolean[][] visited;
	static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static class position implements Comparable<position> {
		int row;
		int col;
		int cost;

		public position(int row, int col, int cost) {
			super();
			this.row = row;
			this.col = col;
			this.cost = cost;
		}

		@Override
		public int compareTo(position o) {
			return cost - o.cost;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		test_case = 0;
		while (true) {
			test_case++;
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			map = new int[N][N];
			distance = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					distance[i][j] = Integer.MAX_VALUE;
				}
			}

			sb.append("Problem " + test_case + ": " + bfs() + "\n");
		}
		System.out.println(sb);
	}

	static int bfs() {
		PriorityQueue<position> queue = new PriorityQueue<>();
		distance[0][0] = map[0][0];
		queue.add(new position(0, 0, distance[0][0]));
		visited[0][0] = true;
		while (!queue.isEmpty()) {
			position pos = queue.poll();
			int r = pos.row;
			int c = pos.col;
			int d = pos.cost;
			for (int i = 0; i < 4; i++) {
				int nRow = r + move[i][0];
				int nCol = c + move[i][1];
				if (nRow >= N || nCol >= N || nRow < 0 || nCol < 0)
					continue;
				if (!visited[nRow][nCol]) {
					distance[nRow][nCol] = Math.min(d + map[nRow][nCol], distance[nRow][nCol]);
					queue.add(new position(nRow, nCol, distance[nRow][nCol]));
					visited[nRow][nCol] = true;
				}
			}
		}
		return distance[N - 1][N - 1];
	}
}
