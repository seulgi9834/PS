import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] cost = new int[C + 100];
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[0] = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int price = Integer.parseInt(st.nextToken());
			int person = Integer.parseInt(st.nextToken());
			for (int j = person; j < C + 100; j++) {
				if (cost[j - person] != Integer.MAX_VALUE) {
					cost[j] = Math.min(cost[j], cost[j - person] + price);
				}
			}
		}

		int answer = Integer.MAX_VALUE;
		for (int i = C; i < C + 100; i++) {
			answer = Math.min(answer, cost[i]);
		}
		System.out.println(answer);

	}
}
