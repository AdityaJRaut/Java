package generics;

public class GenericExample<T> {

	private T data;

	public GenericExample(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}
}
