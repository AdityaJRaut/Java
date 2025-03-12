package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamDemo {

	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		System.out.println(nums.stream().filter(n -> n % 2 == 0).findFirst());

	}

}
