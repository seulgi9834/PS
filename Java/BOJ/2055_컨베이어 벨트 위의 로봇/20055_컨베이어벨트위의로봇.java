import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{

	static int N, K;
	static ArrayList<belt> convey = new ArrayList<>();

	static class belt {
		int durability; // 내구도
		int robot;

		public belt(int durability, int robot) {
			super();
			this.durability = durability;
			this.robot = robot;
		}

	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		boolean flag = true;
		int stage = 1;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * N; i++) {
			convey.add(new belt(Integer.parseInt(st.nextToken()), 0)); // 내구성, 로봇 상태 입력
		}

		while (flag) {
			// 벨트가 각 칸위에 있는 로봇과 함께 한칸 회전
			belt temp = convey.get(2 * N - 1);
			for (int i = 2 * N - 1; i > 0; i--) {
				convey.set(i, new belt(convey.get(i - 1).durability, convey.get(i - 1).robot));

			}
			convey.set(0, new belt(temp.durability, temp.robot));

			// N번째 칸일 때 로봇 내리기
			if (convey.get(N - 1).robot == 1) {
				convey.set(N - 1, new belt(convey.get(N - 1).durability, 0)); //
			}

			// 로봇 이동
			if (convey.get(2 * N - 1).robot == 1) { // 로봇이 있을 경우에만 로봇 이동(마지막 칸)
				// 다음칸의 내구성이 1 이상이고, 로봇이 없다면 로봇 이동
				if (convey.get(0).durability >= 1 && convey.get(0).robot == 0) {
					convey.set(0, new belt(convey.get(0).durability - 1, 1)); // 컨베이어 벨트 내구도 1 감소 및 로봇 이동
					convey.set(2 * N - 1, new belt(convey.get(2 * N - 1).durability, 0)); // 로봇 이동
				}
			}
			for (int i = 2 * N - 2; i >= 0; i--) {
				if (convey.get(i).robot == 1) { // 로봇이 있을 경우에만 로봇 이동
					// 다음칸의 내구성이 1 이상이고, 로봇이 없다면 로봇 이동
					if (convey.get(i + 1).durability >= 1 && convey.get(i + 1).robot == 0) {
						convey.set(i + 1, new belt(convey.get(i + 1).durability - 1, 1)); // 컨베이어 벨트 내구도 1 감소 및 로봇 이동
						convey.set(i, new belt(convey.get(i).durability, 0)); // 로봇 이동
					}
				}
			}

			// N번째 칸일 때 로봇 내리기
			if (convey.get(N - 1).robot == 1) {
				convey.set(N - 1, new belt(convey.get(N - 1).durability, 0)); //
			}

			// 올리는 위치에 있는 칸의 내구도가 0이 아니면 로봇을 올림
			if (convey.get(0).durability > 0 && convey.get(0).robot == 0) {
				convey.set(0, new belt(convey.get(0).durability - 1, 1));
			}

			// 내구도가 0인 칸의 개수가 K개 이상이면 과정을 종료, 아니면 1번 부터
			int cnt = 0;
			for (int i = 0; i < 2 * N; i++) {
				if (convey.get(i).durability == 0) {
					cnt++;
				}
			}
			if (cnt >= K) {
				flag = false;
			} else {
				stage++;
			}
		}

		System.out.println(stage);

	}
}
