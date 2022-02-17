import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C, answer;
	static int[][] arr;
	static boolean[] chk;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new int[R][C];
		chk = new boolean[26];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j) - 'A';
			}
		}
		
		move(0, 0, 0);
		System.out.println(answer);
	}

	public static void move(int row, int col, int count) {
		if (chk[arr[row][col]]) {
			answer = Math.max(answer, count);
			return;
		} 
		else {
			chk[arr[row][col]] = true;
			for (int i = 0; i < 4; i++) {
				int nr = row + dir[i][0];
				int nc = col + dir[i][1];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
					move(nr, nc, count + 1);
				}
			}
			chk[arr[row][col]] = false;
		}
	}
}
