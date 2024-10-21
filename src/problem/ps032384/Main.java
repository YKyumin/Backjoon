package problem.ps032384;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = -1;
		final String LKU_TEXT = "LoveisKoreaUniversity";

		n = Integer.parseInt(br.readLine());
		{
			for (int i = 0; i < n - 1; i++) {
				System.out.print(LKU_TEXT + " ");
			}
			System.out.println(LKU_TEXT);
		}

	}
}
