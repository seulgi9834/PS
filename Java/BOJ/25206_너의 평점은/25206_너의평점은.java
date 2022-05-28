import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double sum = 0;
		int n = 0;
		for (int i = 0; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			double num = Double.parseDouble(st.nextToken());
			String grade = st.nextToken();

			if (grade.equals("A+")) {
				sum += 4.5 * num;
				n += num;
			} else if (grade.equals("A0")) {
				sum += 4 * num;
				n += num;
			} else if (grade.equals("B+")) {
				sum += 3.5 * num;
				n += num;
			} else if (grade.equals("B0")) {
				sum += 3 * num;
				n += num;
			} else if (grade.equals("C+")) {
				sum += 2.5 * num;
				n += num;
			} else if (grade.equals("C0")) {
				sum += 2 * num;
				n += num;
			} else if (grade.equals("D+")) {
				sum += 1.5 * num;
				n += num;
			} else if (grade.equals("D0")) {
				sum += 1 * num;
				n += num;
			} else if (grade.equals("F")) {
				sum += 0 * num;
				n += num;
			}
		}
		System.out.println(sum / n);
	}
}
