import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] student = new int[4][4]; // 후보, 점수, 빈도
		int[] sum = new int[4];
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 3; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 1) {
					student[j][1]++;
					sum[j] += 1;
				} else if (temp == 2) {
					student[j][2]++;
					sum[j] += 2;
				} else if (temp == 3) {
					student[j][3]++;
					sum[j] += 3;
				}
			}

		}
		int elected = 1;
		boolean flag = false;
		for (int i = 1; i <= 3; i++) {
			if (i != elected) {
				if (sum[i] > sum[elected]) {
					elected = i;
					flag = false;
				} else if (sum[i] == sum[elected]) {
					if (student[i][3] > student[elected][3]) {
						elected = i;
						flag = false;
					} else if (student[i][3] == student[elected][3]) {
						if (student[i][2] > student[elected][2]) {
							elected = i;
							flag = false;
						} else if (student[i][2] == student[elected][2]) {
							elected = i;
							flag = true;
						} else if (student[i][2] > student[elected][2]) {
							elected = i;
							flag = false;
						}
					} else if (student[i][3] < student[elected][3]) {
						continue;
					}
				} else if (sum[i] < sum[elected]) {
					continue;
				}
			}
		}
		if (flag) {
			Arrays.sort(sum);
			System.out.println("0 " + sum[3]);
		} else {
			System.out.println(elected + " " + sum[elected]);
		}
	}
}
