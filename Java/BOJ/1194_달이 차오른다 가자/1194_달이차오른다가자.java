import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static char[][] map; // 지도(문자가 입력 되기 때문에 문자열)
	static boolean[][][] visited; // 방문 확인(열쇠도 같이 체크)
	static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int R, C;
	
	// 해당 칸의 행, 열, 키, 이동 횟수 저장
	static class position {
		int row;
		int col;
		int key;
		int cnt;

		public position(int row, int col, int key, int cnt) { 
			super();
			this.row = row;
			this.col = col;
			this.key = key;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C][64];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		int answer = -1; // 탈출 할 수 없는 경우
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '0') {
					answer = bfs(i, j);
				}
			}
		}
		System.out.println(answer);
	}

	// 가중치가 같은 경우 최단 경로 탐색
	static int bfs(int r, int c) {
		Queue<position> queue = new LinkedList<>();
		queue.add(new position(r, c, 0, 0));
		visited[r][c][0] = true;
		while (!queue.isEmpty()) {
			position pos = queue.poll();
			int row = pos.row;
			int col = pos.col;
			int key = pos.key;
			int cnt = pos.cnt;

			for (int i = 0; i < 4; i++) {
				int nRow = row + move[i][0];
				int nCol = col + move[i][1];

				if (nRow >= R || nCol >= C || nRow < 0 || nCol < 0)
					continue; // 범위 초과
				
				if (visited[nRow][nCol][key] || map[nRow][nCol] == '#')
					continue; // 방문했거나, 벽일때
				
				// 열쇠를 만날 때
				if ('a' <= map[nRow][nCol] && map[nRow][nCol] <= 'f') {
					int newKey = addKey(map[nRow][nCol], key);
					visited[nRow][nCol][newKey] = true;
					queue.add(new position(nRow, nCol, newKey, cnt + 1));
				}
				
				// 문을 만날 때
				else if ('A' <= map[nRow][nCol] && map[nRow][nCol] <= 'F') {
					if (openDoor(map[nRow][nCol], key)) {
						visited[nRow][nCol][key] = true;
						queue.add(new position(nRow, nCol, key, cnt + 1));
					}
				}
				
				// 탈출구를 만날 때
				else if (map[nRow][nCol] == '1') {
					return cnt + 1;
				}
				
				// 빈 칸을 만날 때
				else {
					visited[nRow][nCol][key] = true;
					queue.add(new position(nRow, nCol, key, cnt + 1));
				}

			}
		}

		return -1; // 탈출 할 수 없는 경우

	}

	// lower, upper 사용해서 구현
	
	// 키 추가
	static int addKey(char keyName, int key) {
		return key | 1 << (keyName - 'a');
	}

	
	// 문 열기
	static boolean openDoor(char doorName, int key) {
		if (((1 << doorName - 'A') & key) != 0)
			return true;
		else
			return false;
	}

}
