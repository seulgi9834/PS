import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		HashMap<Integer, Integer> sub_A = new HashMap<>();
		HashMap<Integer, Integer> sub_B = new HashMap<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {
			int temp = Integer.parseInt(st.nextToken());
			sub_A.put(temp, temp);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < B; i++) {
			int temp = Integer.parseInt(st.nextToken());
			sub_B.put(temp, temp);
		}

		int cnt_A = 0;
		int cnt_B = 0;

		for (int key : sub_A.keySet()) {
			if (sub_B.containsKey(key)) {
				cnt_A++;
			}
		}
		for (int key : sub_B.keySet()) {
			if (sub_A.containsKey(key)) {
				cnt_B++;
			}
		}
		System.out.println(A - cnt_A + B - cnt_B);
	}
}
