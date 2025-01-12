package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Test Case 개수 입력 받기
        int T = Integer.parseInt(br.readLine());

        // 문제 풀이 시작
        for (int test_case = 1; test_case <= T; test_case++) {
            int result = 0;
            int plusFliesCaughtNum; // 플러스로 잡은 파리의 개수
            int mulFliesCaughtNum; // 플러스로 잡은 파리의 개수
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 모든 경우의 수 확인
            // 뿌려진 일부가 영역을 벗어나도 상관없다. => 이 부분을 놓침
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    plusFliesCaughtNum = 0;
                    mulFliesCaughtNum = 0;
                    for (int col = i - (M - 1); col < i + (M); col++) {
                        for (int row = j - (M - 1); row < j + (M); row++) {
                            // 영역을 벗어나면 pass
                            if (col < 0 || col >= N || row < 0 || row >= N) {
                                continue;
                            }

                            // + 모양
                            if (col == i || row == j) {
                                plusFliesCaughtNum += arr[col][row];
                            }
                            // x 모양
                            if (Math.abs(col - i) == Math.abs(row - j)) {
                                mulFliesCaughtNum += arr[col][row];
                            }
                        }
                    }
                    result = Math.max(result, Math.max(plusFliesCaughtNum, mulFliesCaughtNum));
                }
            }

            System.out.println("#" + test_case + " " + result);
        }
    }
}
