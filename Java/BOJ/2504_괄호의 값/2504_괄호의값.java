import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int answer = 0;
		Stack<Character> stack = new Stack<>(); // 괄호를 위한 스택
		Stack<Integer> num = new Stack<>(); // 계산을 위한 스택

		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);

			if (stack.isEmpty()) {
				stack.add(temp);
				continue;
			}

			else if (temp == '(' || temp == '[') {
				stack.add(temp);
				continue;
			}

			else if (temp == ')') {
				if (stack.peek() == 'x') {
					int tempNum = num.pop();
					stack.pop(); // 변수 제거
					if (!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
						tempNum *= 2;
						if (!stack.isEmpty() && !num.isEmpty() && stack.peek() == 'x') {
							tempNum += num.pop();
							stack.pop();
						}
						num.add(tempNum);
						stack.add('x');
					}
				} else if (!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
					// 실수한 부분
					if (!stack.isEmpty() && !num.isEmpty() && stack.peek() == 'x') {
						num.add(num.pop() + 2);
						stack.pop();
					} else {
						num.add(2);
					}
					stack.add('x');
				}
			}

			else if (temp == ']') {
				if (stack.peek() == 'x') {
					int tempNum = num.pop();
					stack.pop(); // 변수 제거
					if (!stack.isEmpty() && stack.peek() == '[') {
						stack.pop();
						tempNum *= 3;
						if (!stack.isEmpty() && !num.isEmpty() && stack.peek() == 'x') {
							tempNum += num.pop();
							stack.pop();
						}
						num.add(tempNum);
						stack.add('x');
					}
				} else if (!stack.isEmpty() && stack.peek() == '[') {
					stack.pop();
					if (!stack.isEmpty() && !num.isEmpty() && stack.peek() == 'x') {
						num.add(num.pop() + 3);
						stack.pop();
					} else {
						num.add(3);
					}
					stack.add('x');
				}
			}

		}

		if (!stack.isEmpty() && !num.isEmpty()) {
			stack.pop(); // 마지막 x값을 pop
			answer = num.pop();
		}
		if (!stack.isEmpty()) { // 입력이 올바르지 못한 괄호열
			answer = 0;
		}

		System.out.println(answer);
	}
}
