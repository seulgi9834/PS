import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[T];
		int[] Lrr = new int[T];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < T; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < T; i++) {
			Lrr[i] = 1;
			for (int j = 0; j < T; j++) {
				if (Lrr[i] <= Lrr[j] && arr[i] < arr[j]) {
					Lrr[i] += 1;
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < T; i++) {
			if (max < Lrr[i]) {
				max = Math.max(max, Lrr[i]);
			}
		}
		System.out.println(max);
	}
}
