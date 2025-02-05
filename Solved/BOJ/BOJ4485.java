package coding_space;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] d = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		for (int tc = 0;; tc++) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0) {
				break;
			}
			int[][] rupeeMap = new int[N][N];
			int[][] resultMap = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					rupeeMap[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			System.out.printf("Problem %d: %d\n", tc + 1, 0);
		}
	}

	public static void djik(int[][] rupeeMap, int[][] resultMap) {
		ArrayDeque<Node> queue = new ArrayDeque<>();
		queue.offer(new Node(0, 0));
		resultMap[0][0] = rupeeMap[0][0];

		while (!queue.isEmpty()) {
			Node nn = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = nn.x + d[i][0];
				int ny = nn.y + d[i][1];
				
//				if (nx < 0 || ny < 0 ||)
				
			}
		}
	}

	public static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}