package problem.ps13460;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		char[][] board = new char[n][m];
		int[] rPos = new int[2];
		int[] bPos = new int[2];
		
		

		for (int i = 0; i < n; i++) {
			String line = sc.next();
			for (int j = 0; j < m; j++) {
				board[i][j] = line.charAt(j);
				if(board[i][j] == 'R') {
					rPos[0] = i;
					rPos[1] = j;
				}else if(board[i][j] == 'B') {
					bPos[0] = i;
					bPos[1] = j;
				}else if(board[i][j] == '.' || board[i][j] == '#' || board[i][j] == 'O') {
					
				}else {
					j--; //retry
				}
			}

		}

		int result = -1;
		
		//TODO make solve source
		
		

		System.out.println(result);
	}
}
