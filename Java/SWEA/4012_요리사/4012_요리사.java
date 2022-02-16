import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, Min;
	static int[][] arr;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine()); // 총 테스트 케이스의 개수

		for (int test_case = 1; test_case <= T; test_case++) {

			N = Integer.parseInt(br.readLine()); // 식재료의 수
			Min = Integer.MAX_VALUE; // 최솟값
			arr = new int[N][N]; // 재료
			visited = new boolean[N]; // 선택 확인

			for (int i = 0; i < N; i++) { // 재료 입력
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			select(0, 0);
			sb.append("#" + test_case + " " + Min + "\n");
		}
		System.out.println(sb);
	}

	// 재료 선택(A음식의 재료 선택), 조합 이용
	static void select(int cnt, int idx) {
		if (cnt == N / 2) { // 재료를 N/2개씩 넣기 때문에 N개 중 N/2개 선택
			Min = Math.min(Min, calculate()); // 맛의 차이가 최소
			return;
		}
		for (int i = idx; i < N; i++) { // 인덱스를 사용해 중복 방지
			visited[i] = true; // 선택
			select(cnt + 1, i + 1);
			visited[i] = false; // 선택 해제
		}
	}

	// 차이 계산
	static int calculate() {
		int sum_A = 0; // A음식의 시너지의 합
		int sum_B = 0; // B음식의 시너지의 합

		for (int i = 0; i < N - 1; i++) { // 같은 재료를 사용하지 않음
			for (int r = i + 1; r < N; r++) {
				if (visited[i] && visited[r]) {
					sum_A += arr[i][r] + arr[r][i]; // A음식의 재료의(i,r) 시너지 합
				} else if (!visited[i] && !visited[r]) {
					sum_B += arr[i][r] + arr[r][i]; // B음식의 재료의(i,r) 시너지 합
				}
			}
		}
		int diff = Math.abs(sum_A - sum_B); // 두 음식의 차(절댓값)
		return diff;
	}
}
