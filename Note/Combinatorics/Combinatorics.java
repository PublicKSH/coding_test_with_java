import java.util.Arrays;

// 결과를 저장하는 List, Array는 상황에 맞게 사용
// 재귀를 이용해 조합론을 구현

public class Combinatorics {
	static int[] arr = { 1, 2, 3, 4 };
	static int N = 4;
	// N개중 R개를 뽑은 결과
	static int[] output;
	static boolean[] visited = new boolean[N];;

	public static void main(String[] args) {
		int r = 2;
		output = new int[r];

		System.out.println("==========순열==========");
		permutation(0, N, r);
		System.out.println("==========중복 순열==========");
		permutationWithRepetition(0, N, r);
		System.out.println("==========조합==========");
		combination(0, 0, N, r);
		System.out.println("==========중복 조합==========");
		combinationWithRepetition(0, 0, N, r);

	}

	// 순열 : nPr = n! / (n-r)! , O => n!
	static void permutation(int depth, int n, int r) {
		if (depth == r) {
			// 결과 Return
			System.out.println(Arrays.toString(output));
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				// 방문 처리
				visited[i] = true;
				output[depth] = arr[i];
				permutation(depth + 1, n, r);
				visited[i] = false;
			}
		}
	}

	// 중복 순열, O => n^r
	static void permutationWithRepetition(int depth, int n, int r) {
		if (depth == r) {
			// 결과 Return
			System.out.println(Arrays.toString(output));
			return;
		}

		for (int i = 0; i < n; i++) {
			output[depth] = arr[i];
			permutationWithRepetition(depth + 1, n, r);
		}
	}

	// 조합 : nCr = n! / r!(n-r)!, O => 2^n
	static void combination(int start, int depth, int n, int r) {
		if (depth == r) {
			System.out.println(Arrays.toString(output));
			return;
		}

		for (int i = start; i < n; i++) {
			output[depth] = arr[i];
			combination(i + 1, depth + 1, n, r);
		}
	}

	// 중복 조합 : nHr = (n-1+r)Cr , O => 2^n
	static void combinationWithRepetition(int start, int depth, int n, int r) {
		if (depth == r) {
			System.out.println(Arrays.toString(output));
			return;
		}

		for (int i = start; i < n; i++) {
			output[depth] = arr[i];
			combinationWithRepetition(i, depth + 1, n, r);
		}
	}
}
