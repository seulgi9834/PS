import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(br.readLine());

		int totalM = 0;

		totalM += A * 60;
		totalM += B;
		totalM += C;

		if (totalM >= 60 * 24) {
			int temp = totalM / 60;
			totalM = totalM % 60;
			sb.append(temp % 24 + " ");
		} else {
			sb.append(totalM / 60 + " ");
			totalM = totalM % 60;
		}
		sb.append(totalM);
		System.out.println(sb);
	}
}
