import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int cnt = 1;
		int[][] list = new int[T][2];
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list[t][0] = Integer.parseInt(st.nextToken());
			list[t][1] = Integer.parseInt(st.nextToken());
		}

		// 최고 온도 기준 오름차순 정렬
		Arrays.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		int Max = list[0][1]; // 화학물질 중 가장 낮은 최고 보관 온도

		for (int i = 1; i < T; i++) {
			// 이미 최고 온도 보관온도는 정렬이 끝났기 때문에 최저 온도와 비교
			// 냉장고의 최고온도보다 화학물질의 최저 보관 온도가 더 크면 냉장고가 필요함
			// 최고 온도 변경
			if (Max < list[i][0]) {
				cnt++;
				Max = list[i][1];
			}
		}

		System.out.println(cnt);
	}
}
