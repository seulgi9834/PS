import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static StringBuilder sb;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine()); // 영상의 크기
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int r = 0; r < N; r++) {
				arr[i][r] = str.charAt(r) - '0';
			}
		}

		tree(0, 0, N);

		System.out.println(sb);
	}

	static void tree(int col, int row, int size) {
		if (colorCheck(col, row, size)) { // 압축 가능하면 해당 값으로 압축
			sb.append(arr[col][row]);
			return;
		}

		sb.append("(");
		tree(col, row, size / 2); // 1 사분면
		tree(col, row + size / 2, size / 2); // 2 사분면
		tree(col + size / 2, row, size / 2); // 3 사분면
		tree(col + size / 2, row + size / 2, size / 2); // 4 사분면
		sb.append(")");

	}

	// 압축 가능한지 확인
	static boolean colorCheck(int c, int r, int size) {
		int color = arr[c][r];
		for (int i = c; i < c + size; i++) {
			for (int j = r; j < r + size; j++) {
				if (color != arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
