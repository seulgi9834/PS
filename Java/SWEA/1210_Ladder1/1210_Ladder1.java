import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[][] search = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] data;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = Integer.parseInt(br.readLine());
			data = new int[100][100];
			for (int r = 0; r < 100; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < 100; c++) {
					data[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			int sr = 99;
			int sc = -1;

			for (int c = 0; c < 100; c++) {
				if (data[sr][c] == 2) {
					sc = c;
				}
			}

			sb.append("#").append(T).append(" ").append(ladder(sr, sc)).append("\n");

		}

		System.out.println(sb);
	}

	static int ladder(int r, int c) {
		int lr = r - 1;
		int lc = c;
		int visited = -1;
		while (lr > 0) {
			if (lc - 1 >= 0 && data[lr][lc - 1] == 1 && lc - 1 != visited) {
				visited = lc;
				lc = lc - 1;

			} else if (lc + 1 <= 99 && data[lr][lc + 1] == 1 && lc + 1 != visited) {
				visited = lc;
				lc = lc + 1;

			} else if (data[lr - 1][lc] == 1) {
				lr = lr - 1;
				visited = lc;

			}
		}
		return lc;
	}
}
