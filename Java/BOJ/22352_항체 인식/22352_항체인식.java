import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] SP; // SP 촬영 결과
	static int[][] CP; // 백신 후 촬영
	static boolean[][] visited; // 방문 확인
	static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N, M, num, vacNum;

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
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		SP = new int[N][M];
		CP = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				SP[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				CP[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean flag = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (SP[i][j] != CP[i][j] && !flag) {
					vacNum = CP[i][j];
					num = SP[i][j];
					vaccine(i, j);
					SP[i][j] = vacNum;
					flag = true;
				}
			}
		}

		String answer = "YES";
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (SP[i][j] != CP[i][j]) {
					answer = "NO";
					break;
				}
			}
		}
		System.out.println(answer);
	}

	static void vaccine(int r, int c) {
		Queue<position> queue = new LinkedList<>();
		queue.add(new position(r, c));
		visited[r][c] = true;
		
		while (!queue.isEmpty()) {
			position ps = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int row = ps.row;
				int col = ps.col;
				int newRow = row + move[i][0];
				int newCol = col + move[i][1];
				
				if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < M) {
					
					if (SP[newRow][newCol] == num && !visited[newRow][newCol]) {
						queue.add(new position(newRow, newCol));
						SP[newRow][newCol] = vacNum;
						visited[newRow][newCol] = true;
					}
					
				}

			}
		}

	}

}
