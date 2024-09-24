package problem.ps001929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = -1;
		int m = -1;
		int[] arr;

		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());

			if (m > n)
				return;
		} catch (IOException e) {
			e.printStackTrace();
		}

		arr = new int[n + 1];
		arr[1] = -1;
		for (int i = 2; i <= n; i++)
			arr[i] = i;
		
		int nSqrt = (int)Math.sqrt(n);
		for (int i = 2; i <= nSqrt; i++) {
			if(arr[i] < 0) continue;
			for (int j = i * 2; j <= n; j += i) {
				arr[j] = -1;
			}
		}

		for (int i = m; i <= n; i++) {
			if (arr[i] > 0)
				System.out.println(arr[i]);
		}

	}

}
