import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static boolean[] visited;
	static ArrayList<Integer>[] computers;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		visited = new boolean[N + 1];
		computers = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			computers[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			computers[a].add(b);
			computers[b].add(a);
		}
		bfs(1);
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			if (visited[i])
				answer++;
		}
		System.out.println(answer - 1);
	}

	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[1] = true;
		while (!queue.isEmpty()) {
			int s = queue.poll();
			for (int i = 0; i < computers[s].size(); i++) {
				if (visited[computers[s].get(i)])
					continue;
				visited[computers[s].get(i)] = true;
				queue.add(computers[s].get(i));
			}
		}
		return;

	}
}
