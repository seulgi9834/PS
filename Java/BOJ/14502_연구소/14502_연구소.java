import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int N, M, max;
	static int[] list;
	static int[][] map;
	static int[][] copyMap;
	static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] visited;
	static ArrayList<virus> virusList = new ArrayList<>();
	static ArrayList<virus> blankList = new ArrayList<>();
	static ArrayList<virus> wallList = new ArrayList<>();

	static class virus {
		int row;
		int col;

		public virus(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virusList.add(new virus(i, j));
				}
				if (map[i][j] == 0) {
					blankList.add(new virus(i, j));
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			wallList.add(i, new virus(-1, -1));
		}

		list = new int[blankList.size()];
		for (int i = 0; i < M; i++) { // 조합을 위해서 사용
			list[i] = i;
		}

		subset(0, 0); // 부분집합으로 벽 세우기

		System.out.println(max);
	}

	static void subset(int cnt, int idx) {
		if (cnt == 3) {
			visited = new boolean[N][M];
			copy(); // 복사된 맵 생성

			// 벽 세우기
			for (int i = 0; i < 3; i++) {
				copyMap[wallList.get(i).row][wallList.get(i).col] = 1;
			}

			// 바이러스 확산
			for (int i = 0; i < virusList.size(); i++) {
				bfs(virusList.get(i).row, virusList.get(i).col);
			}

			// 최댓값 갱신
			max = Integer.max(max, count());

			return;
		}

		for (int i = idx; i < blankList.size(); i++) {
			wallList.set(cnt, blankList.get(i));
			subset(cnt + 1, i + 1);
		}
	}

	// 바이러스 확산
	static void bfs(int row, int col) {
		Queue<virus> queue = new LinkedList<>();
		queue.add(new virus(row, col));
		copyMap[row][col] = 2;
		visited[row][col] = true;
		while (!queue.isEmpty()) {
			virus pos = queue.poll();
			for (int i = 0; i < 4; i++) {
				int newRow = pos.row + move[i][0];
				int newCol = pos.col + move[i][1];
				if (newRow >= N || newCol >= M || newRow < 0 || newCol < 0)
					continue;
				if (copyMap[newRow][newCol] == 1)
					continue;
				if (copyMap[newRow][newCol] == 2)
					continue;
				if (visited[newRow][newCol])
					continue;
				visited[newRow][newCol] = true;
				copyMap[newRow][newCol] = 2;
				queue.add(new virus(newRow, newCol));
			}
		}

	}

	// 맵 복사
	static void copy() {
		copyMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}

	// 안전 지역 카운트
	static int count() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyMap[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
