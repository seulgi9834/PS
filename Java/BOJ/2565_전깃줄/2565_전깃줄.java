import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int n, answer;
	static int [] dp;
	static class line implements Comparable<line>{
		int a;
		int b;
		public line(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}
		@Override
		public int compareTo(line o) {
			if(this.a>o.a) {
				return 1;
			}
			return -1;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[101];
		answer = Integer.MIN_VALUE;
		ArrayList <line> pole = new ArrayList<>();
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a  = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			pole.add(new line(a,b));
		}
		
		Collections.sort(pole);
		
		for(int i=0;i<n;i++) {
			System.out.println(pole.get(i).a+" "+pole.get(i).b);
		}
		// LIS 이용
		for(int i=0;i<n;i++) {
			dp[i]=1;
			for(int j=0;j<i;j++) {
				if(pole.get(j).b<pole.get(i).b) {
					dp[i] = Integer.max(dp[i], dp[j]+1);
				}
			}
			answer = Integer.max(answer, dp[i]);
		}
		
		System.out.println(n-answer);
	}
}
