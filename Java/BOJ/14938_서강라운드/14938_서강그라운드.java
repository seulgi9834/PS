import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m, r, answer;
	static int[] item;
	static int[][] area;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 지역의 개수
		m = Integer.parseInt(st.nextToken()); // 수색 범위
		r = Integer.parseInt(st.nextToken()); // 길의 개수

		item = new int[n + 1]; // 아이템은 1부터 시작
		area = new int[n + 1][n + 1]; // 지역은 1부터 시작
		answer = Integer.MIN_VALUE; // 최대 아이템

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) { // 아이템 입력
			item[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				area[i][j] = 16; // 길이의 최댓값, Integer.MAX_VALUE를 넣으면 추후 Overflow 발생
			}
		}

		for (int i = 0; i < r; i++) { // 길입력
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			area[a][b] = l;
			area[b][a] = l;
		}

		for (int i = 1; i <= n; i++) {// 경유
			for (int j = 1; j <= n; j++) { // 출발
				for (int r = 1; r <= n; r++) { // 도착
					if (i == j || j == r || i == r) { // 자기 자신 제외
						continue;
					} else {
						// 이어진 부분을 연결
						area[j][r] = Integer.min(area[j][i] + area[i][r], area[j][r]);
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			int itemSum = item[i]; // 자기 자신의 아이템
			for (int j = 1; j <= n; j++) {
				if (i == j)
					continue;
				if (area[i][j] <= m) {
					itemSum += item[j];
				}
			}
			answer = Integer.max(answer, itemSum);
		}
		System.out.println(answer);

	}
}
