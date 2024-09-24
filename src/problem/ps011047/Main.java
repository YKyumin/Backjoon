package problem.ps011047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try {
			new Main().solution();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = -1;
		int k = -1;
		int arr[];
		int result = 0;

		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int tempK = k;
		for (int i = n - 1; i > -1; i--) {
			int a = tempK / arr[i];
			int b = tempK % arr[i];

			if (a > 0) {
				result += a;

				if (b == 0)
					break;

				tempK = b;
			}

		}

		System.out.println(result);

	}

}
