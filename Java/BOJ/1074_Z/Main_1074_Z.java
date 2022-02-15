import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_Z {

	static int cnt, len;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		cnt = 0; // 방문 순서
		len = (int) Math.pow(2, N); // 배열의 한쪽 길이
		find(len, r, c);
		System.out.println(cnt);
	}

	public static void find(int size, int nr, int nc) {

		if (size == 1) {
			return;
		}

		int half = size / 2;
		if (nr < half && nc < half) { // 1 구역
			find(half, nr, nc);
		} else if (nr < half && nc >= half) { // 2 구역
			cnt += half * half;
			find(half, nr, nc - half);
		} else if (nr >= half && nc < half) { // 3 구역
			cnt += half * half * 2;
			find(half, nr - half, nc);
		} else if (nr >= half && nc >= half) { // 4 구역
			cnt += half * half * 3;
			find(half, nr - half, nc - half);
		}
	}
}
