import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, K, day, max;
	static int[] chocolate;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		chocolate = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			chocolate[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = K + 1; i <= N; i++) {
		while (true) {
            if (chocolate[i] - chocolate[i - K] !=0) {
					day++; // 하루 증가
					max += chocolate[i] - chocolate[i - K]; // 초콜릿 먹은 수 카운트
					chocolate[i] = chocolate[i - K]; // 초콜릿 먹은 수 만큼 감소
					Arrays.sort(chocolate);// 오름차순 재정렬
				}
				else break;// 만약 더이상 초콜릿을 먹을 수 없다면
				}
		}
		System.out.println(max + " " + day);
/*		while (true) {
			// 1. 초콜릿 꺼내먹기
			int idx = -1; // 최대로 먹을 수 있는 초콜릿 통의 인덱스
			int temp = 0; // 인덱스를 찾기 위한 임시 변수
			for (int i = K + 1; i <= N; i++) {
				// 최대로 먹을 수 있는 초콜릿을 찾은 경우
				if (chocolate[i] - chocolate[i - K] > temp) {
					temp = chocolate[i] - chocolate[i - K];
					idx = i;
				}
			}
			System.out.println(idx +" "+temp);
			// 만약 더이상 초콜릿을 먹을 수 없다면
			if (idx == -1) {
				break; // 종료
			}
			day++; // 하루 증가
			max += chocolate[idx] - chocolate[idx - K]; // 초콜릿 먹은 수 카운트
			chocolate[idx] = chocolate[idx - K]; // 초콜릿 먹은 수 만큼 감소
			
			// 2. 오름차순 재정렬
			Arrays.sort(chocolate);
			
		}
*/		
	}

}
