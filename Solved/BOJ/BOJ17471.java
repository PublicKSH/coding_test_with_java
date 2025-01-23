import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ17471 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] population = new int[10];
	static int[][] graph = new int[10][];
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		String[] strArr = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			population[i] = Integer.parseInt(strArr[i]);
		}
		for (int i = 0; i < n; i++) {
			strArr = br.readLine().split(" ");
			graph[i] = new int[Integer.parseInt(strArr[0])];
			for (int j = 0; j < Integer.parseInt(strArr[0]); j++) {
				graph[i][j] = Integer.parseInt(strArr[j + 1]) - 1;
			}
		}
		// 2개의 그룹으로 나누기, O => 2^n
		// 절반만 뽑으면 됨, 조합을 뽑아서 combinationArr 에 저장
		for (int i = 1; i <= n / 2; i++) {
			int[] groupA = new int[i];
			combination(0, 0, n, i, groupA);
		}

		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}

	}

	public static void combination(int start, int depth, int n, int r, int[] output) {
		if (depth == r) {
			// 여기까지 들어오면 선거구 A를 고른
			// todo : 아니 코드 너무 더럽다 일단 풀고 다른 사람 풀이 찾아보
			// todo : 아니 자바의 List.contains 는 Integer형을 구별 할 수 없내요? 이런 말도안되는 함수가
			// => 말도 안되는건 저의 코딩 실력이였구요
			// 문제 원인 asList() 함수는 primative 값을 자동으로 오토 박싱해주는 기능이 없어서 int[] => List<Integer> 와 같은 변경을 불가능함
			// 따라서 기존에썻던 코드인 Arrays.asList({1,2,3}).contrains(1) List<int[]> 에서 1을 찾는거라 동작 안하는게 당연하였습니다!!

			// 좀더 배열을 우아하게 분리할 수는 없을까?
			ArrayList<Integer> groupA = new ArrayList<>();
			ArrayList<Integer> groupB = new ArrayList<>();
			for (int numA : output) {
				groupA.add(numA);
			}
			for (int i = 0; i < n; i++) {
				if (!groupA.contains(i)) {
					groupB.add(i);
				}
			}

			boolean[] visited = new boolean[n];
			ArrayDeque<Integer> queA = new ArrayDeque<>();
			queA.offer(groupA.get(0));
			visited[groupA.get(0)] = true;
			int sum = population[groupA.get(0)];

			// 두 선거구의 차

			while (!queA.isEmpty()) {
				int node = queA.poll();

				// 현재 노드에서 다음 노드로 이동 가능할 때만 이
				for (int nextNode : graph[node]) {
					if (!visited[nextNode] && groupA.contains(nextNode)) {
						queA.offer(nextNode);
						visited[nextNode] = true;
						sum += population[nextNode];
					}
				}
			}

			ArrayDeque<Integer> queB = new ArrayDeque<>();
			queB.offer(groupB.get(0));
			visited[groupB.get(0)] = true;
			sum -= population[groupB.get(0)];

			while (!queB.isEmpty()) {
				int node = queB.poll();

				// 현재 노드에서 다음 노드로 이동 가능할 때만 이
				for (int nextNode : graph[node]) {
					if (!visited[nextNode] && groupB.contains(nextNode)) {
						queB.offer(nextNode);
						visited[nextNode] = true;
						sum -= population[nextNode];
					}
				}
			}

			// visited중에서 false 가 없을때
			for (boolean bool : visited) {
				if (!bool) {
					return;
				}
			}

			// 여기 까지오면 visited중에서 false가 없다 => 선거구가 잘 나뉘었다.
			result = Math.min(result, Math.abs(sum));
			return;
		}

		for (int i = start; i < n; i++) {
			output[depth] = i;
			combination(i + 1, depth + 1, n, r, output);
		}
	}
}