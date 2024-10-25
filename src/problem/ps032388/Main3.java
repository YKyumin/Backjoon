package problem.ps032388;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {
	final static int PLUG_IN = 1;
	final static int PLUG_OFF = 0;
	static int[] tree;
	static int[][] array;
	static int treeSize;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n, q;
		int[][] question;

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());

		question = new int[q + 1][2];
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < q + 1; i++) {
			st = new StringTokenizer(br.readLine());

			question[i][0] = Integer.parseInt(st.nextToken());
			question[i][1] = Integer.parseInt(st.nextToken()) - 1;
		}

		int h = (int) Math.ceil(Math.log(n) / Math.log(2));
		treeSize = (int) Math.pow(2, h + 1);

//		System.out.println(h);
//		System.out.println(treeSize);

		array = new int[n][2];
		tree = new int[treeSize];

		// init
		{
			for (int i = 0; i < n; i++) {
				array[i][0] = 0;
				array[i][1] = 0;
			}

			for (int i = 0; i < treeSize; i++) {
				tree[i] = 0;
			}
		}

		// question
		for (int i = 1; i < q + 1; i++) {
			if (question[i][0] == 1) {
				int nextIndex = isNextIndex(1, 0, n - 1, question[i][1]);
//				System.out.println("1: " + nextIndex);
				if (nextIndex != -1) {
					update(1, 0, n - 1, nextIndex, PLUG_IN);
					array[nextIndex][0] = PLUG_IN;
					array[nextIndex][1] = i;
//					System.out.println(nextIndex + 1);
					sb.append(nextIndex + 1 + "\n");
				} else {
//					System.out.println(-1);
					sb.append(-1 + "\n");
				}
			} else if (question[i][0] == 2) {
				if (isUpdateOff(1, 0, n - 1, question[i][1]) != -1) {
					update(1, 0, n - 1, question[i][1], 0);
					int arrayResult = array[question[i][1]][1];
					array[question[i][1]][0] = PLUG_OFF;
					array[question[i][1]][1] = 0;
//					System.out.println(arrayResult);
					sb.append(arrayResult + "\n");
				} else {
//					System.out.println(-1);
					sb.append(-1 + "\n");
				}
			}
//			System.out.print("array: ");
//			for (int k = 0; k < n; k++) {
//				System.out.print("(" + array[k][0] + ", " + array[k][1] + ") ");
//			}
//			System.out.println();
//			System.out.print("tree: ");
//			for (int k = 0; k < treeSize; k++) {
//				System.out.print(tree[k] + " ");
//			}
//			System.out.println();
		}

		System.out.println(sb.toString());

//		update(1, 0, n - 1, 0, 1);
//		System.out.println("isNextIndex 0 : " + isNextIndex(1, 0, n - 1, 0));
//		update(1, 0, n - 1, 1, 1);
//		System.out.println("isNextIndex 0 : " + isNextIndex(1, 0, n - 1, 0));

	}

	static public int update(int node, int start, int end, int idx, int onOff) {
//		System.out.println("=============================================================");
//		System.out.println("node: " + node);
//		System.out.println("start: " + start);
//		System.out.println("end: " + end);
//		System.out.println("idx: " + idx);
//		System.out.println("cnt: " + onOff);
//		System.out.println("=============================================================");

		if (idx < start || end < idx)
			return tree[node];

		if (start == idx && end == idx) {
			tree[node] = onOff;
			// array[idx][1] = onOff;
			return tree[node];
		}

		if (update(node * 2, start, (start + end) / 2, idx, onOff) == PLUG_IN
				& update(node * 2 + 1, (start + end) / 2 + 1, end, idx, onOff) == PLUG_IN) {
			tree[node] = PLUG_IN;
			return tree[node];
		} else {
			tree[node] = PLUG_OFF;
			return tree[node];
		}
	}

	static public int isNextIndex(int node, int start, int end, int idx) {
		if (end < idx)
			return -1;

		if (node * 2 >= treeSize) {
			if (tree[node] == PLUG_OFF)
				return start;
			else
				return -1;
		}

		if (start >= idx && start == end) {
			if (tree[node] == PLUG_OFF)
				return start;
			else
				return -1;
		}

		if (tree[node] == PLUG_OFF) {
			int left = isNextIndex(node * 2, start, (start + end) / 2, idx);
			if (left >= 0)
				return left;

			int right = isNextIndex(node * 2 + 1, (start + end) / 2 + 1, end, idx);
			return right;
		} else {
			return -1;
		}

	}

	static public int isUpdateOff(int node, int start, int end, int idx) {

		if (start == idx && end == idx) {
			if (tree[node] == PLUG_IN)
				return idx;
			else
				return -1;
		} else {
			if (node * 2 >= treeSize) {
				return -1;
			}
			int a = isUpdateOff(node * 2, start, (start + end) / 2, idx);
			if (a > -1)
				return a;
			int b = isUpdateOff(node * 2 + 1, (start + end) / 2 + 1, end, idx);

			if (b > -1)
				return b;
			else
				return -1;
		}

	}
}
