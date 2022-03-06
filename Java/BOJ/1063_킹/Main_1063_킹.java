import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static String[][] chess = { 
			{ "A8", "B8", "C8", "D8", "E8", "F8", "G8", "H8" },
			{ "A7", "B7", "C7", "D7", "E7", "F7", "G7", "H7" }, 
			{ "A6", "B6", "C6", "D6", "E6", "F6", "G6", "H6" },
			{ "A5", "B5", "C5", "D5", "E5", "F5", "G5", "H5" }, 
			{ "A4", "B4", "C4", "D4", "E4", "F4", "G4", "H4" },
			{ "A3", "B3", "C3", "D3", "E3", "F3", "G3", "H3" }, 
			{ "A2", "B2", "C2", "D2", "E2", "F2", "G2", "H2" },
			{ "A1", "B1", "C1", "D1", "E1", "F1", "G1", "H1" } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String king = st.nextToken();
		String stone = st.nextToken();
		int command = Integer.parseInt(st.nextToken());

		int ky = -1;
		int kx = -1;
		int sy = -1;
		int sx = -1;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (king.equals(chess[i][j])) {
					ky = i;
					kx = j;
				}
				if (stone.equals(chess[i][j])) {
					sy = i;
					sx = j;
				}
			}
		}

		for (int i = 0; i < command; i++) {
			String cmd = br.readLine();
			// 한 칸 오른쪽으로
			if (cmd.equals("R")) {
				if (check(ky, kx + 1)) {
					kx = kx + 1;
					if (kx == sx && ky == sy) {
						if (check(sy, sx + 1)) {
							sx = sx + 1;
						} else {
							kx = kx - 1;
						}
					}
				}
			}

			// 한 칸 왼쪽으로
			else if (cmd.equals("L")) {
				if (check(ky, kx - 1)) {
					kx = kx - 1;
					if (kx == sx && ky == sy) {
						if (check(sy, sx - 1)) {
							sx = sx - 1;
						} else {
							kx = kx + 1;
						}
					}
				}
			}
			// 한 칸 아래로
			else if (cmd.equals("B")) {
				if (check(ky + 1, kx)) {
					ky = ky + 1;
					if (ky == sy && kx == sx) {
						if (check(sy + 1, sx)) {
							sy = sy + 1;
						} else {
							ky = ky - 1;
						}
					}
				}
			}
			// 한 칸 위로
			else if (cmd.equals("T")) {
				if (check(ky - 1, kx)) {
					ky = ky - 1;
					if (ky == sy && kx == sx) {
						if (check(sy - 1, sx)) {
							sy = sy - 1;
						} else {
							ky = ky + 1;
						}
					}
				}
			}
			// 오른쪽 위 대각선으로
			else if (cmd.equals("RT")) {
				if (check(ky - 1, kx + 1)) {
					ky = ky - 1;
					kx = kx + 1;
					if (ky == sy && kx == sx) {
						if (check(sy - 1, sx + 1)) {
							sy = sy - 1;
							sx = sx + 1;
						} else {
							ky = ky + 1;
							kx = kx - 1;
						}
					}
				}
			}
			// 왼쪽 위 대각선으로
			else if (cmd.equals("LT")) {
				if (check(ky - 1, kx - 1)) {
					ky = ky - 1;
					kx = kx - 1;
					if (ky == sy && kx == sx) {
						if (check(sy - 1, sx - 1)) {
							sy = sy - 1;
							sx = sx - 1;
						} else {
							ky = ky + 1;
							kx = kx + 1;
						}
					}
				}
			}
			// 오른쪽 아래 대각선으로
			else if (cmd.equals("RB")) {
				if (check(ky + 1, kx + 1)) {
					ky = ky + 1;
					kx = kx + 1;
					if (ky == sy && kx == sx) {
						if (check(sy + 1, sx + 1)) {
							sy = sy + 1;
							sx = sx + 1;
						} else {
							ky = ky - 1;
							kx = kx - 1;
						}
					}
				}
			}
			// 왼쪽 아래 대각선으로
			else if (cmd.equals("LB")) {
				if (check(ky + 1, kx - 1)) {
					ky = ky + 1;
					kx = kx - 1;
					if (ky == sy && kx == sx) {
						if (check(sy + 1, sx - 1)) {
							sy = sy + 1;
							sx = sx - 1;
						} else {
							ky = ky - 1;
							kx = kx + 1;
						}
					}
				}
			}
		}
		System.out.println(chess[ky][kx] + "\n" + chess[sy][sx]);
	}

	static boolean check(int row, int col) {
		boolean chk = true;
		if (row < 0 || row >= 8 || col < 0 || col >= 8)
			return false;
		return chk;
	}
}
