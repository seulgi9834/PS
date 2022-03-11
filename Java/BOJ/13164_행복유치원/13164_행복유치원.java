import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_13164_행복유치원 {

	static int N, K;
	static int[] student;
	static int[] diff;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		student = new int[N];
		diff = new int[N];

		int result = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			student[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N - 1; i++) {
			diff[i] = student[i + 1] - student[i];
		}
		Arrays.sort(diff);

		for (int i = 1; i <= N - K; i++) {
			result += diff[i];
		}

		System.out.println(result);

	}
}
