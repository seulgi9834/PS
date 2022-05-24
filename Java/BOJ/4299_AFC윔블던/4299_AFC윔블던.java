import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Sum = Integer.parseInt(st.nextToken());
		int Diff = Integer.parseInt(st.nextToken());
		if (Sum - Diff == 0) {
			System.out.println(Sum + " 0");
			return;
		} else if (Sum < Diff) {
			System.out.println("-1");
			return;
		} else {
			int a = (Sum + Diff) / 2;
			int b = Sum - a;
			if (a + b != Sum || a - b != Diff) {
				System.out.println("-1");
			} else {
				System.out.println(Math.max(a, b) + " " + Math.min(a, b));
			}
		}
	}
}
