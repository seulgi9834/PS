import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, d, k, c, answer;
	static int[] sushi;
	static int[] dish;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 초밥 벨트에 놓인 접시의 수
		d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		answer = 0;
		int max = 0;
		sushi = new int[N + k]; // 벨트 위 초밥
		dish = new int[d + 1];// 먹은 초밥 종류 확인

		for (int i = 0; i < N; i++) { // 초밥 담기
			sushi[i] = Integer.parseInt(br.readLine());
		}
		for (int i = N; i < N + k; i++) {
			sushi[i] = sushi[i - N];
		}

		for (int i = 0; i < k; i++) { // 연속으로 k개 먹어보기
			if (dish[sushi[i]] == 0) { // 먹지 않은 종류의 초밥이면 카운트
				answer++;
			}
			dish[sushi[i]]++;
		}
		int coupon = answer;
		if (dish[c] == 0) { // 먹은것 중에 쿠폰에 있는 메뉴가 없다면 추가
			coupon++;
		}

		max = Integer.max(coupon, answer);

		for (int i = k; i < N + k; i++) {
			if (dish[sushi[i]] == 0) { // 먹은 초밥 중 같은 종류가 없는 경우
				answer++;
				dish[sushi[i]]++;
			} else if (dish[sushi[i]] >= 1) { // 종류가 겹치는 경우
				dish[sushi[i]]++;
			}

			if (dish[sushi[i - k]] == 1) { // 중복되는 종류가 없을 때 먼저 먹은 초밥 종류 차감
				answer--;
				dish[sushi[i - k]]--;
			} else if (dish[sushi[i - k]] > 1) { // 중복되는 종류의 초밥을 먹었을 때 초밥 차감
				dish[sushi[i - k]]--;
			}
			coupon = answer;
			if (dish[c] == 0) { // 먹은것 중에 쿠폰에 있는 메뉴가 없다면 추가
				coupon++;
			}

			max = Integer.max(coupon, max);

		}
		System.out.println(max);
	}
}
