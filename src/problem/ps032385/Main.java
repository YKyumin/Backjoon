package problem.ps032385;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n;
		int[] array = null;
		int min = 0;

		n = Integer.parseInt(br.readLine());
		array = new int[n];
		for (int i = 0; i < n; i++) {
			if (i / 2 == 0) {
				array[i] = n * i;
			} else {
				array[i] = n * -i;
			}
			min += array[i] / n;

		}


		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.print(min);
	}
}
