import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 색종이 수
		int[][] paper = new int[T][2];
		int MX = Integer.MIN_VALUE;
		int MY = Integer.MIN_VALUE;

		for (int i = 0; i < T; i++) { // 왼쪽 하단 좌표값을 입력 받고, 그 중 가장 큰 값을 찾음
			StringTokenizer st = new StringTokenizer(br.readLine());
			paper[i][0] = Integer.parseInt(st.nextToken());
			paper[i][1] = Integer.parseInt(st.nextToken());
			MX = Integer.max(MX, paper[i][0]);
			MY = Integer.max(MY, paper[i][1]);
		}

		int[][] map = new int[MX + 10][MY + 10]; // 색종이의 가로 세로는 10으로 고정되어 있으므로 10을 더함
		int cnt = 0; // 넓이

		for (int i = 0; i < T; i++) {
			for (int x = 0; x < 10; x++) {
				for (int y = 0; y < 10; y++) {
					if (map[paper[i][0] + x][paper[i][1] + y] != 1) { // 겹치는 부분을 피하기 위해 지정
						map[paper[i][0] + x][paper[i][1] + y] = 1; // 겹치는 부분이 아니라면 카운팅
						cnt++;
					}
				}
			}
		}

		System.out.println(cnt);
	}

}
