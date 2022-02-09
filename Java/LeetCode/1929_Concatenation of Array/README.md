# LeetCode_1929_Concatenation of Array
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
class Solution {
    public int[] getConcatenation(int[] nums) {
        int N = nums.length;
        int[] ans = new int[N*2];
        for(int i =0;i<ans.length;i++){
            ans[i]=nums[i%N];
        }
        return ans;
    }
}
```

| 메모리   | 시간  | 언어   | 코드 길이 |
| -------- | ----- | ------ | --------- |
| 109260KB | 621ms | Java 8 | 1652 B    |

