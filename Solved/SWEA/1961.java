package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    public static int[][] trun2DMatrixRight90(int[][] matrix) {
        int[][] temp = new int[matrix.length][matrix[0].length];
        // 배열 값만 읽기 -> 원본 참조 값 변경 x
        for (int i=0; i < matrix.length; i++) {
            for (int j =0; j < matrix[0].length; j++) {
                temp[j][matrix[0].length-1-i] = matrix[i][j];
            }
        }
        return temp;
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Test Case 개수 입력 받기
        int T = Integer.parseInt(br.readLine());

        // 문제 풀이 시작
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][N];
            String[][] result = new String[N][3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    result[i][j] = "";
                }
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int turnNum = 0; turnNum < 3; turnNum++) {
                arr = trun2DMatrixRight90(arr);
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        // "" + int = String
                        result[i][turnNum] += arr[i][j];
                    }
                }
            }

            System.out.println("#" + test_case);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
