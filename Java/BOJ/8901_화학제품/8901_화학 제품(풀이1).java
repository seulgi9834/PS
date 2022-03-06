import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb;
	static int A, B, C, MAX;
	static int[] Price;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Price = new int[3];
			MAX = Integer.MIN_VALUE;
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			Price[0] = Integer.parseInt(st.nextToken());
			Price[1] = Integer.parseInt(st.nextToken());
			Price[2] = Integer.parseInt(st.nextToken());

			for (int i = 0; i <= Math.min(A, B); i++) {
				for (int r = 0; r <= Math.min(B - i, C); r++) {
					int temp = Math.min(A - i, C - r);
					MAX = Math.max(MAX, Price[0] * i + Price[1] * r + Price[2] * temp);
				}
			}

			sb.append(MAX + "\n");

		}
		System.out.println(sb);
	}

}
