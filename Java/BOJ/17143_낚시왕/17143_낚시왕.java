import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int R, C, M;
	static int[][] map;
	static int[][] move = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } }; // 1: 위, 2: 아래, 3: 오른쪽, 4: 왼쪽
	static ArrayList<shark> sharks = new ArrayList<>();
	static ArrayList<Integer> net = new ArrayList<>(); // 잡은 상어

	static class shark { // 상어 정보
		int r; // 상어 위치
		int c; // 상어 위치
		int s; // 속력
		int d; // 이동 방향
		int z; // 상어를 크기로 구분

		public shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열
		M = Integer.parseInt(st.nextToken()); // 상어 수

		map = new int[R + 1][C + 1]; // (1,1)에서 시작

		// 상어 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()); // 상어 행
			int c = Integer.parseInt(st.nextToken()); // 상어 열
			int s = Integer.parseInt(st.nextToken()); // 상어 속력
			int d = Integer.parseInt(st.nextToken()); // 상어 이동 방향
			int z = Integer.parseInt(st.nextToken()); // 상어 크기

			map[r][c] = z; // 지도에 상어 정보 입력(크기를 구분자로 사용)
			sharks.add(new shark(r, c, s, d, z)); // 상어 방향 정보와 속력을 저장
		}

		// 낚시왕이 1부터 C까지 이동
		for (int i = 1; i <= C; i++) {

			// 낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡기
			fishing(i);

			// 상어 이동
			sharkMove();

			// 맵 업데이트 전 초기화
			for (int r = 1; r <= R; r++) {
				for (int c = 1; c <= C; c++) {
					map[r][c] = 0;
				}
			}

			mapUpdate();

		}

		// 잡은 상어 계산
		int answer = 0;
		for (int i = 0; i < net.size(); i++) {
			answer += net.get(i);
		}
		System.out.println(answer);
	}

	static void fishing(int c) {
		for (int i = 1; i <= R; i++) {
			if (map[i][c] != 0) { // 상어가 있다면
				net.add(map[i][c]); // 잡은 물고기 추가
				sharkRemove(map[i][c]); // 상어 목록에서 상어 제거
				map[i][c] = 0; // 지도에서 상어 제거
				return;
			}
		}
	}

	static void sharkMove() {
		for (int i = 0; i < sharks.size(); i++) {
			int r = sharks.get(i).r;
			int c = sharks.get(i).c;
			int s = sharks.get(i).s;
			int d = sharks.get(i).d;
			int z = sharks.get(i).z;

			
			// 시간 초과 방지(이동이 겹치는 부분을 제외하고 이동)
			if(d==1||d==2) s = s%((R-1)*2);
			else s = s%((C-1)*2);
			
			for (int j = 0; j < s; j++) {
				if (r + move[d][0] > R || c + move[d][1] > C || r + move[d][0] <= 0 || c + move[d][1] <= 0) {
					d = sharkUpdate(d);
				}
				r += move[d][0];
				c += move[d][1];
			}
			sharks.set(i, new shark(r, c, s, d, z));
		}
	}

	// 상어 삭제
	static void sharkRemove(int z) {
		for (int i = 0; i < sharks.size(); i++) {
			if (sharks.get(i).z == z) {
				sharks.remove(i);
				return;
			}
		}
	}


	// 상어 방향 정보 업데이트
	static int sharkUpdate(int d) {
		if (d == 1 || d == 3) {
			d += 1;
		} else if (d == 2 || d == 4) {
			d -= 1;
		}
		return d;

	}

	// 상어를 배치해 지도 업데이트
	static void mapUpdate() {
		int size = sharks.size();
		ArrayList<Integer> deathNote = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			int r = sharks.get(i).r;
			int c = sharks.get(i).c;
			if (map[r][c] == 0) { // 상어가 없다면
				map[r][c] = sharks.get(i).z; // 상어 배치
			} else { // 상어가 있다면
				if (map[r][c] > sharks.get(i).z) { // 맵에 있는 상어가 더 크다면
					deathNote.add(sharks.get(i).z);
				} else { // 새로 들어온 상어가 더 크다면
					deathNote.add(map[r][c]);
					map[r][c] = sharks.get(i).z;
				}
			}
		}
		// 죽은 상어들을 정리
		for (int i = 0; i < deathNote.size(); i++) {
			sharkRemove(deathNote.get(i));
		}
	}

}
