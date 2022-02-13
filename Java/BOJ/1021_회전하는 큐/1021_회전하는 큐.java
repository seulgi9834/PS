import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		LinkedList<Integer> deque = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			deque.offer(i);
		}

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			int idx = deque.indexOf(tmp);
			
			if(deque.size()/2>=idx) {
				while(tmp!=deque.peek()) {
					deque.add(deque.poll());
					cnt++;
				}
			}
			else {
				while(tmp!=deque.peek()) {
					deque.addFirst(deque.pollLast());
					cnt++;
				}
			}
			deque.poll();
		}

		System.out.println(cnt);
	}
}
