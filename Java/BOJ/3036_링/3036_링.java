

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] rings = new int[T];
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {
			rings[test_case] = Integer.parseInt(st.nextToken());
		}
		for (int test_case = 1; test_case < T; test_case++) {
			int uclid = uclid(Integer.max(rings[0], rings[test_case]), Integer.min(rings[0], rings[test_case]));
			sb.append(rings[0] / uclid + "/" + rings[test_case] / uclid + "\n");
		}
		System.out.println(sb);
	}

	static int uclid(int A, int B) {
		while (B > 0) {
			int temp = A;
			A = B;
			B = temp % B;
		}
		return A;
	}
}
