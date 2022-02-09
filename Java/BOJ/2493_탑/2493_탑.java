import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		Stack<arr> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			int tmp = Integer.parseInt(st.nextToken());

			while (!stack.isEmpty()) {
				if (stack.peek().H > tmp) {
					sb.append(stack.peek().idx).append(" ");
					break;
				}
				stack.pop();
			}
			if (stack.isEmpty()) {
				sb.append(0).append(" ");
			}
			stack.push(new arr(i, tmp));
		}
		System.out.println(sb);
	}

	static class arr {
		int idx;
		int H;

		public arr(int idx, int H) {
			this.idx = idx;
			this.H = H;
		}
	}
}
