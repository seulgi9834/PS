import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	static StringBuilder sb;

	/*
	 * 배열에 정수 입력 0이 입력으로 들어오면 배열에서 절댓값이 가장 작은 값을 출력후, 그 값을 제거->값출력 배열이 비어있으면 0 출력
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // 연산수
		Queue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o1) < Math.abs(o2)) {
					return -1;
				} else if (Math.abs(o1) > Math.abs(o2)) {
					return 1;
				} else if (Math.abs(o1) == Math.abs(o2)) {
					if (o1 < o2) {
						return -1;
					} else if (o1 > o2) {
						return 1;
					} else {
						return 0;
					}
				} else {
					return 0;
				}
			}

		});

		for (int i = 0; i < T; i++) {
			int temp = Integer.parseInt(br.readLine()); // 정수 입력
			if (temp == 0) {
				if (heap.isEmpty()) {
					sb.append("0\n");
				} else {
					sb.append(heap.remove() + "\n");
				}
			} else {
				heap.add(temp);
			}

		}
		System.out.println(sb);
	}
}
