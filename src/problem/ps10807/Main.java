package problem.ps10807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n;
		String nArray;
		int v;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		try {
			n = Integer.parseInt(br.readLine());

			nArray = br.readLine();
			StringTokenizer sToken = new StringTokenizer(nArray, " ");
			while (sToken.hasMoreTokens()) {
				int token = Integer.parseInt(sToken.nextToken());
				map.put(token, map.get(token) == null ? 1 : ((int) map.get(token) + 1));
			}

			v = Integer.parseInt(br.readLine());

		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		System.out.println(map.get(v) == null ? 0 : map.get(v));

	}
}
