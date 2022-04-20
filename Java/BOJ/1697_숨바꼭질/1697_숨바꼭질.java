import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] map;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[100001];
		visited = new boolean[100001];
		bfs(N);
		System.out.println(map[M]);

	}

	static void bfs(int pos) {
		int sec = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		map[N] = sec;
		visited[N] = true;

		while (!queue.isEmpty()) {
			int position = queue.poll();
			int newSec = map[position];
			if (position == M) {
				return;
			}
			if (chk(position - 1) && !visited[position - 1]) {
				queue.add(position - 1);
				visited[position - 1] = true;
				map[position - 1] = newSec + 1;
			}
			if (chk(position + 1) && !visited[position + 1]) {
				queue.add(position + 1);
				visited[position + 1] = true;
				map[position + 1] = newSec + 1;
			}
			if (chk(position * 2) && !visited[position * 2]) {
				queue.add(position * 2);
				visited[position * 2] = true;
				map[position * 2] = newSec + 1;
			}
		}
	}

	static boolean chk(int pos) {
		if (pos < 0 || pos > 100000)
			return false;
		return true;
	}
}
