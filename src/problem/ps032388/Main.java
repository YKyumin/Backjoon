package problem.ps032388;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n, q;
		int[][] question, array;

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());

		array = new int[n + 1][2];

		for (int i = 1; i < n + 1; i++) {
			array[i][0] = 0;
		}

		question = new int[q + 1][2];
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < q + 1; i++) {
			st = new StringTokenizer(br.readLine());

			question[i][0] = Integer.parseInt(st.nextToken());
			question[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < q + 1; i++) {
//			System.out.print("cur Array: ");
//			for (int a = 1; a < n + 1; a++) {
//				System.out.print(array[a][0] + " ");
//			}
//			System.out.println();

			if (question[i][0] == 1) {

				if (array[question[i][1]][0] == 0) {
					int questionIndex = question[i][1];
					array[questionIndex][0] = questionIndex;
					array[questionIndex][1] = i;

					if (questionIndex + 1 < n + 1 && array[questionIndex + 1][0] > 0) {
						array[questionIndex][0] = array[questionIndex + 1][0];
					}

					for (int j = question[i][1]; j > 0; j--) {
						if (array[j][0] > 0) {
							array[j][0] = array[questionIndex][0];
						} else {
							break;
						}
					}

					sb.append(question[i][1] + "\n");
				} else {
					int nextIndex = array[question[i][1]][0] + 1;
					if (nextIndex < n + 1) {
						array[nextIndex][0] = nextIndex;
						array[nextIndex][1] = i;
						if (nextIndex + 1 < n + 1 && array[nextIndex + 1][0] > 0) {
							int lastIndex = array[nextIndex + 1][0];
							for (int j = nextIndex; j > 0; j--) {
								if (array[j][0] > 0) {
									array[j][0] = lastIndex;
								} else {
									break;
								}
							}
						} else {
							for (int j = nextIndex; j > 0; j--) {
								if (array[j][0] > 0) {
									array[j][0] = nextIndex;
								} else {
									break;
								}
							}
						}

						sb.append(nextIndex + "\n");
					} else {
						sb.append(-1 + "\n");
					}
				}

			} else if (question[i][0] == 2) {
				if (array[question[i][1]][0] > 0) {
					int temp = question[i][1];
					array[temp][0] = 0;
					for (int j = temp - 1; j > 0; j--) {
						if (array[j][0] > 0) {
							array[j][0] = temp - 1;
						} else if (array[j][0] == 0) {
							break;
						}
					}
					sb.append(array[question[i][1]][1] + "\n");
				} else {
					sb.append(-1 + "\n");
				}
			}

		}
		System.out.println(sb.toString());

	}
}
