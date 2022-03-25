import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static int[] cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		cnt = new int[3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		count(0, 0, N);
		for (int i = 0; i < 3; i++) {
			System.out.println(cnt[i]);
		}

	}

	static void count(int row, int col, int size) {
		if (check(row, col, size)) {
			int start = map[row][col];
			cnt[start + 1]++;
			return;
		}
		count(row, col, size / 3);
		count(row, col + size / 3, size / 3);
		count(row, col + size * 2 / 3, size / 3);
		count(row + size / 3, col, size / 3);
		count(row + size / 3, col + size / 3, size / 3);
		count(row + size / 3, col + size * 2 / 3, size / 3);
		count(row + size * 2 / 3, col, size / 3);
		count(row + size * 2 / 3, col + size / 3, size / 3);
		count(row + size * 2 / 3, col + size * 2 / 3, size / 3);

	}

	static boolean check(int row, int col, int size) {
		int start = map[row][col];
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (start != map[i][j]) {
					return false;
				}
			}
		}

		return true;
	}

}
