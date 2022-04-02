import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{
	static char[][] map;
	static char[][] copy;
	static ArrayList<position> arr;
	static int N;
	static int[][] move = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };

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
		map = new char[N][N];
		copy = new char[N][N];
		int max = 0;
		position pos = new position(-1, -1);
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '.') {
					int tmp = search(i, j);

					if (cnt < tmp) {
						cnt = tmp;
						pos.row = i;
						pos.col = j;
					}
				}
			}
		}

		if (pos.row == -1 && pos.col == -1) {
			System.out.println("PASS");
		} else {
			System.out.println(pos.col + " " + pos.row);
			System.out.println(cnt);
		}

	}

	static int search(int r, int c) {
		int sum = 0;
		for (int i = 0; i < 8; i++) {
			int nr = r + move[i][0];
			int nc = c + move[i][1];
			int cnt = 0;
			boolean flag = true;
			while (flag) {
				if (!chk(nr, nc) || map[nr][nc] == '.') {
					flag = false;
				} else if (map[nr][nc] == 'B') {
					sum += cnt;
					flag = false;
				} else if (map[nr][nc] == 'W') {
					cnt++;
					nr += move[i][0];
					nc += move[i][1];
				}
			}
		}
		return sum;
	}

	static boolean chk(int nR, int nC) {
		if (nR >= N || nC >= N || nR < 0 || nC < 0) {
			return false;
		}
		return true;
	}
}
