import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int N, Max;
	static ArrayList<Integer> arr;
	static int[] newArr;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(arr);
		visited = new boolean[N];
		newArr = new int[N];
		Max = Integer.MIN_VALUE;
		permutation(0);
		System.out.println(Max);
	}

	static void permutation(int cnt) {
		if (cnt == N) {
			Max = Integer.max(Max, diff());
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				newArr[cnt] = arr.get(i);
				permutation(cnt + 1);
				visited[i] = false;
			}
		}
	}

	static int diff() {
		int sum = 0;
		for (int i = 0; i < N - 1; i++) {
			sum += Math.abs(newArr[i] - newArr[i + 1]);
		}
		return sum;
	}
}
