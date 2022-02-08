# BOJ_1991_트리 순회
### 1. 문제

https://www.acmicpc.net/problem/1991

---

### 2. 입력
```
7
A B C
B D .
C E F
E . .
F . G
D . .
G . .
```

---


### 3. 출력
```
ABDCEFG
DBAECFG
DBEGFCA
```

---


### 4. 풀이
#### 요점

1.    이진트리를 직접 구현
2.    트리 생성 로직을 고민할 필요가 있음

#### 풀이

1. 주석으로 대체

---


### 5. 시행착오 및 주의할 점
노드 구현 방법이 감이 안와서 고민했다.

그리고 객체를 생성하면 된다는걸 뒤늦게 깨달았다.

---

### 6. 코드

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Tree tree = new Tree();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			tree.add(st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0));
		}
		tree.preorder(tree.Root);
		sb.append("\n");
		tree.inorder(tree.Root);
		sb.append("\n");
		tree.postorder(tree.Root);
		System.out.println(sb);
	}

	static class Node { // 노드
		Node Left;
		Node Right;
		char data;

		public Node(char data) {
			this.data = data;
		}
	}

	static class Tree {
		Node Root;

		public void add(char data, char Ldata, char Rdata) {
			if (Root == null) { // 루트가 없다면 루트 생성
				if (data != '.') {
					Root = new Node(data);

					if (Ldata != '.') {
						Root.Left = new Node(Ldata);
					}
					if (Rdata != '.') {
						Root.Right = new Node(Rdata);
					}
				}
			} else {
				search(Root, data, Ldata, Rdata); // 루트가 있다면 삽입할 위치를 탐색
			}

		}

		public void search(Node Root, char data, char Ldata, char Rdata) {
			if (Root == null) { // 노드가 없는 경우
				return;
			} else if (Root.data == data) { // 노드를 삽입할 위치를 찾았을 경우
				if (Ldata != '.') {
					Root.Left = new Node(Ldata);
				}
				if (Rdata != '.') {
					Root.Right = new Node(Rdata);
				}
			} else {
				search(Root.Left, data, Ldata, Rdata); // 왼쪽 탐색
				search(Root.Right, data, Ldata, Rdata); // 오른쪽 탐색
			}
		}

		// 전위 순회: (루트)(왼쪽자식)(오른쪽자식)
		public void preorder(Node Root) {
			sb.append(Root.data); // 해당 위치 출력
			if (Root.Left != null) {
				preorder(Root.Left);
			}
			if (Root.Right != null) {
				preorder(Root.Right);
			}
		}

		// 중위 순회 : (왼쪽자식)(루트)(오른쪽자식)
		public void inorder(Node Root) {
			if (Root.Left != null) {
				inorder(Root.Left);
			}
			sb.append(Root.data); // 해당 위치 출력
			if (Root.Right != null) {
				inorder(Root.Right);
			}
		}

		// 후위 순회 : (왼쪽자식)(오른쪽자식)(루트)
		public void postorder(Node Root) {
			if (Root.Left != null) {
				postorder(Root.Left);
			}
			if (Root.Right != null) {
				postorder(Root.Right);
			}
			sb.append(Root.data); // 해당 위치 출력
		}

	}

}

```

