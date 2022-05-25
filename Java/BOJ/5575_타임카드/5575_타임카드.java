import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int ash = Integer.parseInt(st.nextToken());
			int asm = Integer.parseInt(st.nextToken());
			int ass = Integer.parseInt(st.nextToken());
			int aeh = Integer.parseInt(st.nextToken());
			int aem = Integer.parseInt(st.nextToken());
			int aes = Integer.parseInt(st.nextToken());
			int s = ass + asm * 60 + ash * 3600;
			int e = aes + aem * 60 + aeh * 3600;
			int diff = e - s;
			sb.append(diff / 3600 + " ");
			diff %= 3600;
			sb.append(diff / 60 + " ");
			diff %= 60;
			sb.append(diff + "\n");
		}
		System.out.println(sb);
	}
}
