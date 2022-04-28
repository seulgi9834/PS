import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		String str = br.readLine();
		int size = str.length();

		Stack<Integer> stack = new Stack<>();

		int cnt = 0;
		for (int i = 0; i < size; i++) {
			int temp = str.charAt(i) - '0';
			// 넣으려고 하는 수보다 아래에 있는 수가 작지 않도록 정리
			while (!stack.isEmpty()) {
				if (cnt == K) {
					break;
				} else if (stack.peek() < temp) {
					stack.pop();
					cnt++;
				} else if (stack.peek() >= temp) {
					break;
				}
			}
			stack.push(temp);
		}

		if (cnt < K) { // 7 5 9929191와 같은 경우
			for (int i = 0; i < stack.size() - K + cnt; i++) {
				sb.append(stack.get(i));
			}
		} else {
			for (int i = 0; i < stack.size(); i++) {
				sb.append(stack.get(i));
			}
		}
		System.out.println(sb);
	}
}
