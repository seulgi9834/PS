import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb;
	static int L, C;
	static char[] arr;
	static char[] result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		result = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		combination(0, 0);
		System.out.println(sb);
	}

	public static void combination(int cnt, int idx) {
		if (cnt == L) {
			int vowel = 0;
			int consonant = 0;
			for (int i = 0; i < cnt; i++) {
				if (result[i] == 'a' || result[i] == 'e' || result[i] == 'i' || result[i] == 'o' || result[i] == 'u') {
					vowel++;
				} else {
					consonant++;
				}
			}
			if (vowel >= 1 && consonant >= 2) {
				for (int i = 0; i < cnt; i++) {
					sb.append(result[i]);
				}
				sb.append("\n");
			}
			return;
		}
		for (int i = idx; i < C; i++) {
			result[cnt] = arr[i];
			combination(cnt + 1, i + 1);
		}
	}

}
