package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    static int[] arr;
    static boolean[] visited;
    static int result;
    static int N;
    static int B;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T  = Integer.parseInt(br.readLine());

        // 문제 풀이 시작
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            arr = new int[N];
            result = Integer.MAX_VALUE;
            // visited => false 로 초기화
            visited = new boolean[N];
            // dfs 로 모든 합의 경우를 구하되
            // 최솟값보다 큰 값이 되면 더 더할 필요가 없으니 pass
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i < N+1; i++) {
                subset(0, i);
            }

            System.out.println("#" + test_case + " " + (result-B));
        }
    }

    // 부분 조합 구하기
    public static void subset(int depth, int totalSelect) {
        if (depth == totalSelect) {
            // python에서 썻던 방식처럼 sum이 일정 값을 초과하면 subset을 진행 안 시킬 수도 있지 않을까?
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) {
                    sum += arr[i];
                }
            }
            if (sum >= B) {
                result = Math.min(sum, result);
            }

            return;
        };

        visited[depth] = true;
        subset(depth+1, totalSelect);
        visited[depth] = false;
        subset(depth+1, totalSelect);

    }
}
