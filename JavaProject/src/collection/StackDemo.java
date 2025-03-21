package collection;

import java.util.Stack;

public class StackDemo {

	public static boolean isValid(String s) {
		Stack<Character> str = new Stack<Character>();
		for (char ch : s.toCharArray()) {
			if (ch == '{' || ch == '[' || ch == '(') {
				str.push(ch);
			} else {
				if (str.isEmpty()) {
					return false;
				}

				char top = str.pop();
				if (ch == '}' && top != '{' || ch == ']' && top != '[' || ch == ')' && top != '(') {
					return false;
				}
			}
		}
		return str.isEmpty();
	}

	public static void main(String[] args) {
		String str = "]]";
		if (isValid(str)) {
			System.out.println("Valid String");
		} else {
			System.out.println("Invalid String");
		}
	}

}
