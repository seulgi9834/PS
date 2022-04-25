import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, area1, area2, min;
	static int[][] map;
	static int[] areas;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		min = Integer.MAX_VALUE;
		area1 = 0;
		area2 = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j)
					map[i][j] = 0;
				else
					map[i][j] = 123456789;
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			map[A][B] = 1;
			map[B][A] = 1;
		}

		// 플로이드 와샬
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}

		visited = new boolean[N + 1]; // 방문 확인
		areas = new int[2]; // 가게 넣을 배열
		selectArea(1, 0); // 가게 2개 선정
		System.out.println(area1 + " " + area2 + " " + min * 2); // 단거리*2
	}

	static void selectArea(int idx, int cnt) {
		if (cnt == 2) { // 가게 2개 선정
			int sum = 0;
			for (int i = 1; i <= N; i++) {
				if (i == areas[0] || i == areas[1])
					continue;
				else
					sum += Integer.min(map[areas[0]][i], map[areas[1]][i]);
			}
			if (sum < min) {
				area1 = areas[0];
				area2 = areas[1];
				min = sum;
			}
			return;
		}

		for (int i = idx; i <= N; i++) {
			if (visited[idx])
				continue;
			visited[idx] = true;
			areas[cnt] = i;
			selectArea(idx + 1, cnt + 1);
			visited[idx] = false;
		}
	}
}
