import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb;
	static int N, L;
	static boolean chk;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		chk = true;
		int answer = -1;
		for (int i = L; i <= 100; i++) {
			long temp = (i * (i - 1)) / 2;
			int idx = 0;

			while (chk) {
				if (temp > N)
					break;
				if (temp == N) {
					for (int j = 0; j < i; j++) {
						sb.append(j + idx + " ");
					}
					chk = false;
					break;
				}
				temp += i;
				idx += 1;
			}
		}

		if (chk != false)
			System.out.println(answer);
		else
			System.out.println(sb);
	}

}
