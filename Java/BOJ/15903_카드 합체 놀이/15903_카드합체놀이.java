import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int an = Integer.parseInt(st.nextToken());

		long[] nums = new long[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Long.parseLong(st.nextToken());
		}

		for (int i = 0; i < an; i++) {
			Arrays.sort(nums);
			long temp = nums[0] + nums[1];
			nums[0] = temp;
			nums[1] = temp;
		}

		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
		}

		System.out.println(sum);
	}
}
