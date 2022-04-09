import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> rightQueue = new LinkedList<>();
		Queue<Integer> leftQueue = new LinkedList<>();
		Queue<Integer> newQueue = new LinkedList<>();

		// 카드 초기 설정
		newQueue.add(2);
		for (int i = 0; i < 26; i++) {
			newQueue.add(1);
		}
		// 카드 N번 섞기
		for (int cnt = 0; cnt < N; cnt++) {
			boolean odd = true; // 홀수 짝수 확인
			int card = 0; // 카드의 수
			// 1. 왼쪽 13장, 오른쪽 14장
			for (int i = 0; i < 13; i++) {
				leftQueue.add(newQueue.poll());
			}
			for (int i = 0; i < 14; i++) {
				rightQueue.add(newQueue.poll());
			}

			// 2~3 반복
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (card < 27) {
				int cardNum = Integer.parseInt(st.nextToken());
				for (int j = 0; j < cardNum; j++) {
					if (odd) {
						newQueue.add(rightQueue.poll());
					} else {
						newQueue.add(leftQueue.poll());
					}
				}
				card += cardNum;
				odd = !odd;
			}

		}

		for (int i = 1; i <= 27; i++) {
			int n = newQueue.poll();
			if (n == 2) {
				System.out.println(i);
				break;
			}
		}

	}
}
