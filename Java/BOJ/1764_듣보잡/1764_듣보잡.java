import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		HashMap<String, Integer> map = new HashMap<>();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			map.put(str, 1);
		}

		for (int i = 1; i <= M; i++) {
			String str = br.readLine();
			if (map.containsKey(str)) {
				map.put(str, map.get(str) + 1);
			}
		}

		int cnt = 0;
		ArrayList<String> dictionary = new ArrayList<>();
		for (String key : map.keySet()) {
			if (map.get(key) >= 2) {
				cnt++;
				dictionary.add(key);
			}
		}
		System.out.println(cnt);
		Collections.sort(dictionary);
		for (String key : dictionary) {
			System.out.println(key);
		}
	}
}
