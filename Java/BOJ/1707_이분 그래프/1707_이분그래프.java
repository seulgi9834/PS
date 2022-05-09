import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int K, V, E;
	static boolean flag;
	static int[] visited;
	static ArrayList<Integer> node[];
	static Queue<Integer> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int test_case = 0; test_case < K; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			flag = true;

			node = new ArrayList[V + 1];
			for (int i = 0; i <= V; i++) {
				node[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				node[u].add(v);
				node[v].add(u);
			}
			visited = new int[V + 1];
			queue = new LinkedList<Integer>();
			for (int i = 1; i <= V; i++) {
				if (visited[i] == 0 && flag) {
					bfs(i);
				}
			}
			if (flag) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}
		System.out.println(sb);
	}

	static void bfs(int st) {
		queue.add(st);
		visited[st] = 1;

		while (!queue.isEmpty()) {
			int idx = queue.poll();
			for (int i = 0; i < node[idx].size(); i++) {
				if (visited[node[idx].get(i)] == 0) {
					queue.add(node[idx].get(i));
					if (visited[idx] == 1) {
						visited[node[idx].get(i)] = 2;
					} else if (visited[idx] == 2) {
						visited[node[idx].get(i)] = 1;
					}
				} else if (visited[idx] == visited[node[idx].get(i)]) {
					flag = false;
					return;
				}
			}
		}
	}
}
