import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	static int[][] map = new int[5][5];
	static int[] num;
	static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] visited;
	static HashSet<Integer> arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		arr = new HashSet<>();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				num = new int[6];
				num[0] = map[i][j];
				dfs(i, j, 1);
			}
		}
		System.out.println(arr.size());

	}

	static void dfs(int row, int col, int depth) {
		if (depth == 6) {
			int temp = 0;
			for (int i = 0; i < 6; i++) {
				temp += num[i] * (Math.pow(10, i));
			}
			arr.add(temp);
			return;
		}
		int r = row;
		int c = col;
		for (int i = 0; i < 4; i++) {
			int newR = r + move[i][0];
			int newC = c + move[i][1];
			if (newR >= 5 || newC >= 5 || newR < 0 || newC < 0) {
				continue;
			}
			num[depth] = map[newR][newC];
			dfs(newR, newC, depth + 1);
		}

	}
}
