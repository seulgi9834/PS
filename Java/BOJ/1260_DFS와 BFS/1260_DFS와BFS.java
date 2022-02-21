import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, V;
	static int arr[][];
	static boolean visited[];
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr[start][end] = 1;
			arr[end][start] = 1;
		}
		DFS(V);
		sb.append("\n");
		visited = new boolean[N + 1];
		BFS(V);
		System.out.println(sb);
	}

	static void DFS(int current) {
		visited[current] = true;
		sb.append(current + " ");
//		Queue <Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && arr[current][i] == 1) {
				DFS(i);
			}
		}
	}

	static void BFS(int current) {
		Queue<Integer> queue = new LinkedList<>();
		visited[current] = true;
		queue.offer(current);
		while (!queue.isEmpty()) {
			current = queue.poll();
			sb.append(current + " ");
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && arr[current][i] == 1) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}
