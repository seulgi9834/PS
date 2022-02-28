# BOJ_11050


### 1. 문제

https://www.acmicpc.net/problem/11050

---

### 2. 입력
```
5 2
```

---


### 3. 출력
```
10
```

---


### 4. 풀이
#### 요점

1.    계산한 팩토리얼 값은 배열에 저장해 둔다.(재사용하기 위해)

---


### 5. 시행착오 및 주의할 점
![image-20220228231952150](C:\Users\seulgi\AppData\Roaming\Typora\typora-user-images\image-20220228231952150.png)

> K=0 or K = N인 경우는 1

- 다른 방법으로도 풀이가 가능하다. 

---

### 6. 코드

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[] factorial;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		factorial = new int[11];
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int answer = 0;

		for (int i = 1; i <= N; i++) {
			factorial[i] = recursion(i);
		}

		if (K == 0 || K == N) {
			answer = 1;
		} else {
			answer = factorial[N] / (factorial[N - K] * factorial[K]);
		}

		System.out.println(answer);
	}

	static int recursion(int n) {
		if (n == 1) {
			return 1;
		}
		return n * recursion(n - 1);
	}
}

```



| 메모리  | 시간 | 언어   | 코드 길이 |
| ------- | ---- | ------ | --------- |
| 11528KB | 76ms | Java 8 | 809 B     |
