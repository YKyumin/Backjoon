package problem.ps13460;

import java.util.Scanner;

public class Main {
	final static private int[] dx = { 1, 0, -1, 0 };
	final static private int[] dy = { 0, -1, 0, 1 };
	static char[][] board;
	static boolean[][][][] visited;
	static int n;
	static int m;

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
				} else if (board[i][j] == 'B') {
					bPos[0] = i;
					bPos[1] = j;
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

		for (int a = 0; a < 4; a++) {
			int rx = i;
			int ry = j;
			int bx = k;
			int by = l;
			boolean isBlueOut = false;

			//TODO move and recursive logic

		}

		return -1;
	}

}
