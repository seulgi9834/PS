import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long n = Long.parseLong(st.nextToken());
			long m = Long.parseLong(st.nextToken());
			long d = 0;

			while (true) {
				n /= 2;
				d++;
				if (n == 0) {
					break;
				}
			}
			sb.append((d + m) + "\n");
		}
		System.out.println(sb);
	}
}
