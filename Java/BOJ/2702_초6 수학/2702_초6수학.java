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
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int min = Math.min(a, b);
			int gcf = 1; // 최대공약수

			for (int j = min; j >= 1; j--) {
				if (a % j == 0 && b % j == 0) {
					gcf = j;
					break;
				}
			}
			sb.append((a * b) / gcf + " " + gcf + "\n");
		}

		System.out.println(sb);
	}
}
