import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char hanguel = br.readLine().charAt(0);
		int answer = (int) hanguel - 44031;
		System.out.println(answer);

	}
}
