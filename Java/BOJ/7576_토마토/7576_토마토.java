import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int M, N;
	static int[][] box;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우
	static Queue<position> queue;

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
		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로
		box = new int[N][M];
		queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) {
					queue.add(new position(i, j));
				}
			}
		}

		bfs();

		boolean chk = true;
		int day = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) {
					chk = false;
				} else {
					day = Math.max(day, box[i][j]);
				}
			}
		}
		if (day == 1) {
			System.out.println(0);
		} else if (!chk) {
			System.out.println(-1);
		} else {
			System.out.println(day - 1);
		}
	}

	static void bfs() {
		while (!queue.isEmpty()) {
			position pos = queue.poll();
			int row = pos.row;
			int col = pos.col;

			for (int i = 0; i < dir.length; i++) {
				int newRow = row + dir[i][0];
				int newCol = col + dir[i][1];
				if (newRow >= 0 && newCol >= 0 && newRow < N && newCol < M) {
					if (box[newRow][newCol] == 0) {
						queue.add(new position(newRow, newCol));
						box[newRow][newCol] = box[row][col] + 1;
					}
				}
			}

		}
	}
}
