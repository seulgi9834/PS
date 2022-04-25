import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int H, W, O, F, XS, YS, XE, YE;
	static int[][] map;
	static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] visited;

	static class pos {
		int r;
		int c;
		int f;

		public pos(int r, int c, int f) {
			super();
			this.r = r;
			this.c = c;
			this.f = f;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken()); // 세로
			W = Integer.parseInt(st.nextToken()); // 가로
			O = Integer.parseInt(st.nextToken()); // 장애물 개수
			F = Integer.parseInt(st.nextToken()); // 초기 힘
			XS = Integer.parseInt(st.nextToken()); // 출발지 좌표 X(가로)
			YS = Integer.parseInt(st.nextToken()); // 출발지 좌표 Y(세로)
			XE = Integer.parseInt(st.nextToken()); // 도착지 좌표 X
			YE = Integer.parseInt(st.nextToken()); // 도착지 좌표 Y
			map = new int[H + 1][W + 1]; // 지도
			visited = new boolean[H + 1][W + 1]; // 방문 체크
			for (int i = 0; i < O; i++) { // 장애물 입력
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				int L = Integer.parseInt(st.nextToken());
				map[X][Y] = L;
			}

			boolean flag = bfs(XS, YS);
			if (flag)
				sb.append("잘했어!!\n");
			else
				sb.append("인성 문제있어??\n");
		}
		System.out.println(sb);
	}

	static boolean bfs(int row, int col) {
		Queue<pos> queue = new LinkedList<>();
		queue.add(new pos(row, col, F));
		visited[row][col] = true;

		while (!queue.isEmpty()) {
			pos current_pos = queue.poll();
			int cR = current_pos.r;
			int cC = current_pos.c;
			int cF = current_pos.f;
			if (cF <= 0) { // 힘 고갈
				continue;
			}
			for (int i = 0; i < 4; i++) {
				int newR = cR + move[i][0];
				int newC = cC + move[i][1];
				if (newR < 1 || newC < 1 || newR > H || newC > W) // 범위 초과
					continue;
				if (visited[newR][newC]) // 이미 방문한적이 있음
					continue;
				if (newR == XE && newC == YE) { // 목적지 도착(장애물 없음)
					return true;
				}
				if (map[newR][newC] == 0) { // 장애물이 없는 구역
					visited[newR][newC] = true;
					queue.add(new pos(newR, newC, cF - 1));
				} else { // 장애물이 있음
					if (cF >= map[newR][newC] - map[cR][cC]) { // 이동할수 있음
						visited[newR][newC] = true;
						queue.add(new pos(newR, newC, cF - 1));
					} else { // 이동할 수 없음
						continue;
					}
				}
			}
		}

		return false;
	}
}
