import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_25205_경로당펑크2077 {
public static void main(String[] args)throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
	String str = br.readLine();
	char [] arr = {'y','u','i','o','p','h','j','k','l','b','n','m'};
	char end = str.charAt(str.length()-1);
	for(int i=0;i<arr.length;i++) {
		if(end==arr[i]) {
			System.out.println(0);
			return;
		}
	}
	System.out.println(1);
}
}
