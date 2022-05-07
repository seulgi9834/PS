import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, X;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		char[] str = new char[N];
		int sum = 0;

		// 조건을 만족하는 문자열이 없는 경우
		if (N * 26 < X || N > X) {
			System.out.println("!");
			return;
		}

		// 사전순 우선 환전이므로 사전순 가장 먼저 오는 A를 채워줌
		for (int i = 0; i < N; i++) {
			str[i] = 'A';
			sum += 'A' - 'A' + 1;
		}

		// 뒷부분부터 가치와 같은 문자열을 찾기 위해 A를 다른 문자로 변경함
		for (int i = N - 1; i >= 0; i--) {
			if (sum + 26 <= X) { // A를 Z로 변경해도 가치가 부족한 경우
				str[i] = 'Z'; // Z로 변경
				sum += 25;
			} else {
				// A를 다른 문자열로 변경하면 가치를 충족하는 경우
				str[i] = (char) (X - sum + 'A');
				sum = X;
			}
			if (sum == X) {
				for (int r = 0; r < N; r++) {
					sb.append(str[r]);
				}
				System.out.println(sb);
				return;
			}
		}

	}
}
