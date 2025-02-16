// 완전 이진 트리
class Heap {
	int[] arr;
	int cnt = 0;
	
    public Heap() {
        arr = new int[100001];
    }
	
    // 리프 노드에 값 추가 이후 더이상 올라갈 수 없을 만큼 올립니다.
    void offer(int data) {
    	arr[++cnt] = data;
    	int now = cnt;
    	while (now > 1) {
    		int parent = getParent(now);
    		// 힙 위치 조절 시간 복잡도 (트리의 높이) (int)Math.ceil(Math.log(n)/Math.log(2))
    		if (arr[now] > arr[parent]) {
    			int temp = arr[parent];
    			arr[parent] = arr[now];
    			arr[now] = temp;
    			now = parent;
    		} else {
    			break;
    		}
    	}
    }
    
	
	void heapify() {
		int now = 1;
		// 내려가지 못할때 까지 내립니다.
		// 왜? 오른쪽을 확인하지?
		while(getRight(now) <= cnt) {
			int larger = now;
			int left = getLeft(now);
			int right = getRight(now);
			
			if (arr[left] > arr[larger]) {
				larger = left;
			}
			
			if (arr[right] > arr[larger]) {
				larger = right;
			}
			
			if (larger != now) {
    			int temp = arr[larger];
    			arr[larger] = arr[now];
    			arr[now] = temp;
				now = larger;
			} else {
				break;
			}			
		}
	}
	
	int poll() {
		int max = arr[1];
		arr[1] = arr[cnt];
		arr[cnt--] = 0;
		// 힙을 다시 정렬 시켜야 합니다.
        heapify();
		return max;
	}
	
	boolean isEmpty() {
		return cnt == 0;
	}
	
	int getLeft(int parent) {
		return parent*2;
	}
	
	int getRight(int parent) {
		return parent*2 + 1;
	}
	int getParent(int child) {
		return child/2;
	}
	
}