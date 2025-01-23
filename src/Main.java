import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Integer[] integerArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		String[] stringArr = { "a", "a", "a", "a", "a" };
		List<Integer> integerList = Arrays.asList(integerArr);
		
		System.out.println(integerList.contains(1));
	}
}