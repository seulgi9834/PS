import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> Pokemon = new HashMap<>();
		HashMap<Integer, String> PokemonNum = new HashMap<>();

		for (int i = 1; i <= N; i++) {
			String name = br.readLine();
			Pokemon.put(name, i);
			PokemonNum.put(i, name);
		}

		for (int i = 0; i < M; i++) {
			String question = br.readLine();
			if (Pokemon.containsKey(question)) {
				sb.append(Pokemon.get(question) + "\n");
			} else {
				sb.append(PokemonNum.get(Integer.parseInt(question)) + "\n");
			}
		}

		System.out.println(sb);
	}
}
