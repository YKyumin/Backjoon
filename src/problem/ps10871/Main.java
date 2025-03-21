package problem.ps10871;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try {
			solve();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

	static public void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;
		int X;
		StringBuilder sb = null;
		StringTokenizer sToken1 = new StringTokenizer(br.readLine());
		StringTokenizer sToken2 = new StringTokenizer(br.readLine());

		N = Integer.parseInt(sToken1.nextToken());
		X = Integer.parseInt(sToken1.nextToken());

		while (sToken2.hasMoreTokens()) {
			int a = Integer.parseInt(sToken2.nextToken());
			if (a < X && sb == null) {
				sb = new StringBuilder(a+"");
			}else if(a < X) {
				sb.append(" " + a);
			}
		}
		System.out.println(sb.toString());
	}
}
