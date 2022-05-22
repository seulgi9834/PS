import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static class work implements Comparable<work> {
		int T;
		int S;

		public work(int t, int s) {
			super();
			T = t;
			S = s;
		}

		@Override
		public int compareTo(work o) {
			if (o.S > S) {
				return 1;
			} else if (o.S < S) {
				return -1;
			} else
				return 0;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<work> arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			arr.add(new work(t, s));
		}
		arr.sort(null);
		int idx = arr.get(0).S - arr.get(0).T;
		for (int i = 1; i < arr.size(); i++) {
			if (arr.get(i).S >= idx) {
				idx = idx - arr.get(i).T;
			} else {
				idx = arr.get(i).S - arr.get(i).T;
			}
		}
		if (idx < 0) {
			System.out.println("-1");
		} else {
			System.out.println(idx);
		}
	}
}
