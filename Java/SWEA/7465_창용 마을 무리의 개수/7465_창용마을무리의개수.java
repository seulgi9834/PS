import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[] matrix;

	public static void makeSet() {
		matrix = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			matrix[i] = i;
		}
	}

	public static int findSet(int a) {
		if (a == matrix[a])
			return a;
		return matrix[a] = findSet(matrix[a]);
	}

	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return false;

		matrix[bRoot] = aRoot;

		if (aRoot < bRoot) {
			matrix[bRoot] = aRoot;
			for (int i = 1; i <= N; i++) {
				if (matrix[i] == bRoot) {
					matrix[i] = aRoot;
				}
			}
		} else {
			matrix[aRoot] = bRoot;
			for (int i = 1; i <= N; i++) {
				if (matrix[i] == aRoot) {
					matrix[i] = bRoot;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			boolean[] visited = new boolean[N + 1];
			makeSet();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				union(from, to);
			}

			int answer = 0;
			for (int i = 1; i <= N; i++) {
				visited[matrix[i]] = true;
			}
			for (int i = 1; i <= N; i++) {
				if (visited[i])
					answer++;
			}

			sb.append("#" + test_case + " " + answer + "\n");
		}
		System.out.println(sb);
	}
}
