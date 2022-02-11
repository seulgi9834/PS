import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int map[][];
	static int arr[][];
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		while (T-- > 0) {
			int R = Integer.parseInt(st.nextToken());

			switch (R) {
			case 1:
				upDown();
				break;
			case 2:
				leftRight();
				break;
			case 3:
				rightRotate();
				break;
			case 4:
				leftRotate();
				break;

			case 5:
				clockWise();
				break;
			case 6:
				antiClockWise();
				break;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int r = 0; r < M; r++) {
				sb.append(arr[i][r]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	// 1번 연산 : 상하 반전
	static void upDown() {
		map = new int[N][M];
		int x = 0;
		int y = 0;
		for (int i = N - 1; i >= 0; i--) {
			for (int r = 0; r < M; r++) {
				map[x][y] = arr[i][r];
				y++;
			}
			y = 0;
			x++;
		}
		arr = map;
	}

	// 2번 연산 : 좌우 반전
	static void leftRight() {
		map = new int[N][M];
		int x = 0;
		int y = 0;
		for (int i = 0; i < N; i++) {
			for (int r = M - 1; r >= 0; r--) {
				map[x][y] = arr[i][r];
				y++;
			}
			y = 0;
			x++;
		}
		arr = map;
	}

	// 3번 연산: 오른쪽 90도
	static void rightRotate() {
		map = new int[M][N];
		int x = 0;
		int y = 0;
		for (int r = 0; r < M; r++) {
			for (int i = N - 1; i >= 0; i--) {
				map[x][y] = arr[i][r];
				y++;
			}
			y = 0;
			x++;
		}
		arr = map;
		int tmp = N;
		N = M;
		M = tmp;
	}

	// 4번 연산 : 왼쪽 90도
	static void leftRotate() {
		map = new int[M][N];
		int x = 0;
		int y = 0;
		for (int r = M - 1; r >= 0; r--) {
			for (int i = 0; i < N; i++) {
				map[x][y] = arr[i][r];
				y++;
			}
			y = 0;
			x++;
		}
		arr = map;
		int tmp = N;
		N = M;
		M = tmp;
	}

	// 5번 연산 : 4개의 부분 배열로 나누고 시계 방향 회전
	static void clockWise() {
		map = new int[N][M];
		int x = 0;
		int y = 0;

		for (int i = 0; i < N / 2; i++) {
			for (int r = 0; r < M / 2; r++) {
				map[x][y] = arr[N / 2 + i][r];
				y++;
			}
			for (int r = 0; r < M / 2; r++) {
				map[x][y] = arr[i][r];
				y++;
			}
			x++;
			y = 0;
		}

		for (int i = 0; i < N / 2; i++) {
			for (int r = M / 2; r < M; r++) {
				map[x][y] = arr[N / 2 + i][r];
				y++;
			}
			for (int r = M / 2; r < M; r++) {
				map[x][y] = arr[i][r];
				y++;
			}
			x++;
			y = 0;
		}
		arr = map;
	}

	// 6번 연산 : 4개의 부분 배열로 나누고 반시계 방향 회전
	static void antiClockWise() {
		map = new int[N][M];
		int x = 0;
		int y = 0;
		for (int i = 0; i < N / 2; i++) {
			for (int r = M / 2; r < M; r++) {
				map[x][y] = arr[i][r];
				y++;
			}
			for (int r = M / 2; r < M; r++) {
				map[x][y] = arr[N / 2 + i][r];
				y++;
			}
			x++;
			y = 0;
		}
		for (int i = 0; i < N / 2; i++) {
			for (int r = 0; r < M / 2; r++) {
				map[x][y] = arr[i][r];
				y++;
			}
			for (int r = 0; r < M / 2; r++) {
				map[x][y] = arr[N / 2 + i][r];
				y++;
			}
			x++;
			y = 0;
		}
		arr = map;
	}

}
