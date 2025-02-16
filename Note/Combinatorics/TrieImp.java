import java.util.HashMap;
import java.util.Map;

class Trie {
	char alphabet; // 이 점점으로 이동하는 알파
	boolean isWordEnd; // 이 정점에서 끝나는 문자열이 존재 하는
	int cnt; // 이 정점을 root 로 하는 subtree에 포함된 문자열 개수

	Map<Character, Trie> children = new HashMap<Character, Trie>();

	Trie(char alphabet) {
		this.alphabet = alphabet;
		this.cnt = 0;
	}

	Trie() {
	}
}

public class TrieImp {
	static char[] results; // 이동하는 경로 위에 놓인 문자
	static int K;

	
	public static void main(String[] args) {
		Trie head = new Trie();
		String words = "testabc";
		int len = words.length();

		if (K > len) {
			print("none", 0);
			return;
		}

		for (int i = 0; i < len; i++) { // i 번째 문자에서 시작하는 접미열을 Trie에 반영
			Trie indexTrie = head;

			for (int j = i; j < len; j++) { // j 번째 문자로 이동하기
				char alphabet = words.charAt(j);
				if (!indexTrie.children.containsKey(alphabet)) { // 새로운 문자라면 정점 추가하기
					Trie newTrie = new Trie(alphabet);
					indexTrie.children.put(alphabet, newTrie);
				}
				indexTrie = indexTrie.children.get(alphabet);
				indexTrie.cnt++; // 하위 문자열 개수 증가
			}

			indexTrie.isWordEnd = true;
		}
		results = new char[len];
		dfs(head, 0, 0);
	}


	public static void dfs(Trie trie, int depth, int test_case) {
		if (K == 0)
			return;

		if (trie.isWordEnd) { // 해당 정점에서 끝나는 단어가 있다면
			K--;
			if (K == 0) { // 원하는 문자열에 도달했다면,
				String result = "";
				for (int i = 0; i < depth; i++) {
					result += results[i];
				}
				print(result, test_case);
				return;
			}
		}

		for (char i = 'a'; i <= 'z'; i++) { // 낮은 알파벳부터 하나씩 이동한다.
			if (trie.children.containsKey(i)) { // 해당 알파벳으로 이동할 수 있다면,
				Trie child = trie.children.get(i);
				if (child.cnt < K) { // 해당 정점으로 이동하더라도 K 개의 문자열보다 적은 개수의 문자열이 있다면,
					K -= child.cnt; // 빠르게 해당 개수만큼 skip 한다.
					continue;
				}

				results[depth] = i;
				dfs(child, depth + 1, test_case);
				results[depth] = '_';
			}
		}
	}

	// 결과 출력
	public static void print(String str, int test_case) {
		System.out.println("#" + test_case + " " + str);
	}
}
