package march15;

import java.util.HashSet;
import java.util.Set;

public class RemoveElement {

	public static void main(String[] args) {
		Set<Integer> numbersSet=new HashSet<Integer>();
		numbersSet.add(10);
		numbersSet.add(20);
		numbersSet.add(30);
		numbersSet.add(40);
		numbersSet.add(50);
		System.out.println(numbersSet);
		numbersSet.remove(30);
		System.out.println(numbersSet);
	}

}
