import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		LinkedList<Integer> queue = new LinkedList<>();
		
		sb.append("<");
		
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		while (queue.size() > 1) {
			for (int i = 0; i < K - 1; i++) {
				int tmp = queue.poll();
				queue.add(tmp);
			}
			sb.append(queue.poll()).append(", ");
		}
		
		sb.append(queue.poll()).append(">");
		System.out.println(sb);
	}

}
