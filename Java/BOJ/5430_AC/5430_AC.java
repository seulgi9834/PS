import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int T, N;
	static String command, nums;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			command = br.readLine();
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), "[],");
			AC();
		}
		System.out.println(sb);
	}

	static void AC() {
		Deque<Integer> queue = new ArrayDeque<>();
		boolean flag = true; // 정방향, false: 역방향
		for (int i = 0; i < N; i++) {
			queue.add(Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < command.length(); i++) {
			if (command.charAt(i) == 'R') {
				flag = !flag; // 뒤집기
			} else if (command.charAt(i) == 'D') {
				if (queue.isEmpty()) { // 배열이 비어있는데 버리면 error
					sb.append("error\n");
					return;
				} else if (flag) { // 정방향 기준 앞에서 버리기
					queue.pollFirst();
				} else if (!flag) { // 역방향 기준 앞에서 버리기(정방향 기준 마지막 값 버리기)
					queue.pollLast();
				}
			}
		}

		// 출력
		sb.append("[");
		int temp = queue.size();
		for (int i = 0; i < temp; i++) {
			if (flag) { // 정방향인 경우 정방향으로 출력
				sb.append(queue.pollFirst());
			} else { // 역방향인 경우 역방향으로 출력(역방향이 앞이기 때문)
				sb.append(queue.pollLast());
			}
			if (i != temp - 1) {
				sb.append(",");
			}
		}
		sb.append("]\n");
	}
}
