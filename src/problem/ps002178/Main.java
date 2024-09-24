package problem.ps002178;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
	static int n, m;
	static boolean visited[][];
	static Queue<int[]> queue = new LinkedBlockingQueue<>();
	static int[][] maze;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sToken = null;

		try {
			sToken = new StringTokenizer(br.readLine());
			n = Integer.parseInt(sToken.nextToken());
			m = Integer.parseInt(sToken.nextToken());

			maze = new int[n][m];
			visited = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				String line = br.readLine();
				for (int j = 0; j < m; j++) {
					maze[i][j] = Integer.parseInt(line.charAt(j) + "");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		int result = executeBFS(0, 0, 1);

		System.out.println(result);
	}

	private static int executeBFS(int startX, int startY, int startCnt) {
		queue.add(new int[] { startX, startY, startCnt });
		visited[startX][startY] = true;

		while (!queue.isEmpty()) {
			int[] curInfo = queue.poll();

			for (int i = 0; i < 4; i++) {
				int x = curInfo[0];
				int y = curInfo[1];
				int cnt = curInfo[2];

				x = x + dx[i];
				y = y + dy[i];
				cnt++;

				if (!((x > -1 && x < n) && (y > -1 && y < m)) || maze[x][y] == 0)
					continue;

				if (x == n - 1 && y == m - 1) {
					return cnt;
				} else if (!visited[x][y]) {
					visited[x][y] = true;
					queue.add(new int[] { x, y, cnt });

				}

			}

		}

		return -1;
	}

}
