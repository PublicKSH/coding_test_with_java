// 이분탐색에서 중요한것은 구간을 항상 T/F로 나누어서 생각하는 것이다
// 만약 arr[m] < key, arr[m] == key, arr[m] > key 처럼 구간을 3개로 
// 나누어서 생각한다면 => 무한 루프가 되거나 , 어느 한점은 탐색하지 않고 건너뛰는 상황이 존재할 수도 있음

// 이분탐색에서 가져갈 것은 아래의 3가지
// 1. 그냥 기본 BinarySearch
// 2. Lower Upper bound
// 3. Parametric Search
public class BinarySearch {
	public static int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length; // 탐색 구간: [left, right)

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left; // target 이상인 첫 번째 위치 반환
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 3, 5, 7, 9, 11, 13, 15};
        int target = 17;
        int result = lowerBound(sortedArray, target);
        System.out.println("lower_bound 위치: " + result);
    }
}
