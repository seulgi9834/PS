import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	// 단어 정렬에 필요한 알파벳 숫자 단어들(0~9)
	static String[] word = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
	static int M, N; // 키보드로 입력 받을 숫자
	static ArrayList<number> numbers; // 정수들을 담을 ArrayList

	static class number implements Comparable<number> {
		String word;
		int num; // 원본 숫자

		public number(String word, int num) {
			super();
			this.word = word;
			this.num = num;
		}

		// 십의 자리 사전 순서 비교 후, 일의 자리 사전 순서 비교
		@Override
		public int compareTo(number o) {
			return this.word.compareTo(o.word);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		M = Integer.parseInt(st.nextToken()); // M 입력
		N = Integer.parseInt(st.nextToken()); // N 입력
		numbers = new ArrayList<>(); // M이상 N이하의 숫자 단어 사전 순서를 입력 받을 ArrayList

		// M이상 N이하의 숫자 단어를 입력 받음
		for (int i = M; i <= N; i++) {
			String str = "";
			int num = i;
			if (i >= 10) {
				str += word[i / 10] + " ";
			}
			str += word[i % 10];
			numbers.add(new number(str, i));
		}

		// 사전 순서 기준으로 정렬 진행(27번째 줄 참고)
		Collections.sort(numbers);

		// 한 줄에 10개씩 출력하기 위한 임시 변수
		int tempTen = numbers.size() / 10;
		int tempOne = numbers.size() % 10;
		int cnt = 0; // 총 몇개를 출력했는지 확인할 index

		// 한줄에 10개씩 출력
		for (int i = 0; i < tempTen; i++) {
			for (int j = 0; j < 10; j++) {
				sb.append(numbers.get(cnt).num + " ");
				cnt++;
			}
			sb.append("\n");
		}
		// 10개씩 출력하고 남은 숫자 출력
		for (int i = 0; i < tempOne; i++) {
			sb.append(numbers.get(cnt).num + " ");
			cnt++;
		}

		System.out.println(sb); // 출력

	}
}
