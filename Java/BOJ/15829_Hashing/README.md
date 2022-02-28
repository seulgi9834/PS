# BOJ_15829


### 1. 문제

https://www.acmicpc.net/problem/15829

---

### 2. 입력
```
5
abcde
```

---


### 3. 출력
```
4739715
```

---


### 4. 풀이
#### 요점

1.     모듈러 연산의 성질을 활용해야함

---


### 5. 시행착오 및 주의할 점
1.  모듈러 연산의 성질을 활용 안하면 문자열이 길어질 경우 범위를 초과함

---

### 6. 코드

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int L;
	static int r = 31;
	static int m = 1234567891;
	static long[] rList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		L = Integer.parseInt(br.readLine());
		String str = br.readLine();
		rList = new long[L];
		long answer = 0;

		rList[0] = 1;
		for (int i = 1; i < L; i++) {
			rList[i] = rList[i - 1] * r % m;
		}

		for (int i = 0; i < L; i++) {
			answer += (str.charAt(i) - 'a' + 1) * rList[i] % m;
			answer %= m;
		}

		System.out.println(answer);
	}

}

```



| 메모리  | 시간 | 언어   | 코드 길이 |
| ------- | ---- | ------ | --------- |
| 11520KB | 80ms | Java 8 | 654 B     |
