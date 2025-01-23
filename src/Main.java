import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] population = new int[10];
	static int[][] graph = new int[10][];
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		// 구역의 인구수
		String[] strArr = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			population[i] = Integer.parseInt(strArr[i]);
		}
		for (int i = 0; i < n; i++) {
			strArr = br.readLine().split(" ");
			graph[i] = new int[Integer.parseInt(strArr[0])];
			for (int j = 0; j < Integer.parseInt(strArr[0]); j++) {
				graph[i][j] = Integer.parseInt(strArr[j + 1]);
			}
		}
		// 2개의 그룹으로 나누기, O => 2^n
		// 절반만 뽑으면 됨, 조합을 뽑아서 combinationArr 에 저장
		for (int i = 1; i <= n / 2; i++) {
			int[] output = new int[i];
			combination(0, 0, n, i, output);
		}

		System.out.println();
	}

	public static void combination(int start, int depth, int n, int r, int[] output) {
		if (depth == r) {
			System.out.println(Arrays.toString(output));
			return;
		}

		for (int i = start; i < n; i++) {
			output[depth] = i;
			combination(i + 1, depth + 1, n, r, output);
		}
	}
}