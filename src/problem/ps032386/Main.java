package problem.ps032386;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n;
		Map<String, Integer> map = new HashMap<String, Integer>();
		String result = null;
		int resultCnt = -1;
		boolean onlyMaxFlag = true;

		n = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int m = Integer.parseInt(st.nextToken());
			for (int j = 0; j < m; j++) {
				String token = st.nextToken();
				map.put(token, map.get(token) == null ? 1 : map.get(token) + 1);
			}
		}

		Iterator<Entry<String, Integer>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<String, Integer> entry = iter.next();

			if (result == null) {
				result = entry.getKey();
				resultCnt = entry.getValue();
				onlyMaxFlag = true;
			}else if(resultCnt < entry.getValue()){
				result = entry.getKey();
				resultCnt = entry.getValue();
				onlyMaxFlag = true;
			}else if(resultCnt == entry.getValue()) {
				onlyMaxFlag = false;
			}

		}
		
		if(onlyMaxFlag) {
			System.out.println(result);
		}else {
			System.out.println(-1);
		}

	}
}
