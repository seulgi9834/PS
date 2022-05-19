import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		HashMap<String, Integer> map = new HashMap<>();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			map.put(str, i);
		}

		int cnt = 0;
		for (int i = 1; i <= M; i++) {
			String str = br.readLine();
			if (map.containsKey(str)) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}
