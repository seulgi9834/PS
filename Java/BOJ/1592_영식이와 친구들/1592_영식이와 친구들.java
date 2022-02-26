import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[] ball = new int[N + 1];

		int cnt = 0;
		int sum = 0;
		int i = 0;
		while (cnt < M) {

			if (ball[i] % 2 == 1) {
				if (i + L >= N) {
					i = i + L - N;
				} else {
					i = i + L;
				}
				ball[i] += 1;
				sum += 1;
				cnt = Math.max(cnt, ball[i]);
			} else if (ball[i] % 2 == 0) {
				if (i - L < 1) {
					i = i - L + N;
				} else {
					i = i - L;
				}
				ball[i] += 1;
				sum += 1;
				cnt = Math.max(cnt, ball[i]);
			}
		}
		System.out.println(sum - 1);
	}
}
