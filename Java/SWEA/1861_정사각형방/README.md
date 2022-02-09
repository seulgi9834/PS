# SWEA_1861_정사각형 방
### 1. 문제

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LtJYKDzsDFAXc

---

### 2. 입력
```
2
2
1 2
3 4
3
9 3 4
6 1 5
7 8 2
```

---


### 3. 출력
```
#1 1 2
#2 3 3
```

---


### 4. 풀이
#### 요점

1.    사방탐색을 잘 해야함
2.    재귀를 사용함

#### 풀이(수정필요)

1. 탐색할 수 있는 범위를 고려해서 탐색을 진행한다.
2. 사방탐색을 해서 이동할 수 있는 범위의 값이 현재값 +1이라면 1을 더하고 이동한다.
3. 이동한 곳에서도 2번을 반복한다. 

---


### 5. 시행착오 및 주의할 점
DFS를 사용해서 풀 수 있다고 한다.

나는 사방탐색과 재귀를 사용해서 풀었다.

사방 탐색에 대해 복습할 수 있어서 좋았다.

---

### 6. 코드

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[][] room;
	static int[][] cnt;
	static boolean[][] chk;

	static int N, min, max, mr, mc;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			min = Integer.MAX_VALUE;
			max = 0;
			room = new int[N][N];
			cnt = new int[N][N];
			chk = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int r = 0; r < N; r++) {
					room[i][r] = Integer.parseInt(st.nextToken());
				}
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					cnt[r][c] = search(r, c, 1);
					if (cnt[r][c] > max) {
						max = cnt[r][c];
						min = room[r][c];
					} else if (cnt[r][c] == max && min > room[r][c]) {
						min = room[r][c];
					}

				}
			}
			sb.append("#").append(test_case).append(" ").append(min).append(" ").append(max).append("\n");

		}

		System.out.println(sb);
	}

	static int search(int x, int y, int cnt) {
		int[][] search = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우
		for (int i = 0; i < search.length; i++) {
			int nr = x + search[i][0]; // 행
			int nc = y + search[i][1]; // 열
			if (nr >= N || nr < 0) {
				continue;
			}
			if (nc >= N || nc < 0) {
				continue;
			}
			if (!chk[nr][nc]) {
				if (room[x][y] + 1 == room[nr][nc]) {
					chk[nr][nc] = true;
					cnt++;
					cnt = search(nr, nc, cnt);
				}
			}
		}
		return cnt;
	}
}

```

| 메모리   | 시간  | 언어   | 코드 길이 |
| -------- | ----- | ------ | --------- |
| 109260KB | 621ms | Java 8 | 1652 B    |

