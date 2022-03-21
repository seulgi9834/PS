import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[10];
		int[] B = new int[10];
		char[] win = new char[10];
		int sum_A = 0;
		int sum_B = 0;

		for (int i = 0; i < 10; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 10; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < 10; i++) {
			if (A[i] > B[i]) {
				win[i] = 'A';
				sum_A += 3;
			} else if (A[i] < B[i]) {
				win[i] = 'B';
				sum_B += 3;
			} else {
				win[i] = 'D';
				sum_A += 1;
				sum_B += 1;
			}
		}
		char winner = 'D';
		if (sum_A > sum_B) {
			winner = 'A';
		} else if (sum_A < sum_B) {
			winner = 'B';
		} else {
			for (int i = 9; i >= 0; i--) {
				if (win[i] != 'D') {
					winner = win[i];
					break;
				}
			}
		}
		System.out.println(sum_A + " " + sum_B);
		System.out.println(winner);

	}
}
