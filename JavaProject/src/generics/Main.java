package generics;

public class Main {

	public static void main(String[] args) {
		GenericExample<Integer> intObj = new GenericExample<Integer>(5);
		GenericExample<String> strObj = new GenericExample<String>("Aditya");
		System.out.println("Integer " + intObj.getData());
		System.out.println("String " + strObj.getData());

	}

}
