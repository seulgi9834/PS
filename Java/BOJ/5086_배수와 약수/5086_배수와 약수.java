import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int A = -1;
		int B = -1;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			if (A == 0 && B == 0) {
				break;
			}
			if (A < B && B % A == 0) {
				sb.append("factor\n");
			} else if (A > B && A % B == 0) {
				sb.append("multiple\n");
			} else {
				sb.append("neither\n");
			}
		}
		System.out.println(sb);
	}
}
