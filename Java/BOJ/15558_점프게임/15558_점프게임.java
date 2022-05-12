import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, K, idx;
	static int[][] Line;
	static boolean[][] visited;

	static class pos {
		int line; // 현재 위치한 줄
		int posIdx; // 현재 위치한 칸
		int time; // 경과한 시간
		int lineIdx; // 마지막 칸

		public pos(int line, int posIdx, int time, int lineIdx) {
			super();
			this.line = line;
			this.posIdx = posIdx;
			this.time = time;
			this.lineIdx = lineIdx;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		Line = new int[3][100001];
		visited = new boolean[3][100001];

		String str1 = br.readLine();
		String str2 = br.readLine();
		for (int i = 1; i <= N; i++) {
			Line[1][i] = str1.charAt(i - 1) - '0';
			Line[2][i] = str2.charAt(i - 1) - '0';
		}
		if (bfs()) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}

	}

	static boolean bfs() {
		Queue<pos> queue = new LinkedList<>();
		queue.add(new pos(1, 1, 0, 1));
		visited[1][1] = true;
		while (!queue.isEmpty()) {
			pos current = queue.poll();
			if (current.posIdx > N) {
				return true;
			}
			for (int i = 0; i < 3; i++) {
				if (i == 0) {
					if (current.posIdx + 1> N) {
						return true;
					}
					if (current.posIdx + 1 >= current.lineIdx + 1 && current.posIdx <= N
							&& !visited[current.line][current.posIdx + 1]) {
						if (Line[current.line][current.posIdx + 1] == 1) {
							visited[current.line][current.posIdx + 1] = true;
							queue.add(new pos(current.line, current.posIdx + 1, current.time + 1, current.lineIdx + 1));
						}
					}
				}
				if (i == 1) {
					if (current.posIdx-1 > N) {
						return true;
					}
					if (current.posIdx - 1 >= current.lineIdx + 1 && current.posIdx-1 >= 1
							&& !visited[current.line][current.posIdx - 1]) {
						if (Line[current.line][current.posIdx - 1] == 1) {
							visited[current.line][current.posIdx - 1] = true;
							queue.add(new pos(current.line, current.posIdx - 1, current.time + 1, current.lineIdx + 1));
						}
					}
				}
				if (i == 2) {
					int temp = current.line;
					if (temp == 1) {
						temp = 2;
					} else
						temp = 1;
					if (current.posIdx + K > N) {
						return true;
					}
					if (current.posIdx + K >= current.lineIdx+1 && current.posIdx + K <= N
							&& !visited[temp][current.posIdx + K]) {
						if (Line[temp][current.posIdx + K] == 1) {
							visited[temp][current.posIdx + K] = true;
							queue.add(new pos(temp, current.posIdx + K, current.time + 1, current.lineIdx + 1));
						}
					}
				}

			}
		}
		return false;
	}
}
