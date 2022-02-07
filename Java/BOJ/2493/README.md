# BOJ_2493
### 1. 문제

https://www.acmicpc.net/problem/2493

---

### 2. 입력
```
5
6 9 5 7 4
```

---


### 3. 출력
```
0 0 2 2 4 
```

---


### 4. 풀이
#### 요점

1.    Stack을 사용한다.
2.    로직을 잘 생각해야한다.

#### 풀이

1. 탑의 위치와 높이를 저장하기 위해 객체를 생성함
2. 현재 탑보다 높은 탑이 있다면 높은 탑의 위치를 출력함
3. 높은탑이 없다면, 높은 탑이 나올때까지 탐색을 진행하고 0을 출력

---


### 5. 시행착오 및 주의할 점
처음에 문제 자체는 이해 했지만, 어떤 방식으로 풀어야할지 고민했다.

동생이랑 같이 풀면서 해결했다. 재미있었다.

---

### 6. 코드

```java
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
```

