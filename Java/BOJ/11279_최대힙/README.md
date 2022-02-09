# BOJ_11279
### 1. 문제

https://www.acmicpc.net/problem/11279

---

### 2. 입력
```
13
0
1
2
0
0
3
2
1
0
0
0
0
0
```

---


### 3. 출력
```
0
2
1
3
2
1
0
0
```

---


### 4. 풀이
#### 요점

1.    PriorityQueue를 이용해 최대힙 구현

#### 풀이

1. 0이 아닌 값이 입력된다면 값을 추가
1. 0이 입력된다면 가장 큰값을 출력하고 그 값을 제거
1. 0이 입력되었지만 비어있다면 0을 출력

---


### 5. 시행착오 및 주의할 점
PriorityQueue를 사용해 간단하게 최소 힙, 최대 힙을 사용할 수 있다.

Collections.reverseOrder()를 사용하면 최대힙을 사용할 수 있다.

**추후 배열을 사용해 직접 구현할 계획이다.**

---

### 6. 코드

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		// 우선순위 큐를 이용해 최소 힙, 최대 힙 사용 가능
		// Collections.reverseOrder()를 사용해 최대힙으로 사용 가능
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if (tmp == 0) {
				if (maxHeap.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(maxHeap.poll()).append("\n");
				}
			} else {
				maxHeap.add(tmp);
			}
		}
		
		System.out.println(sb);
	}
}

```



| 메모리  | 시간  | 언어   | 코드 길이 |
| ------- | ----- | ------ | --------- |
| 25528KB | 292ms | Java 8 | 912 B     |

