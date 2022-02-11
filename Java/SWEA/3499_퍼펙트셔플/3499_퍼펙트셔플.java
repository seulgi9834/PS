import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			String[] arr = new String[N];
			for (int i = 0; i < N; i++) {
				arr[i] = st.nextToken();
			}

			sb.append("#").append(test_case).append(" ");
			if (N % 2 != 0) {
				for (int i = 0, r = N / 2 + 1; i < N / 2; i++, r++) {
					sb.append(arr[i]).append(" ");
					sb.append(arr[r]).append(" ");
				}
				sb.append(arr[N / 2]).append(" ");
			} else {
				for (int i = 0, r = N / 2; i < N / 2; i++, r++) {
					sb.append(arr[i]).append(" ");
					sb.append(arr[r]).append(" ");
				}
			}

			sb.append("\n");
		}

		System.out.println(sb);
	}
}
