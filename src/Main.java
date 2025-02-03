package coding_space;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String a = br.readLine();
		String b = br.readLine();
		int[][] dp = new int[a.length() + 1][b.length() + 1];
		// 최장 공통부분의 마지막 문자열 위치
		int x = 0;
		int y = 0;
		int max = 0;
		for (int i = 1; i < a.length() + 1; i++) {
			for (int j = 1; j < b.length() + 1; j++) {
				dp[i][j] = Math.max(dp[i][j - 1], Math.max(dp[i - 1][j], dp[i - 1][j - 1]));
				if (b.charAt(i - 1) == a.charAt(j - 1)) {
					dp[i][j]++;
					if (dp[i][j] > max) {
						max = dp[i][j];
						x = i;
						y = j;
					}
				}
			}
		}

		for (int[] arr1D : dp) {
			System.out.println(Arrays.toString(arr1D));
		}
		System.out.println(max);
		if (max != 0) {
			// 거슬러 올라가면서 예제 출력
			StringBuffer sb = new StringBuffer();
			
			// 현재 위치의 상, 좌 현재 값보다 -1이면 sb.append
			// 현재 위치의 상 값이 현재 값보다 -1 이고 좌 값이 현재 값이랑 같으면 현재 위치의 좌 값--
			// 현재 위치의 좌 값이 현재 값보다 -1 이고 상 값이 현재 값이랑 같으면 현재 위치의 상 값--
			// 현재 위치의 상, 좌 값이 모두 현재 값이랑 같이랑 같으면 현재 위치의 좌 값 --;
			
			// 따로 저장해 두고 현재 값의 상,좌 값만 비교할까?
		}
	}
}
