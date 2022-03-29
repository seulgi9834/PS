import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
        BigInteger s = sc.nextBigInteger();
        BigInteger n = sc.nextBigInteger();
		System.out.println(s.divide(n));
        System.out.println(s.remainder(n));
        sc.close();
	}
}
