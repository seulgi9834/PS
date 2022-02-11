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
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int Max = 0;
			int[] list = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < N; i++) {
				for (int r = i + 1; r < N; r++) {
					int tmp = list[i] + list[r]; // 경우의 수를 모두 탐방함
					if (tmp <= M && Max < tmp) {
						Max = tmp;
					}
				}
			}
			if (Max == 0) { // 한빈이가 두 과자를 들고 갈 방법이 없는 경우
				Max = -1;
			}
			sb.append("#").append(test_case).append(" ").append(Max).append("\n");

		}
		System.out.println(sb);
	}
}
