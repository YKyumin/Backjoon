package problem.ps001541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		String token;
		StringTokenizer st2;
		int result = 0;
		boolean firstFlag = false;
		
		while(st.hasMoreTokens()) {
			token = st.nextToken();
			st2 = new StringTokenizer(token, "+");
			
			String token2;
			
			int temp = 0;
			while(st2.hasMoreTokens()) {
				token2 = st2.nextToken();
				temp += Integer.parseInt(token2);
			}
			
			if(!firstFlag) {
				result += temp;
				firstFlag = true;
			}else {
				result -=temp;
			}
			
			
		}
		System.out.println(result);
	}
}
