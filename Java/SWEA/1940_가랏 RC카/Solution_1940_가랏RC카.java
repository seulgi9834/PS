import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int L = Integer.parseInt(br.readLine());
			int current = 0;
			int meter = 0;
			for (int i = 0; i < L; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				if (command == 0) {
					meter += current;
				} else if (command == 1) {
					int speed = Integer.parseInt(st.nextToken());
					current += speed;
					meter += current;
				} else if (command == 2) {
					int speed = Integer.parseInt(st.nextToken());
					if (current < speed) {
						current = 0;
					} else {
						current -= speed;
					}
					meter += current;
				}
			}
			sb.append("#" + test_case + " " + meter + "\n");
		}
		System.out.println(sb);
	}
}
