import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		int max = 0;
		int min = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		sb.append(0 + " ");
		min = nums[0];
		for (int i = 1; i < n; i++) {
			if (min > nums[i - 1]) {
				min = nums[i - 1];
			}
			max = Integer.max(max, nums[i] - min);
			sb.append(max + " ");
		}
		System.out.println(sb);

	}
}
