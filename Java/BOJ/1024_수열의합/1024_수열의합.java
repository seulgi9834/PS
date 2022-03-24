

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


	static boolean chk;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		chk = true;
		String str = "";
		while (L <= 100) {
			long temp = (N / L) - (L - 1) / 2;

			if (temp < 0)
				break;
			if (N == (temp * 2 + L - 1) * L / 2) {
				for (int j = 0; j < L; j++) {
					str += (temp + j) + " ";
				}
				chk = false;
				break;
			}
			L += 1;
		}

		if (chk != false)
			System.out.println(-1);
		else
			System.out.println(str);
	}

}
