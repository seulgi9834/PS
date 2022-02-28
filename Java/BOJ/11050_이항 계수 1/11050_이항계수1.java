package day0228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[] factorial;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		factorial = new int[11];
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int answer = 0;

		for (int i = 1; i <= N; i++) {
			factorial[i] = recursion(i);
		}

		if (K == 0 || K == N) {
			answer = 1;
		} else {
			answer = factorial[N] / (factorial[N - K] * factorial[K]);
		}

		System.out.println(answer);
	}

	static int recursion(int n) {
		if (n == 1) {
			return 1;
		}
		return n * recursion(n - 1);
	}
}
