import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		int[][] dp = new int[1001][1001];

		// LCS
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i-1][j - 1] + 1;
				} else
					dp[i][j] = Integer.max(dp[i][j - 1], dp[i - 1][j]);
			}
		}

		int row = str1.length();
		int col = str2.length();
		String temp = "";
		while (dp[row][col] != 0) {
			// 1차이가 나는 부분이 공통 부분임
			if (dp[row][col] - dp[row][col - 1] == 1) {
				temp += str2.charAt(col - 1);
				row -= 1;
				col -= 1;
			} else if(dp[row][col] - dp[row-1][col] == 0){
				row-=1;
			}else {
			
				col -= 1;
			}
		}


		// (n-1,n-1)에서 타고 왔기 때문에 반대로 바꿔줘야함
		String answer = "";
		for (int i = temp.length() - 1; i >= 0; i--) {
			answer += temp.charAt(i);
		}

		System.out.println(answer.length());
		System.out.println(answer);

	}
}
