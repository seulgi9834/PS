import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int[][] map;
	static ArrayList<point> pos;
	static boolean[] chk = new boolean[10];

	static class point {
		int row;
		int col;

		public point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		pos = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (map[i][j] == 0) {
					pos.add(new point(i, j));
				}
			}
		}
		search(0);

	}

	static void search(int depth) {
		if (depth == pos.size()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}

		for (int i = 1; i <= 9; i++) {
			if (check(pos.get(depth).row, pos.get(depth).col, i)) {
				map[pos.get(depth).row][pos.get(depth).col] = i;
				search(depth + 1);
				map[pos.get(depth).row][pos.get(depth).col] = 0;
			}
		}
	}

	static boolean check(int r, int c, int n) {
		for (int i = 0; i < 10; i++) {
			chk[i] = false;
		}
		for (int i = (r / 3) * 3; i < ((r / 3) * 3) + 3; i++) {
			for (int j = (c / 3) * 3; j < ((c / 3) * 3) + 3; j++) {
				if (map[i][j] != 0) {
					chk[map[i][j]] = true;
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			if (map[i][c] != 0) {
				chk[map[i][c]] = true;
			}
		}
		for (int i = 0; i < 9; i++) {
			if (map[r][i] != 0) {
				chk[map[r][i]] = true;
			}
		}
		if (!chk[n])
			return true;
		else
			return false;
	}

}
