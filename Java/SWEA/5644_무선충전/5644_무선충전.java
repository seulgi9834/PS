import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); // 총 이동 시간
			int A = Integer.parseInt(st.nextToken()); // BC의 개수
			int[][] BC = new int[A][4];
			int[] user1 = new int[M + 1];
			int[] user2 = new int[M + 1];
			int sum = 0; // 모든 사용자의 충전량 합의 최대값

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				user1[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				user2[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				BC[i][0] = Integer.parseInt(st.nextToken()); // X : BC 좌표
				BC[i][1] = Integer.parseInt(st.nextToken()); // Y : BC 좌표
				BC[i][2] = Integer.parseInt(st.nextToken()); // C : 충전 범위
				BC[i][3] = Integer.parseInt(st.nextToken()); // P : 처리량
			}

			int user1_x = 1;
			int user1_y = 1;
			int user2_x = 10;
			int user2_y = 10;
			int[] x = { 0, 0, 1, 0, -1 };
			int[] y = { 0, -1, 0, 1, 0 };

			for (int t = 0; t <= M; t++) {
				user1_x = user1_x + x[user1[t]];
				user1_y = user1_y + y[user1[t]];
				user2_x = user2_x + x[user2[t]];
				user2_y = user2_y + y[user2[t]];
				int max = 0;

				for (int i = 0; i < A; i++) {
					for (int r = 0; r < A; r++) {
						int temp = 0;
						int Charge1 = 0;
						int Charge2 = 0;
						if (Math.abs(user1_x - BC[i][0]) + Math.abs(user1_y - BC[i][1]) <= BC[i][2]) {
							Charge1 = BC[i][3];
						}
						if (Math.abs(user2_x - BC[r][0]) + Math.abs(user2_y - BC[r][1]) <= BC[r][2]) {
							Charge2 = BC[r][3];
						}
						if (i != r) {
							temp = Charge1 + Charge2;
						} else {
							temp = Math.max(Charge1, Charge2);
						}
						max = Math.max(temp, max);
					}
				}
				sum += max;
			}
			sb.append("#" + test_case + " " + sum + "\n");

		}
		System.out.println(sb);
	}
}
