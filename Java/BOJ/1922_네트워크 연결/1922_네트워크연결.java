import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static ArrayList<Node>[] computer;

	static class Node implements Comparable<Node> {
		int to;
		int weight;

		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	public static long prim() {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(1, 0));
		long cost = 0;
		int cnt = 0;
		boolean[] visited = new boolean[N + 1];
		while (!queue.isEmpty()) {
			Node edge = queue.poll();
			if (visited[edge.to])
				continue;

			cost += edge.weight;
			visited[edge.to] = true;
			if (++cnt == N)
				return cost;

			for (int i = 0; i < computer[edge.to].size(); i++) {
				Node nextNode = computer[edge.to].get(i);
				if (visited[nextNode.to])
					continue;
				queue.add(nextNode);
			}
		}
		return cost;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		computer = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			computer[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			computer[a].add(new Node(b, c));
			computer[b].add(new Node(a, c));
		}
		System.out.println(prim());
	}
}
