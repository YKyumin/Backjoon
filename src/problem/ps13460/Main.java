package problem.ps13460;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
	final static private int[] dx = { 1, 0, -1, 0 };
	final static private int[] dy = { 0, -1, 0, 1 };
	static char[][] board;
	static boolean[][][][] visited;
	static int n;
	static int m;
	static Queue<int[]> queue = new ConcurrentLinkedQueue<int[]>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		board = new char[n][m];
		visited = new boolean[n][m][n][m]; // red(x,y),blue(x,y) visited check

		int[] rPos = new int[2];
		int[] bPos = new int[2];

		for (int i = 0; i < n; i++) {
			String line = sc.next();
			for (int j = 0; j < m; j++) {
				board[i][j] = line.charAt(j);
				if (board[i][j] == 'R') {
					rPos[0] = i;
					rPos[1] = j;
					board[i][j] = '.';
				} else if (board[i][j] == 'B') {
					bPos[0] = i;
					bPos[1] = j;
					board[i][j] = '.';
				} else if (board[i][j] == '.' || board[i][j] == '#' || board[i][j] == 'O') {

				} else {
					System.exit(-1); // exit
				}
			}

		}

		int result = -1;

		// TODO make solve source
		result = executeBFS(rPos[0], rPos[1], bPos[0], bPos[1], 0);

		System.out.println(result);
	}

	private static int executeBFS(int i, int j, int k, int l, int mvCnt) {
		visited[i][j][k][l] = true;
		queue.add(new int[] { i, j, k, l, mvCnt });

		while (!queue.isEmpty()) {
			int[] curPos = queue.poll();

			for (int a = 0; a < 4; a++) {
				int rx = curPos[0];
				int ry = curPos[1];
				int bx = curPos[2];
				int by = curPos[3];
				int cnt = curPos[4];

				// move and logic
				boolean isRxMove = false;
				boolean isBxMove = false;
				boolean isRxGoal = false;
				boolean isBxGoal = false;

				while (!isRxMove || !isBxMove) {
					int tempRx = rx + dx[a];
					int tempBx = bx + dx[a];
					int tempRy = ry + dy[a];
					int tempBy = by + dy[a];
					
					

					// Red move Logic
					if (board[tempRx][tempRy] != '#') {
						if (board[tempRx][tempRy] == 'O') {
							// search end
							isRxGoal = true;
							isRxMove = true;
						} else if ((tempRx == bx && tempRy == by) && board[tempBx][tempBy] != '.') {
							isRxMove = true;
						} else {
							// move
							rx = tempRx;
							ry = tempRy;
						}
					} else {
						isRxMove = true;
					}

					// Blue move Logic
					if (board[tempBx][tempBy] != '#') {
						if (board[tempBx][tempBy] == 'O') {
							// can't move
							isBxGoal = true;
							break;
						} else if ((tempBx == rx && tempBy == ry && !isRxGoal) && board[tempRx][tempRy] != '.') {
							isBxMove = true;
						} else {
							// move
							bx = tempBx;
							by = tempBy;
						}
					} else {
						isBxMove = true;
					}

				}

				// move after
				if (isRxGoal && !isBxGoal) {
					return cnt + 1;
				} else if (isBxGoal) {
					// pass
				} else if (!visited[rx][ry][bx][by]) {
					visited[rx][ry][bx][by] = true;
					queue.add(new int[] { rx, ry, bx, by, cnt + 1 });
				}

			}

		}

		return -1;
	}

}
