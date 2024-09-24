package problem.ps001920;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sToken = null;
		int n = -1;
		int m = -1;
		List<Integer> nArray = null;
		List<Integer> mArray = null;

		try {
			n = Integer.parseInt(br.readLine());
			sToken = new StringTokenizer(br.readLine());
			nArray = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) {
				nArray.add(Integer.parseInt(sToken.nextToken()));
			}

			m = Integer.parseInt(br.readLine());
			sToken = new StringTokenizer(br.readLine());
			mArray = new ArrayList<Integer>();
			for (int i = 0; i < m; i++) {
				mArray.add(Integer.parseInt(sToken.nextToken()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		Collections.sort(nArray);

		for (int i = 0; i < m; i++) {
			System.out.println(binarySearch(nArray, mArray.get(i)));
		}

	}

	private static int binarySearch(List<Integer> nArray, int target) {
		int b = 0;
		int t = nArray.size();
		while (true) {
			int half = (t + b) / 2;
			if (target == nArray.get(half)) {
				return 1;
			} else if (target > nArray.get(half)) {
				b = half + 1;
			} else {
				t = half;
			}
			if (b == t)
				return 0;
		}

	}

}
