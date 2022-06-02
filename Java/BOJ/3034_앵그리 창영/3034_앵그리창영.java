import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		double len = Math.sqrt(Math.pow(W, 2) + Math.pow(H, 2));
		for (int i = 0; i < N; i++) {
			if (Integer.parseInt(br.readLine()) <= len) {
				sb.append("DA\n");
			} else {
				sb.append("NE\n");
			}
		}
		System.out.println(sb);
	}
}
