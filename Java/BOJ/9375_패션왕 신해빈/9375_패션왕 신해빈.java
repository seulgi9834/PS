import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			HashMap<String, Integer> map = new HashMap<>();
			int n = Integer.parseInt(br.readLine());
			int answer = 1;
			for (int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String w1 = st.nextToken();
				String w2 = st.nextToken();

				if (!map.containsKey(w2)) {
					map.put(w2, 1);
				} else {
					map.put(w2, map.get(w2) + 1);
				}
			}

			for (int r : map.values()) {
				answer = answer * (r + 1);
			}
			answer -= 1;
			sb.append(answer+"\n");
		}
		System.out.println(sb);
	}
}
