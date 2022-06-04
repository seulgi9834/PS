import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int fibN, fibonacciN;
	static int[] f;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		f = new int[n + 1];
		fibN = 0;
		fibonacciN = 0;
		fib(n);
		fibonacci(n);
		System.out.println(fibN + " " + fibonacciN);
	}

	static int fib(int n) {
		if (n == 1 || n == 2) {
			fibN++;
			return 1;
		} else {
			return ((fib(n - 1) + fib(n - 2)));
		}
	}

	static int fibonacci(int n) {
		f[0] = 0;
		f[1] = 1;
		f[2] = 1;
		for (int i = 3; i <= n; i++) {
			fibonacciN++;
			f[i] = f[i - 1] + f[i - 2];
		}
		return f[n];
	}
}
