import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int test = Integer.parseInt(br.readLine());

		for (int i = 0; i < test; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			double sum = 1;
			for (int r = b; r > a; r--) {
				sum *= r;
			}
			for (int r = 1; r <= b - a; r++) {
				sum /= r;
			}

			System.out.printf("%.0f\n", sum);
		}
	}
}
