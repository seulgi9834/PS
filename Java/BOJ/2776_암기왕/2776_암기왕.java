import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 0; test_case < T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Set<Integer> note1 = new HashSet<>();
			for (int i = 0; i < N; i++) {
				note1.add(Integer.parseInt(st.nextToken()));
			}

			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				
				// 수첩 1에 수첩 2에 적혀있는 숫자가 있는지 확인
				// Set은 Hash 알고리즘을 사용해서 검색 속도가 엄청 빠름
				if (!note1.contains(Integer.parseInt(st.nextToken()))) {
					sb.append("0").append("\n");
				} else {
					sb.append("1").append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}
}
