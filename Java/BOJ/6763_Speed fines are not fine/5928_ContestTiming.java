import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Limit = Integer.parseInt(br.readLine());
		int Speed = Integer.parseInt(br.readLine());
		int diff = Speed - Limit;
		if (diff <= 0) {
			System.out.println("Congratulations, you are within the speed limit!");
		} else if (diff >= 1 && diff <= 20) {
			System.out.println("You are speeding and your fine is $100.");
		} else if (diff >= 21 && diff <= 30) {
			System.out.println("You are speeding and your fine is $270.");
		} else {
			System.out.println("You are speeding and your fine is $500.");
		}

	}
}
