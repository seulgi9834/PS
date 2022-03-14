import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		int day = (N-1) / T;

		System.out.println(day * C * P);
	}
}
