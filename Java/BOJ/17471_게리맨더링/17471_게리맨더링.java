import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, MIN;
	static ArrayList<Integer>[] arr;
	static int[] people;
	static boolean[] visited;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		people = new int[N + 1]; // 인구수
		arr = new ArrayList[N + 1]; // 인접 지역 담는 ArrayList
		visited = new boolean[N + 1];
		MIN = Integer.MAX_VALUE; // 인구차이 최솟값

		// 인구 추가
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			arr[i] = new ArrayList<>();
		}

		// 인접지역 담기
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				arr[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		subset(1);

		if (MIN == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(MIN);
		}
	}

	// 선거구를 나누기 위한 부분 집합
	static void subset(int cnt) {
		if (cnt == N) {
			ArrayList<Integer> election1 = new ArrayList<>();
			ArrayList<Integer> election2 = new ArrayList<>();

			// 부분 집합을 기준으로 구역 나누기
			int elect1 = 0;
			int elect2 = 0;
			for (int i = 1; i <= cnt; i++) {
				if (visited[i]) {
					elect1 += people[i];
					election1.add(i);
				} else {
					elect2 += people[i];
					election2.add(i);
				}
			}
			if (election1.size() == 0 || election2.size() == 0)
				return;

			if (bfs(election1) == true && bfs(election2) == true) {
				MIN = Integer.min(MIN, Math.abs(elect1 - elect2));
			}
			return;
		}

		visited[cnt] = true;
		subset(cnt + 1);
		visited[cnt] = false;
		subset(cnt + 1);
	}

	// 각 구역이 연결되어 있는지 확인
	static boolean bfs(ArrayList<Integer> area) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] areaVisited = new boolean[N + 1];
		queue.add(area.get(0));
		areaVisited[area.get(0)] = true;
		while (!queue.isEmpty()) {
			int areaNumber = queue.poll();
			for (int i = 0; i < arr[areaNumber].size(); i++) {
				int nextNumber = arr[areaNumber].get(i);
				// 같은 구역이고 방문하지 않았을 경우만 탐색 진행
				if (area.contains(nextNumber) && !areaVisited[nextNumber]) {
					areaVisited[nextNumber] = true;
					queue.add(nextNumber);
				}
			}
		}
		// 구역을 방문했는지 확인(연결 되어있는지 확인)
		for (int i = 0; i < area.size(); i++) {
			if (!areaVisited[area.get(i)])
				return false;
		}
		return true;
	}
}
