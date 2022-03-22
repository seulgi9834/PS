import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long X, Y, Z;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		Z = Y * 100 / X;
		int answer = 0;
		if (Z >= 99) {
			answer = -1;
		} else {
			answer = (int) Math.ceil((100 * Y - X * (Z + 1)) / (double) (Z - 99));
		}
		System.out.println(answer);
	}
}
