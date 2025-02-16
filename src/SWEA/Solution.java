package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Trie {
	char alpabet;
	// 문자의 마지막인지 없으면 car와 cart 를 구별 할 수 없다.
	boolean isEnd;
	// 이 노드를 루트 노드로 하는 서브트리의 개
	int cnt;

	Map<Character, Trie> children = new HashMap<>();

	Trie(char alpabet) {
		this.alpabet = alpabet;
		this.cnt = 0;
	}

	Trie() {
	}
}

class Solution {
	static char[] results;
	static int K;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			K = Integer.parseInt(br.readLine());
			String s = br.readLine();
			int sLen = s.length();

			if (K > sLen) {
				System.out.printf("#%d %s", t, "none");
				continue;
			}

			Trie head = new Trie();

			for (int i = 0; i < sLen; i++) {
				// 새로운 문자열을 추가할 땐 해드부터 다시 돌아가서 넣
				Trie indexTrie = head;
				
				for (int j = i; j < sLen; j++) {
					char alphabet = s.charAt(j);
					// 없으면 만들어서 추가 합니다.
					if (!indexTrie.children.containsKey(alphabet)) {
						Trie newTrie = new Trie(alphabet);
						indexTrie.children.put(alphabet, newTrie);
					}
					
					// 계속 따라 들어가기
					indexTrie = indexTrie.children.get(alphabet);
					
					// indexTrie.cnt 를 증가 시키는 이유 => 여기 까지 왔다는건 분기가 갈라졌다는것 (중복되는 문자가 없다는 가정)
					indexTrie.cnt++;
				}
				
				indexTrie.isEnd = true;
			}
			
			// 여기까지가 Trie 생성 및 초기화 구현
			
			// 여기는 Trie 조회 구현 (BFS 사용)
			results = new char[sLen];
			dfs(head, 0, t);
		}
	}
	
	public static void dfs(Trie trie, int depth, int testCase) {
		// dfs의 종료 조건 -> K 번쨰 나오는 부분 문자열을 찾았 을때 
		if (K == 0) {
			return;
		}
		
		// (주의해당 노드에서 끝나는 문자가 있을 수도 있다.)
		if (trie.isEnd) {
			K--;
			if (K==0) {
				String result = "";
				for (int i = 0; i<depth; i++) {
					result+=results[i];
				}
				System.out.println("#"+ testCase + " " + result);
			}
		}
		
		// a부터 차근 차근 조회 - 사전순 조회
		for (char c = 'a'; c <'z'; c++) {
			// 만약 내려갈 수 있다면??
			if(trie.children.containsKey(c)) {
				Trie child = trie.children.get(c);
				// K 번째를 찾는 코드 (굳이 내려가지 않는다)
				if (child.cnt < K) {
					K -= child.cnt;
					continue;
				}
				
				results[depth] = c;
				dfs(child, depth+1, testCase);
				results[depth] = '_';
			}
		}
	}
}
