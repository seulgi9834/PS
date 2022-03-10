import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static class pos implements Comparable<pos> {
		int start;
		int end;

		public pos(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(pos position) {
			if (position.start < start) {
				return 1;
			} else if (position.start > start) {
				return -1;
			}
			return 0;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		ArrayList<pos> list = new ArrayList<>();
		double len = 0;

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(list);

		int S = list.get(0).start;
		int E = list.get(0).end;

		for (int i = 1; i < T; i++) {
			if (E >= list.get(i).start) {
				E = Math.max(E, list.get(i).end);
			} else {
				len += Math.abs(E - S);
				S = list.get(i).start;
				E = list.get(i).end;
			}
		}
		len += Math.abs(E - S);

		System.out.println((int) len);
	}
}
