# BOJ_18111


### 1. 문제

https://www.acmicpc.net/problem/18111

---

### 2. 입력
```
3 4 1
64 64 64 64
64 64 64 64
64 64 64 63
```

---


### 3. 출력
```
1 64
```

---


### 4. 풀이
1.  땅의 높이가 최소인 경우, 최대인 경우를 파악함
2. 가장 맨 위의 블록을 제거해서 인벤토리에 넣거나, 인벤토리에서 블록 하나를 꺼내어 가장 위에 있는 블록 위에 놓는 작업을 진행했을 경우의 시간을 구함(최소-최대 높이가 될 때까지 땅 고르기, 이때 인벤토리의 블록이 부족해도 블록 꺼내기를 진행함)
3. 만약 기존 기록보다 시간이 짧거나 같고, 인벤이 0보다 크거나 같다면(인벤토리가 부족하지 않을 경우) 최단 시간을 갱신하고, 높이를 저장함

---


### 5. 시행착오 및 주의할 점
- 최단 시간을 찾기 위한 조건 설정을 주의해야 함(인벤 값만 기준으로 했다면, 높이 저장에서 문제가 발생함)

---

### 6. 코드

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, B, M, min, max, time, h;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		time = Integer.MAX_VALUE;
		h = Integer.MIN_VALUE;
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int r = 0; r < M; r++) {
				arr[i][r] = Integer.parseInt(st.nextToken());
				min = Math.min(min, arr[i][r]);
				max = Math.max(max, arr[i][r]);
			}
		}

		for (int i = min; i <= max; i++) {
			int sec = 0;
			int inven = B;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (arr[r][c] < i) {
						sec += (i - arr[r][c]);
						inven -= (i - arr[r][c]);
					} else if (arr[r][c] > i) {
						sec += (arr[r][c] - i) * 2;
						inven += (arr[r][c] - i);
					}
				}
			}
			if (inven >= 0&&time>=sec) {
				time = Math.min(time, sec);
				h = Math.max(h, i);
			}
		}

		System.out.println(time + " " + h);
	}

}
```



| 메모리  | 시간  | 언어   | 코드 길이 |
| ------- | ----- | ------ | --------- |
| 34572KB | 632ms | Java 8 | 1354 B    |
