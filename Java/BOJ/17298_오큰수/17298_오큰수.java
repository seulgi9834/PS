import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] idx = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			idx[i] = -1;
			arr[i] = Integer.parseInt(st.nextToken());

		}
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for (int i = 1; i < N; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				idx[stack.pop()] = arr[i];
			}
			stack.push(i);
		}
		for (int i = 0; i < N; i++) {
			sb.append(idx[i] + " ");

		}
		System.out.println(sb);
	}
}
