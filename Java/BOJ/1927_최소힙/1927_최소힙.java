import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		// 우선순위 큐를 이용해 최소 힙, 최대 힙 사용 가능
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();

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
