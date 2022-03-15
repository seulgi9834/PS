import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, sec;
	static int[][] map;
	static int[] command;
	static int[][] move = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } }; // 상좌하우
	static ArrayList<position> snake;

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

		N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1]; // (1,1)부터 시작

		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			map[r][j] = 1; // 사과
		}

		int L = Integer.parseInt(br.readLine());
		command = new int[10001];
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			if (st.nextToken().charAt(0) == 'L') {
				command[r] = 1;
			} else {
				command[r] = -1;
			}
		}

		snake = new ArrayList<>();
		sec = 0;
		snake.add(new position(1, 1));
		snake_move(1, 1);

		System.out.println(sec);

	}

	static void snake_move(int row, int col) {
		int dir = 3;
		while (true) {
			sec++;
			int newrow = row + move[dir][0];
			int newcol = col + move[dir][1];
			if (!chk(newrow, newcol)) {
				return;
			}
			if (map[newrow][newcol] == 1) {
				snake.add(new position(newrow, newcol));
				map[newrow][newcol] = 0;
			} else {
				snake.add(new position(newrow, newcol));
				snake.remove(0);
			}
			row = newrow;
			col = newcol;

			dir = (dir + command[sec]) % 4;
			if(dir==-1) dir=3;

		}
	}

	static boolean chk(int r, int c) {

		if (r < 1 || r > N || c < 1 || c > N) {
			return false;
		}
		for (int i = 0; i < snake.size(); i++) {
			if (snake.get(i).row == r && snake.get(i).col == c) {
				return false;
			}
		}
		return true;
	}
}
