import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2455_지능형기차 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Max = Integer.MIN_VALUE;
		int people = 0;
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			people -= Integer.parseInt(st.nextToken());
			Max = Math.max(Max, people);
			people += Integer.parseInt(st.nextToken());
			Max = Math.max(Max, people);
		}
		System.out.println(Max);
	}
}
