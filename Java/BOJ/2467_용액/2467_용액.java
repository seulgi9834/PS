import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N; // 용액의 수
	static long[] nums; // 용액의 특성값(범위가 커서 long으로 사용했지만 int 가능)

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);

		int start = 0; // 왼쪽
		int end = N - 1; // 오른쪽
		int a = 0; // 왼쪽 값 담을 변수
		int b = 0; // 오른쪽 값 담을 변수 
		long ans = Long.MAX_VALUE; // 가장 0에 가까운 수를 찾기 위한 변수
		while (start < end) { // 왼쪽이 오른쪽 인덱스보다 작을때에만 이분탐색
			long mid = nums[start] + nums[end];
			if (mid == 0) { // 0에 가까운 값을 찾는 것이 목표기 때문에 바로 출력후 종료
				System.out.println(nums[start] + " " + nums[end]);
				return;
			} else if (mid > 0) { // 두 용액의 합이 양수라면
				// 두 용액의 합의 절댓값이 작으면 작을수록 0에 가까움
				if (ans > Math.abs(nums[start] + nums[end])) {
					a = start;
					b = end;
					ans = Math.abs(nums[start] + nums[end]);
				}
				end--; // 값의 합을 낮추기 위해 오른쪽 인덱스를 이동
			} else {
				if (ans > Math.abs(nums[start] + nums[end])) {
					a = start;
					b = end;
					ans = Math.abs(nums[start] + nums[end]);
				}
				start++;// 두 용액의 합이 음수라면 값의 합을 높이기 위해 왼쪽 인덱스를 이동
			}
		}
		System.out.println(nums[a] + " " + nums[b]);
	}
}
