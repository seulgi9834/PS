import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static int[][] move = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
	static int[][][] magic = { { { 1, -1, 2, -2, 0, 1, -1, 1, -1, 0 }, { 1, 1, 0, 0, -2, 0, 0, -1, -1, -1 } },
			{ { -1, -1, 0, 0, 2, 0, 0, 1, 1, 1 }, { -1, 1, -2, 2, 0, -1, 1, -1, 1, 0 } },
			{ { 1, -1, 2, -2, 0, 1, -1, 1, -1, 0 }, { -1, -1, 0, 0, 2, 0, 0, 1, 1, 1 } },
			{ { 1, 1, 0, 0, -2, 0, 0, -1, -1, -1 }, { -1, 1, -2, 2, 0, -1, 1, -1, 1, 0 } } };
	static int[] percent = { 1, 1, 2, 2, 5, 7, 7, 10, 10 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int r = N / 2; // 격자 가운데
		int c = N / 2; // 격자 가운데
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 1;
		int dCnt = 0; // 방향 전환 idx
		int answer = 0; // 범위밖으로 나간 모래
		boolean flag = true;
		while (flag) {
			for (int i = 0; i < 2; i++) { // 1, 2, 3...칸씩 방향을 전환하면서 2번씩 진행
				for (int j = 0; j < cnt; j++) {
					// y로 이동(y로 이동은 범위를 초과할 일이 없음)
					int newR = move[dCnt][0] + r;
					int newC = move[dCnt][1] + c;
					if (!chk(newR, newC)) {
						System.out.println(answer);
						return;
					}
					int sand = map[newR][newC];
					map[newR][newC] = 0;
					int spread = 0;
					for (int k = 0; k < 9; k++) {
						int magicR = newR + magic[dCnt][0][k];
						int magicC = newC + magic[dCnt][1][k];
						int sandPercent = (sand * percent[k]) / 100;
						if (chk(magicR, magicC)) {
							// 모래 이동
							map[magicR][magicC] += sandPercent;
						} else {
							// 범위를 빠져나간 모래
							answer += sandPercent;
						}
						spread += sandPercent;
					}
					if (chk(newR + move[dCnt][0], newC + move[dCnt][1])) {
						map[newR + move[dCnt][0]][newC + move[dCnt][1]] += sand - spread; // 이동하지 않은 모래
					} else {
						// 범위를 빠져나간 모래
						answer += sand - spread; // 이동하지 않은 모래
					}

					r = newR;
					c = newC;

				}
				dCnt = (dCnt + 1) % 4;

			}
			// 카운트 업
			cnt += 1;
		}
	}

	static boolean chk(int row, int col) {
		if (row < 0 || col < 0 || row >= N || col >= N)
			return false;
		return true;
	}
}
