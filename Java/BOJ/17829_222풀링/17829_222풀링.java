import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int[][] copyarr;
	static int N, size;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		copyarr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				copyarr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (N != 1) {
			int[][] smallarr = new int[N / 2][N / 2];
			for (int i = 0; i < N; i += 2) { // row
				for (int j = 0; j < N; j += 2) { // col
					ArrayList<Integer> temp = new ArrayList<>();
					temp.add(copyarr[i][j]);
					temp.add(copyarr[i][j + 1]);
					temp.add(copyarr[i + 1][j]);
					temp.add(copyarr[i + 1][j + 1]);
					temp.sort(null);
					smallarr[i / 2][j / 2] = temp.get(2);
				}
			}
			copyarr = new int[N / 2][N / 2];
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < N / 2; j++) {
					copyarr[i][j] = smallarr[i][j];
				}
			}
			N /= 2;
		}

		System.out.println(copyarr[0][0]);
	}
}
