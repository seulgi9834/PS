import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		Stack<Character> stack = new Stack<>();
		for (int test_case = 1; test_case <= T; test_case++) {
			String str = br.readLine();
			int pipe = 0;
			char before = '.';
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (stack.isEmpty()) {
					stack.push(ch);
				} else {
					if (stack.peek() == '(' && ch == ')' && before == '(') {
						stack.pop();
						pipe += stack.size();
					} else if (stack.peek() == '(' && ch == ')' && before == ')') {
						stack.pop();
						pipe += 1;
					} else {
						stack.push(ch);
					}
				}
				before = ch;
			}
			sb.append("#" + test_case + " " + pipe + "\n");
		}
		System.out.println(sb);
	}
}
