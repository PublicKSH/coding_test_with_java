import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class BOJ10810 {
	public static void solution(String[] args) throws IOException {
		// String[]
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// input string �� �ٷ�� ���� String ��ü
		String[] st;
		st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]), m = Integer.parseInt(st[1]);
		int i,j,k;
		// 0 ���� �ʱ�ȭ �Ǿ����� -> primitive []
		int[] result = new int[n];
		
		// ���� 1 for ������ array[] ��
		for (int index = 0; index < m; index++) {
			st = br.readLine().split(" ");
			
			i = Integer.parseInt(st[0]);
			j = Integer.parseInt(st[1]);
			k = Integer.parseInt(st[2]);

			Arrays.fill(result, i-1, j, k);
		}
		
				
		System.out.println(Arrays.toString(result).replaceAll("[\\[\\],]", ""));
	}
}