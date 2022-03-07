import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dice;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			dice = new int[3];
			dice[0] = Integer.parseInt(st.nextToken());
			dice[1] = Integer.parseInt(st.nextToken());
			dice[2] = Integer.parseInt(st.nextToken());
			max = Math.max(max, money());
		}
		System.out.println(max);
	}

	static int money() {
		if (dice[0] == dice[1] && dice[1] == dice[2]) {
			return 10000 + dice[0] * 1000;
		} else if (dice[0] == dice[1] || dice[1] == dice[2] || dice[0] == dice[2]) {
			if (dice[0] == dice[1]) {
				return 1000 + dice[0] * 100;
			} else if (dice[1] == dice[2]) {
				return 1000 + dice[1] * 100;
			} else {
				return 1000 + dice[2] * 100;
			}
		} else {
			int maxDice = Math.max(dice[0], dice[1]);
			maxDice = Math.max(maxDice, dice[2]);
			return maxDice * 100;
		}
	}
}
