import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<pos> star;
	static ArrayList<node> nodes;
	static int[] parents;

	static class pos {
		double x;
		double y;

		public pos(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static class node implements Comparable<node> {
		int star1;
		int star2;
		Double distance;

		public node(int star1, int star2, double distance) {
			super();
			this.star1 = star1;
			this.star2 = star2;
			this.distance = distance;
		}

		@Override
		public int compareTo(node o) {
			if (o.distance > distance) {
				return -1;
			} else if (o.distance < distance) {
				return 1;
			} else
				return 0;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		star = new ArrayList<>();
		parents = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			parents[i] = i;
		}
		star.add(new pos(-1, -1));

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			star.add(new pos(x, y));
		}

		nodes = new ArrayList<>();
		for (int i = 1; i < n; i++) {
			for (int r = i + 1; r <= n; r++) {
				double dis = Math
						.sqrt(Math.pow(star.get(i).x - star.get(r).x, 2) + Math.pow(star.get(i).y - star.get(r).y, 2));
				nodes.add(new node(i, r, dis));
			}
		}

		Collections.sort(nodes); // 거리가 짧은 순으로 정렬

		double answer = 0;
		int cnt = 0;
		for (int i = 0; i < nodes.size(); i++) {
			
			if (find(nodes.get(i).star1) != find(nodes.get(i).star2) && cnt < n) {
				cnt++;
				union(nodes.get(i).star1, nodes.get(i).star2);
				answer += nodes.get(i).distance;
			}
		}
		System.out.printf("%.2f", answer);
	}

	static int find(int n) {
		if (parents[n] == n) {
			return n;
		}
		return parents[n] = find(parents[n]);
	}

	static void union(int star1, int star2) {
		int p1 = find(star1);
		int p2 = find(star2);

		if (p1 < p2) {
			parents[p2] = p1;
		} else {
			parents[p1] = p2;
		}
	}
}
