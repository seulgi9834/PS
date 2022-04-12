import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static char[] suitList = { 'S', 'D', 'H', 'C' };
	static char[] rankList = { 'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K' };
	static int[] suitCnt;
	static int[] rankCnt;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			suitCnt = new int[suitList.length];
			rankCnt = new int[rankList.length];

			for (int i = 0; i < 5; i++) {
				String str = st.nextToken();
				char suit = str.charAt(0);
				char rank = str.charAt(1);
				for (int j = 0; j < suitList.length; j++) {
					if (suitList[j] == suit)
						suitCnt[j]++;
				}
				for (int j = 0; j < rankList.length; j++) {
					if (rankList[j] == rank)
						rankCnt[j]++;
				}
			}
			String answer = pockerCheck();
			sb.append("#" + test_case + " " + answer + "\n");

		}
		System.out.println(sb);
	}

	static String pockerCheck() {
		// Straight Flush
		int straightFlushChk = 0;
		for (int i = 0; i < suitCnt.length; i++) {
			if (suitCnt[i] == 5 && rankCnt[0] == 1) {
				straightFlushChk = 0;
				for (int j = 9; j <= 12; j++) {
					if (rankCnt[j] == 1)
						straightFlushChk++;
				}
				if (straightFlushChk == 4) {
					return "Straight Flush";
				}
			}
			if (suitCnt[i] == 5) {
				for (int j = 0; j < rankCnt.length; j++) {
					if (rankCnt[j] == 1) {
						straightFlushChk = 0;
						if (j + 4 < rankCnt.length) {
							for (int r = j; r <= j + 4; r++) {
								if (rankCnt[r] == 1)
									straightFlushChk++;
							}
						}
						if (straightFlushChk == 5) {
							return "Straight Flush";
						} else
							break;
					}
				}
			}
		}

		// Four of a kind
		for (int i = 0; i < rankCnt.length; i++) {
			if (rankCnt[i] == 4) {
				return "Four of a Kind";
			}
		}

		// Full House
		int fullHouseThreeChk = 0;
		int fullHouseTwoChk = 0;
		for (int i = 0; i < rankCnt.length; i++) {
			if (rankCnt[i] == 3) {
				fullHouseThreeChk++;
			} else if (rankCnt[i] == 2) {
				fullHouseTwoChk++;
			}
		}
		if (fullHouseThreeChk == 1 && fullHouseTwoChk == 1) {
			return "Full House";
		}

		// Flush
		for (int i = 0; i < suitCnt.length; i++) {
			if (suitCnt[i] == 5) {
				return "Flush";
			}
		}

		// Straight
		int straightChk = 0;
		for (int i = 0; i < rankCnt.length; i++) {
			if (rankCnt[0] == 1) {
				straightChk = 0;
				for (int j = 9; j <= 12; j++) {
					if (rankCnt[j] == 1)
						straightChk++;
				}
				if (straightChk == 4) {
					return "Straight";
				}
			}
			if (rankCnt[i] == 1) {
				straightChk = 0;
				if (i + 4 < rankCnt.length) {
					for (int j = i; j <= i + 4; j++) {
						if (rankCnt[j] == 1)
							straightChk++;
					}
				}
				if (straightChk == 5) {
					return "Straight";
				} else
					break;
			}
		}

		// Three of a kind
		for (int i = 0; i < rankCnt.length; i++) {
			if (rankCnt[i] == 3) {
				return "Three of a kind";
			}
		}

		// Two pair, One pair
		int pairChk = 0;
		for (int i = 0; i < rankCnt.length; i++) {
			if (rankCnt[i] == 2) {
				pairChk++;
			}
		}
		if (pairChk == 2) {
			return "Two pair";
		} else if (pairChk == 1) {
			return "One pair";
		}
		return "High card";
	}
}
