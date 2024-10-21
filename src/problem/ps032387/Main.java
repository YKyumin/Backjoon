package problem.ps032387;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n;
		long m;
		long[] array;
		int result = 0;
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Long.parseLong(st.nextToken());
		array = new long[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			array[i] = Long.parseLong(st.nextToken());
		}

		for (int i = 0; i < n - 1; i++) {
			if (Math.abs(array[i + 1] - array[i]) < m) {
				array[i + 1] = Long.MAX_VALUE;
				result++;
			}
		}

		System.out.println(result);

	}
}
