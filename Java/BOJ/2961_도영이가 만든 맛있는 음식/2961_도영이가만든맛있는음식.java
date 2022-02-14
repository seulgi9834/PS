import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static boolean[] visited;
	static int N, Min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		visited = new boolean[N];
		Min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); // 신맛
			arr[i][1] = Integer.parseInt(st.nextToken()); // 쓴맛
		}

		select(0); //아무것도 선택하지 않았을 경우부터 시작
		System.out.println(Min);

	}

	public static void select(int cnt) { // 부분집합을 이용해서 풀이
		if (cnt == N) {
			int totalA = 0; // 쓴맛(합)
			int totalB = 0; // 신맛(곱)
			boolean chk = false;
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					totalA += arr[i][1]; // 쓴맛
					if (!chk) {
						chk = true;
						totalB = arr[i][0]; // 신맛
					} else {
						totalB *= arr[i][0];
					}
				}
			}
			if (totalA != 0 && totalB != 0) {
				Min = Integer.min(Min, Math.abs(totalB - totalA));
			} // 신맛과 쓴맛의 차이가 가장 작은 요리
			return;
		}
		visited[cnt] = true;
		select(cnt + 1);
		visited[cnt] = false;
		select(cnt + 1);
	}
}
