import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int L;
	static int r = 31;
	static int m = 1234567891;
	static long[] rList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		L = Integer.parseInt(br.readLine());
		String str = br.readLine();
		rList = new long[L];
		long answer = 0;

		rList[0] = 1;
		for (int i = 1; i < L; i++) {
			rList[i] = rList[i - 1] * r % m;
		}

		for (int i = 0; i < L; i++) {
			answer += (str.charAt(i) - 'a' + 1) * rList[i] % m;
			answer %= m;
		}

		System.out.println(answer);
	}

}
