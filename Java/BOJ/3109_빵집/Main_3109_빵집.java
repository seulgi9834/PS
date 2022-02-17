import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C, answer;
	static char[][] arr;
	static int[] move = { -1, 0, 1 }; // 오른쪽 위 대각선, 오른쪽, 오른쪽 아래 대각선

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		answer = 0;
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int r = 0; r < C; r++) {
				arr[i][r] = str.charAt(r);
			}
		}
		for (int i = 0; i < R; i++) {
			if (pipe(i, 0))
				answer++;
		}
		System.out.println(answer);
	}

	static boolean pipe(int r, int c) {

		for (int i = 0; i < 3; i++) {
			int nr = r + move[i];
			int nc = c + 1;
			if (nr < R && nr >= 0 && nc < C && nc >= 0 && arr[nr][nc] == '.') {
				if (nc == C - 1) {
					return true;
				}
				arr[nr][nc] = '#';
				if (pipe(nr, nc)) {
					return true;
				}
			}

		}
		return false;
	}

}