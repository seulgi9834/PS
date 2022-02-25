import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13300_방배정 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int room = 0;
		int[][] student = new int[2][7];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			student[gender][grade]++;
		}

		for (int i = 0; i < 2; i++) {
			for (int j = 1; j <= 6; j++) {
				if (student[i][j] % K == 0) {
					room += student[i][j] / K;
				} else {
					room += student[i][j] / K + 1;
				}
			}
		}
		System.out.println(room);
	}
}
