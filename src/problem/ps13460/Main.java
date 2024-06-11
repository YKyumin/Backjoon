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
		result = executeBFS(rPos[0], rPos[1], bPos[0], bPos[1]);

		System.out.println(result);
	}

	private static int executeBFS(int i, int j, int k, int l) {
		visited[i][j][k][l] = true;
		queue.add(new int[] { i, j, k, l });

		while (queue.isEmpty()) {
			int[] curPos = queue.poll();

			for (int a = 0; a < 4; a++) {
				int rx = curPos[0];
				int ry = curPos[1];
				int bx = curPos[2];
				int by = curPos[3];
				boolean isBlueOut = false;

				// TODO move and logic
				// x move
				boolean rxFlag = false;
				boolean bxFlag = false;
				while (dx[a] != 0) {
					// red
					if (rx + dx[a] > -1 && rx + dx[a] < n) { // inmap check
						if (board[rx + dx[a]][ry] == '.') {
							// bx check
							if (rx + dx[a] != bx && ry != rx) {
								rx = rx + dx[a];
							} else {
								if (board[bx + dx[a]][by] == '.') {
									rx = rx + dx[a];
								} else {
									rxFlag = true; // red stop
								}
							}

						} else if (board[rx + dx[a]][ry] == 'O') {
							// TODO
						} else {
							rxFlag = true; // red stop
						}
					} else {
						rxFlag = true;
					}

					// blue
					if (bx + dx[a] > -1 && bx + dx[a] < n) {
						if (board[bx + dx[a]][by] == '.') {
							// rx check
						} else if (board[bx + dx[a]][by] == 'O') {
							// TODO
						} else {
							bxFlag = true;
						}
					} else {
						bxFlag = true;
					}
				}

			}

		}

		return -1;
	}

}
