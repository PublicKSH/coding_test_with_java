import java.io.BufferedReader;
import java.io.InputStreamReader;
// 스스로 코드에 대한 피드백 -> for(cnt=1;;cnt++) {} fmf while 문을 대신해서 쓰면 훨씬
// 간결하게 코드를 작성할 수 있다. -> 단 cnt가 증가 해야하는 경우
// 언제까지 즐가할지 모르는 숫자는 String으로 판별하자
class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int total = (1 << 10) - 1;
		for (int test_case = 1; test_case <= T; test_case++) {
			// 1 ~ 9 범위의 조합 -> 비트 마스크
			int set = 0;
			int N = Integer.parseInt(br.readLine());
			int cnt = 0;
			// 무한 루프를 돌거나 int를 초과하는 값까지 가야하는 경우의수는 베재 -> D2 난이도
			
			while (set != total) {
				int nowNum = (cnt + 1) * N;

				while (nowNum > 0) {
					set |= (1 << (nowNum % 10));
					nowNum /= 10;
				}

				cnt++;
			}

			System.out.printf("#%d %d\n", test_case, cnt * N);
		}
	}
}