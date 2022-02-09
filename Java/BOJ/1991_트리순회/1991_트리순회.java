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
