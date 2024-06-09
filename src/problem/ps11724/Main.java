package problem.ps11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static boolean visited[];
	static ArrayList<Integer>[] array;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		visited = new boolean[n + 1];
		array = new ArrayList[n + 1];

		for (int i = 1; i < n + 1; i++) {
			array[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			token = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(token.nextToken());
			int e = Integer.parseInt(token.nextToken());
			array[s].add(e);
			array[e].add(s);
		}

		int result = 0;
		for (int i = 1; i < n + 1; i++) {
			if (!visited[i]) {
				result++;
				executeDFS(i);
			}
		}
		System.out.println(result);

	}

	private static void executeDFS(int i) {
		if (visited[i]) {
			return;
		}
		visited[i] = true;
		for (int j : array[i]) {
			if (!visited[j]) {
				executeDFS(j);
			}
		}
	}
}
