import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, B, M, min, max, time, h;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		time = Integer.MAX_VALUE;
		h = Integer.MIN_VALUE;
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int r = 0; r < M; r++) {
				arr[i][r] = Integer.parseInt(st.nextToken());
				min = Math.min(min, arr[i][r]);
				max = Math.max(max, arr[i][r]);
			}
		}

		for (int i = min; i <= max; i++) {
			int sec = 0;
			int inven = B;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (arr[r][c] < i) {
						sec += (i - arr[r][c]);
						inven -= (i - arr[r][c]);
					} else if (arr[r][c] > i) {
						sec += (arr[r][c] - i) * 2;
						inven += (arr[r][c] - i);
					}
				}
			}
			if (inven >= 0&&time>=sec) {
				time = Math.min(time, sec);
				h = Math.max(h, i);
			}
		}

		System.out.println(time + " " + h);
	}

}
