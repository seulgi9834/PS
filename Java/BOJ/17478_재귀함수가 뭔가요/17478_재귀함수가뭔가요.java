import java.util.Scanner;

public class Main {

	public static int num;
	public static String RecursionStr = "";
	public static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		sb = new StringBuilder();
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		Recursion(num);
		System.out.println(sb);
	}

	public static void Recursion(int n) {
		String str = RecursionStr;
		if (n == 0) {
			sb.append(str + "\"재귀함수가 뭔가요?\"\n");
			sb.append(str + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			sb.append(str + "라고 답변하였지.\n");
			return;
		}

		sb.append(str + "\"재귀함수가 뭔가요?\"\n");
		sb.append(str + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
		sb.append(str + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
		sb.append(str + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");

		RecursionStr += "____";
		Recursion(n - 1);

		sb.append(str + "라고 답변하였지.\n");

	}
	
	
}
