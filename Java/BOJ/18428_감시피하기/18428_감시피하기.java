import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N, cnt;
	static String answer;
	static boolean[] visited;
	static char[][] room;
	static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static ArrayList<position> T = new ArrayList<>();
	static ArrayList<position> X = new ArrayList<>();

	static class position {
		int row;
		int col;

		public position(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		room = new char[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				room[i][j] = st.nextToken().charAt(0);
				if (room[i][j] == 'T')
					T.add(new position(i, j));
				if (room[i][j] == 'X')
					X.add(new position(i, j));
			}
		}
		answer = "";
		visited = new boolean[X.size()];
		watch(0, 0);

		if (answer == "") {
			answer = "NO";
		}
		System.out.println(answer);
	}

	static void watch(int cnt, int idx) {
		if (cnt == 3) {
			if (find()) {
				answer = "YES";
			}
			return;
		}

		for (int i = idx; i < X.size(); i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			position pos = X.get(i);
			room[pos.row][pos.col] = 'O';
			watch(cnt + 1, i + 1);
			room[pos.row][pos.col] = 'X';
			visited[i] = false;

		}
	}

	static boolean find() {
		for (int i = 0; i < T.size(); i++) {
			position temp = T.get(i);
			int r = temp.row;
			int c = temp.col;
			for (int j = 0; j < 4; j++) {
				int newRow = r + move[j][0];
				int newCol = c + move[j][1];
				while (newRow >= 0 && newCol >= 0 && newRow < N && newCol < N) {
					if (room[newRow][newCol] == 'S')
						return false;
					if (room[newRow][newCol] == 'O')
						break;
					newRow += move[j][0];
					newCol += move[j][1];

				}
			}
		}
		return true;
	}

}
