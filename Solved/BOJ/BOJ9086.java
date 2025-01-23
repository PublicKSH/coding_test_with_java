import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class BOJ9086 {
	public static void solution(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		StringBuffer sb;
		for (int i =0; i < t; i ++) {
			sb = new StringBuffer(br.readLine());
			System.out.print(sb.charAt(0));
			System.out.print(sb.charAt(sb.length()-1));
			System.out.print('\n');
		}
	}
}