import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] arr;
	static int[] temp;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9]; // 입력값
		temp = new int[7]; // 일곱 난쟁이

		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine()); // 한줄씩 입력 받기
		}

		select(0, 0);
		System.out.println(sb);

	}

	public static void select(int cnt, int idx) { // 조합을 이용해서 풀이 cnt: 선택한 횟수, idx: 탐색을 시작할 인덱스
		if (cnt == 7) { // 일곱 난쟁이이므로 7
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += temp[i];
			}
			if (sum == 100) { // 모자의 합이 100인 경우
				for (int i = 0; i < 7; i++) {
					sb.append(temp[i] + "\n");
				}
			}
			return;
		}
		for (int i = idx; i < 9; i++) { // 인덱스부터 순회하면서 숫자 선택
			temp[cnt] = arr[i];
			select(cnt + 1, i + 1);
		}
	}
}
