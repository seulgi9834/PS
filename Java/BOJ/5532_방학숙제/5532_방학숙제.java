import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int D = Integer.parseInt(br.readLine());
		int AL = 0;
		int BL = 0;
		if (A % C != 0) {
			AL = A / C + 1;
		} else {
			AL = A / C;
		}
		if (B % D != 0) {
			BL = B / D + 1;
		} else {
			BL = B / D;
		}
		System.out.println(L - Integer.max(AL, BL));
	}
}
