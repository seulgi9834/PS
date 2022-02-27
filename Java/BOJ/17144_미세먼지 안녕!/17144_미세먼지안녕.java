import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int R, C, T;
	static int[][] room, dustRoom;
	static ArrayList<cleaner> cleaner;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static class cleaner {
		int r;
		int c;

		public cleaner(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		room = new int[R][C];
		cleaner = new ArrayList<cleaner>();

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if (room[i][j] == -1) {
					cleaner.add(new cleaner(i, j));
				}
			}
		}
		for (int i = 0; i < T; i++) {
			diffusion();
			antiTimeCycle();
			TimeCycle();
		}

		int answer = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				answer += room[i][j];
			}
		}
		System.out.println(answer + 2);
	}

	static void diffusion() {
		dustRoom = new int[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (room[i][j] == -1 || room[i][j] == 0) {
					continue;
				}
				int div = room[i][j] / 5;
				// 확산이 가능한지 확인
				int cnt = 0;
				for (int k = 0; k < 4; k++) {
					int nR = i + dir[k][0];
					int nC = j + dir[k][1];
					if (nR >= 0 && nC >= 0 && nR < R && nC < C) {
						if (room[nR][nC] != -1) {
							dustRoom[nR][nC] += div;
							cnt++;
						}
					}
				}
				room[i][j] = room[i][j] - div * cnt;
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (room[i][j] == -1)
					continue;
				else
					room[i][j] += dustRoom[i][j];

			}
		}
	}

	static void antiTimeCycle() {
		int r = cleaner.get(0).r;
		int c = cleaner.get(0).c;

		for (int i = cleaner.get(0).r; i >= 1; i--) {
			room[i][0] = room[i - 1][0];
		}
		for (int i = 0; i < C - 1; i++) {
			room[0][i] = room[0][i + 1];
		}
		for (int i = 0; i < cleaner.get(0).r; i++) {
			room[i][C - 1] = room[i + 1][C - 1];
		}
		for (int i = C - 1; i >= 1; i--) {
			room[r][i] = room[r][i - 1];
		}
		room[r][1] = 0;
		room[r][c] = -1;
	}

	static void TimeCycle() {
		int r = cleaner.get(1).r;
		int c = cleaner.get(1).c;

		for (int i = r; i < R - 1; i++) {
			room[i][0] = room[i + 1][0];
		}
		for (int i = 0; i < C - 1; i++) {
			room[R - 1][i] = room[R - 1][i + 1];
		}
		for (int i = R - 1; i > r; i--) {
			room[i][C - 1] = room[i - 1][C - 1];
		}
		for (int i = C - 1; i > 0; i--) {
			room[r][i] = room[r][i - 1];
		}
		room[r][1] = 0;
		room[r][c] = -1;

	}
}