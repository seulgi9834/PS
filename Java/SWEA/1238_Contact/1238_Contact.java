import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int[][] arr = new int[101][101];
			boolean[] visited = new boolean[101];
			int max = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a][b] = 1;
			}
			Queue<Integer> queue = new LinkedList<>();
			queue.add(start);
			visited[start] = true;
			while (!queue.isEmpty()) {
				int size = queue.size();
				max = 0;
				for (int r = 0; r < size; r++) {
					int temp = queue.poll();
					max = Math.max(temp, max);
					for (int i = 1; i <= 100; i++) {
						if (arr[temp][i] == 1 && visited[i] == false) {
							queue.add(i);
							visited[i] = true;
						}
					}

				}
			}
			sb.append("#" + test_case + " " + max + "\n");
		}

		System.out.println(sb);
	}
}
