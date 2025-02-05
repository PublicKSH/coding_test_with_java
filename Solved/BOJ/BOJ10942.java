package coding_space;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean[][] dp = new boolean[2001][2001];

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		StringBuffer sb = new StringBuffer();

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			String[] st = br.readLine().split(" ");
			int s = Integer.parseInt(st[0]);
			int e = Integer.parseInt(st[1]);

			int mid = (s + e);
			if (mid % 2 == 0) {
				expend(arr, mid / 2, mid / 2);
			} else {
				expend(arr, mid / 2, mid / 2 + 1);
			}

			sb.append(dp[s][e] ? 1 : 0).append("\n");
		}

		System.out.println(sb);
	}

	public static void expend(int[] arr, int start, int end) {

		while (true) {
			if (arr[start-1] == arr[end-1]) {
				// set에 start, end 넣기
				dp[start][end] = true;
			}

			start--;
			end++;

			if (start-1 < 0 || end-1 >= arr.length) {
				break;
			}

		}
	}
}

//public class Main {
//	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//	public static void main(String[] args) throws IOException {
//		int N = Integer.parseInt(br.readLine());
//		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//
//		HashSet<String> set = new HashSet<>();
//
//		for (int i = 0; i < N; i++) {
//			for (int j = i; j < N; j++) {
//				
//			}
//		}
//		int M = Integer.parseInt(br.readLine());
//		for (int i = 0; i < M; i++) {
//			String[] st = br.readLine().split(" ");
//			String se = st[0] + "-" + st[1];
//
//			System.out.println(set.contains(se) ? 1 : 0);
//		}
//
//	}
//}
