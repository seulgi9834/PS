# BOJ_7569


### 1. 문제

https://www.acmicpc.net/problem/7569

---

### 2. 입력
```
5 3 2
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 1 0 0
0 0 0 0 0
```

---


### 3. 출력
```
4
```

---


### 4. 문제 이해
![KakaoTalk_20220225_105630559](C:\Users\seulgi\Desktop\KakaoTalk_20220225_105630559.gif)

---


### 5. 시행착오 및 주의할 점
- 3차원으로 너비 우선 탐색을 진행하면 됨
- 7576_토마토 문제와 유사함

---

### 6. 코드

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int M, N, H, day;
	static int[][][] box;
	static int[][] dir = { { -1, 0, 0 }, { 1, 0, 0 }, { 0, -1, 0 }, { 0, 1, 0 }, { 0, 0, -1 }, { 0, 0, 1 } }; 
	// 앞, 뒤, 상, 하, 좌, 우
	static Queue<position> queue;

	static class position {
		int row;
		int col;
		int h;

		public position(int row, int col, int h) {
			super();
			this.row = row;
			this.col = col;
			this.h = h;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로
		H = Integer.parseInt(st.nextToken()); // 높이
		box = new int[H][N][M]; // 토마토를 담는 박스
		day = Integer.MIN_VALUE;
		queue = new LinkedList<>();
		boolean chk = true; // 안 익은 토마토 검증용

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if (box[i][j][k] == 1) { // 익은 토마토 큐에 추가
						queue.add(new position(j, k, i));
					}
				}
			}
		}
		
		bfs();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (box[i][j][k] == 0) {
						chk = false; // 토마토가 안 익은 경우
					} else {
						day = Math.max(day, box[i][j][k]); // 익는데 가장 오래 걸린 토마토 찾기
					}
				}
			}
		}

		if (day == 1) { // 처음부터 토마토가 모두 익은 경우
			System.out.println(0);
		} else if (!chk) { // 토마토가 안 익은 경우
			System.out.println(-1);
		} else { // 1부터 시작했기 때문에 1을 제거
			System.out.println(day - 1);
		}

	}

	static void bfs() {
		while (!queue.isEmpty()) { // 익은 토마토 주변 탐색
			position pos = queue.poll();
			int row = pos.row;
			int col = pos.col;
			int height = pos.h;
			for (int i = 0; i < 6; i++) {
				int newH = height + dir[i][0];
				int newR = row + dir[i][1];
				int newC = col + dir[i][2];
				
                // 유효성 검사
				if (newH >= 0 && newH < H && newR >= 0 && newR < N 
                    && newC >= 0 && newC < M) {
					
                    if (box[newH][newR][newC] == 0) { // 익지 않은 토마토가 있다면
						
                        queue.add(new position(newR, newC, newH)); 
                        // 익은 토마토를 담는 큐에 추가
						
                        box[newH][newR][newC] = box[height][row][col] + 1; 
                        // 토마토가 익는데 걸리는 기간
					}
				}

			}

		}
	}

}

```



| 메모리    | 시간   | 언어   | 코드 길이 |
| --------- | ------ | ------ | --------- |
| 121448 KB | 620 ms | Java 8 | 2732 B    |
