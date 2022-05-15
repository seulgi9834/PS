import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		int num = 0;
		boolean flag = false;

		String str = br.readLine();
		Map<String, Integer> map = new HashMap();
		for (int i = 0; i < N - 1; i++) {
			str = br.readLine();
			if (str.equals("ENTER")) {
				map = new HashMap();
			} else {
				if (!map.containsKey(str)) {
					map.put(str, ans);
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}
